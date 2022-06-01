package com.ignacioabal.DnaChallenge.DnaAnalyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DnaAnalyzerTest {

    private AutoCloseable autoCloseable;

    /*
    * isMutant
    */
    @Test
    void isMutant_dnaHasMutantSequences(){
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};

        assertTrue(DnaAnalyzer.isMutant(dnaString));
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

        assertFalse(DnaAnalyzer.isMutant(dnaString));
    }

    @Test
    void isMutant_true_returnsFalseIfDnaIsNull(){
        assertFalse(DnaAnalyzer.isMutant(null));
    }

    /*
    * isDnaValidForAnalysis
    */
    @Test
    void isDnaValidForAnalysis_ShouldReturnFalseWhenDnaIsNull(){
        assertFalse(DnaAnalyzer.isDnaValidForAnalysis(null));
    }

    @Test
    void isDnaValidForAnalysis_ShouldReturnFalseIfDnaHasDifferentRowLengths(){
        String[] dnaString = {
                "ATG",
                "CAGT",
                "TTATT",
                "GTTA"};

        assertFalse(DnaAnalyzer.isDnaValidForAnalysis(dnaString));
    }

    @Test
    void isDnaValidForAnalysis_shouldReturnTrueOnValidDna(){
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};

        String[] dnaString2 = {
                "ATGCGA",
                "CAGTGC",
                "TTGTCT",
                "AGAAGG",
                "CCACTA",
                "TCACTG"};

        assertTrue(DnaAnalyzer.isDnaValidForAnalysis(dnaString));
        assertTrue(DnaAnalyzer.isDnaValidForAnalysis(dnaString2));

    }

    @Test
    void isDnaValidForAnalysis() {
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};
        assertFalse(DnaAnalyzer.isDnaValidForAnalysis(null));
        assertTrue(DnaAnalyzer.isDnaValidForAnalysis(dnaString));
    }
}