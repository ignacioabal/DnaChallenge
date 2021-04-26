package com.ignacioabal.MeliChallenge.DnaAnalyzer;

import com.ignacioabal.MeliChallenge.DnaIterator.DnaIterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaAnalyzerTest {
    private final DnaAnalyzer dnaAnalyzer = new DnaAnalyzer();

    @Test
    void isMutant_true_dnaHasMutantSequences(){
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};

        assertTrue(dnaAnalyzer.isMutant(dnaString));
    }

    @Test
    void isMutant_true_dnaHasNoMutantSequences(){
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTGTCT",
                "AGAAGG",
                "CCACTA",
                "TCACTG"};

        assertFalse(dnaAnalyzer.isMutant(dnaString));
    }

    @Test
    void isMutant_true_returnsFalseIfDnaIsNull(){
        assertFalse(dnaAnalyzer.isMutant(null));
    }

}