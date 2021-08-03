package backend.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementService {

		DataResult<List<JobAnnouncement>> getAllByCityName(int cityId);
	    DataResult<List<JobAnnouncement>> getAllByJobTitle(int jobTitleId);
	    DataResult<List<JobAnnouncement>> getAllByActive();
	    DataResult<List<JobAnnouncement>> getAllByActiveAndEmployer(int employerId);
	    DataResult<List<JobAnnouncement>> getAllByAnnouncementDeadline(LocalDate date);
	    Result addJobAnnouncement(JobAnnouncement jobAnnouncement);
	    Result publishJobAnnouncement(int jobAnnouncementId);
	    Result setPassiveJobAnnouncement(int jobAnnouncementId);
	
}
