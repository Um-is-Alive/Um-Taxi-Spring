package umtaxi.springserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umtaxi.springserver.model.MatchEntity;
import umtaxi.springserver.repository.MatchRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    @Autowired
    MatchService(MatchRepository matchRepository) { this.matchRepository = matchRepository; }

    @Transactional
    public void addMatch(MatchEntity matchEntity){
        this.matchRepository.save(matchEntity);
    }

    public MatchEntity getMatch(long id){

        Optional<MatchEntity> match = matchRepository.findMatchEntitiesByTaxiId(id);
        if(!match.isPresent()) return null;
        return match.get();
    }


}
