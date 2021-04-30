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

    /**
     * Analyzes a Dna class to see if it's mutant.
     *
     * @param dna Dna to analyze.
     */
    public void analyzeDna(Dna dna){
        dna.isDnaMutant();
        dna.parseDnaArrayToString();
        if(dna.getDna() != null && !dnaRecordExists(dna)){
            dnaRepository.save(dna);
        }
    }

    /**
     * @return {@code Map<String, String>} with number of human, mutant DNA's and the mutant-to-human ratio.
     */
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

    /**
     * @param dna Dna data to search for in the database.
     * @return {@code true} if dna record exists in databse.
     */
    private boolean dnaRecordExists(Dna dna){
       return dnaRepository.dnaRecordExists(dna);
    }

}
