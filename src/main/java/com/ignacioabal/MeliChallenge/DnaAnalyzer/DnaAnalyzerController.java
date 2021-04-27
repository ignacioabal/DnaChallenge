package com.ignacioabal.MeliChallenge.DnaAnalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("mutant/")
public class DnaAnalyzerController {
    private final DnaAnalyzer dnaAnalyzer = new DnaAnalyzer();

    public DnaAnalyzerController() {
    }

    @PostMapping
    public ResponseEntity isMutant(@RequestBody Dna dna){
        if(dnaAnalyzer.isMutant(dna.dna)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

    }

}
