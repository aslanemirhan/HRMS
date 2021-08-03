package backend.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement,Integer>{

	 	List<JobAnnouncement> findAllByCity_Id(int cityId);
	    List<JobAnnouncement> findAllByJobTitle_Id(int jobTitleId);
	    List<JobAnnouncement> findAllByEmployer_IdAndIsActiveTrue(int employerId);
	    List<JobAnnouncement> findAllByIsActiveTrueOrderByAnnouncementDeadlineDesc();
	    List<JobAnnouncement> findAllByAnnouncementDeadlineLessThanEqual(LocalDate date);
	    
//	    List<JobAnnouncement> findAllByAnnouncementDeadlineBefore(LocalDate date); -> Eğer bu şekilde verirsek Swagger tarafında, istenilen günden bir gün sonrasını girmek gerekir.

//	    @Query("FROM JobAnnouncement where employer.id=:employerId and isActive=true order by announcementPublishedAt ASC")
//	    List<JobAnnouncement> findAllByActiveAndAnnouncementPublishedAt(int employerId);
}
