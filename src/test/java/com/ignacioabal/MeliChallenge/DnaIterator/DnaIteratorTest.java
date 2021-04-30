package com.ignacioabal.MeliChallenge.DnaIterator;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DnaIteratorTest {
    @Test
    void findMutantSequences_true_DnaStringHasMutantSequences() {
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};

        String[] dnaString1 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};
        String[] dnaString2 = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};

        DnaIterator dnaIterator = new DnaIterator(dnaString);

        assertEquals(dnaIterator.findMutantSequences(), 3);

        dnaIterator = new DnaIterator(dnaString1);

        assertEquals(dnaIterator.findMutantSequences(), 3);

    }

    @Test
    void findMutantSequences_true_DnaStringHasNoMutantSequences() {
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTGTCT",
                "AGAAGG",
                "CCACTA",
                "TCACTG"};

        DnaIterator dnaIterator = new DnaIterator(dnaString);

        assertEquals(dnaIterator.findMutantSequences(), 0);
    }

    @Test
    void findMutantSequences_true_ShouldNotThrowExceptionIfDnaStringIsNull(){
        DnaIterator dnaIterator = new DnaIterator(null);

        assertEquals(dnaIterator.findMutantSequences(), 0);
    }

    @Test
    void findMutantSequences_true_ShouldNotThrowIndexOutOfBoundsOnSmallDnaStrings(){
        String[] dnaString = {
                "ATGC",
                "CAGT",
                "TTGT"};



        DnaIterator dnaIterator = new DnaIterator(dnaString);

        assertEquals(dnaIterator.findMutantSequences(), 0);
    }

    @Test
    void findMutantSequences_true_shouldNotThrowExceptionIfStringLengthVaries(){
        String[] dnaString = {
                "ATG",
                "CAGT",
                "TTATT",
                "GTTA"};

        DnaIterator dnaIterator = new DnaIterator(dnaString);

        assertEquals(dnaIterator.findMutantSequences(), 0);
    }


}