package com.ignacioabal.MeliChallenge.Dna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DnaService {
    private final DnaRepository dnaRepository;

    @Autowired
    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public void analyzeDna(Dna dna){
        dna.isDnaMutant();
        dna.parseDnaArrayToString();
        if(dna.getDna() != null && !dnaRecordExists(dna)){
            dnaRepository.save(dna);
        }
    }

    public Map<String,String> getDatabaseStatistics(){
        int mutantCount = dnaRepository.countMutantRecords();
        int humanCount = dnaRepository.countHumanRecords();
        double ratio = (mutantCount/(double)humanCount);

        Map<String,String> responseBody = new HashMap<>();
        responseBody.put("count_mutant_dna",String.valueOf(mutantCount));
        responseBody.put("count_human_dna",String.valueOf(humanCount));
        responseBody.put("ratio",String.valueOf(ratio));

        return responseBody;
    }

    private boolean dnaRecordExists(Dna dna){
       return dnaRepository.dnaRecordExists(dna);
    }

}
