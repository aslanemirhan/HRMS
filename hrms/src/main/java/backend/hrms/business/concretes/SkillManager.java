package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.SkillService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.SkillDao;
import backend.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	
	private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }


    @Override
    public DataResult<List<Skill>> getSkillsByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Skill>>(this.skillDao.findAllByCandidateId(candidateId));
    }

    @Override
    public Result addSkill(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult();
    }
}
