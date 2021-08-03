package backend.hrms.entities.dtos;

import java.util.List;

import backend.hrms.entities.concretes.Candidate;
import backend.hrms.entities.concretes.CurriculumVitae;
import backend.hrms.entities.concretes.Education;
import backend.hrms.entities.concretes.ForeignLanguage;
import backend.hrms.entities.concretes.JobExperience;
import backend.hrms.entities.concretes.Link;
import backend.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeDto {

		private Candidate candidate;
//	    private CandidateImage candidateImage;
	    private List<Education> educationList;
	    private List<JobExperience> jobExperienceList;
	    private List<Skill> skillList;
	    private List<ForeignLanguage> foreignLanguageList;
	    private List<Link> links;
	    private List<CurriculumVitae> curriculumVitaeList;
}
