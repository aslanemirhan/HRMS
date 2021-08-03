package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Link;

public interface LinkService {

	DataResult<List<Link>> getLinksByCandidateId(int candidateId);
    Result addLink(Link link);
}
