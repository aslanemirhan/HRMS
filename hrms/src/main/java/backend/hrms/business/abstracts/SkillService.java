package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Skill;

public interface SkillService {

	DataResult<List<Skill>> getSkillsByCandidateId(int candidateId);
    Result addSkill(Skill skill);
}
