package com.ignacioabal.MeliChallenge.Dna;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class DnaController {
    private final DnaService dnaService;

    @Autowired
    public DnaController(DnaService dnaService) {
        this.dnaService = dnaService;
    }

    @PostMapping("/mutant")
    public ResponseEntity isMutant(@RequestBody Dna dna){
        dnaService.analyzeDna(dna);
        if(dna.isMutant){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/stats")
    public Map<String, String> getStatistics(){
        return dnaService.getDatabaseStatistics();
    }



}
