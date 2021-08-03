package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.LinkService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.LinkDao;
import backend.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public DataResult<List<Link>> getLinksByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Link>>(this.linkDao.findAllByCandidateId(candidateId));
    }

    @Override
    public Result addLink(Link link) {
        this.linkDao.save(link);
        return new SuccessResult();
    }

}
