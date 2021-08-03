package backend.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.JobAnnouncementService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.JobAnnouncementDao;
import backend.hrms.entities.concretes.JobAnnouncement;

@Service
public class JobAnnouncementManager implements JobAnnouncementService{

	private JobAnnouncementDao jobAnnouncementDao;
	
	@Autowired 
	public JobAnnouncementManager(JobAnnouncementDao jobAnnouncementDao) {
		super();
		this.jobAnnouncementDao = jobAnnouncementDao;
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAllByCityName(int cityId) {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByCity_Id(cityId));
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAllByJobTitle(int jobTitleId) {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByJobTitle_Id(jobTitleId));
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAllByActive() {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByIsActiveTrueOrderByAnnouncementDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAllByActiveAndEmployer(int employerId) {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByEmployer_IdAndIsActiveTrue(employerId));
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAllByAnnouncementDeadline(LocalDate date) {
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAllByAnnouncementDeadlineLessThanEqual(date));
	}

	@Override
	public Result addJobAnnouncement(JobAnnouncement jobAnnouncement) {
		this.jobAnnouncementDao.save(jobAnnouncement);
		return new SuccessResult("Added");
	}

	@Override
	public Result publishJobAnnouncement(int jobAnnouncementId) {
		JobAnnouncement publishedJobAnnouncement = this.jobAnnouncementDao.findById(jobAnnouncementId).get();
        publishedJobAnnouncement.setActive(true);
        publishedJobAnnouncement.setAnnouncementPublishedAt(LocalDate.now());
        this.jobAnnouncementDao.save(publishedJobAnnouncement);
        return new SuccessResult("The announcement has been published.");
	}

	@Override
	public Result setPassiveJobAnnouncement(int jobAnnouncementId) {
		JobAnnouncement doPassivedJobAnnouncement = this.jobAnnouncementDao.findById(jobAnnouncementId).get();
        doPassivedJobAnnouncement.setActive(!doPassivedJobAnnouncement.isActive());
        this.jobAnnouncementDao.save(doPassivedJobAnnouncement);
        return new SuccessResult("The announcement has been deactivated.");
	}

}
