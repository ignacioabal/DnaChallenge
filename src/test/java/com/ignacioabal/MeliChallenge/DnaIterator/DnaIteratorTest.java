package com.ignacioabal.MeliChallenge.DnaIterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaIteratorTest {
    private final DnaIterator RowIterator = new DnaRowIterator();
    private final DnaIterator ColumnIterator = new DnaColumnIterator();
    private final DnaIterator DiagonalIterator = new DnaDiagonalIterator();

    @Test
    void findMutantSequences_true_DnaStringHasMutantSequences() {
        String[] dnaString = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"};
        assertEquals(RowIterator.findMutantSequences(dnaString), 1);
        assertEquals(ColumnIterator.findMutantSequences(dnaString),1);
        assertEquals(DiagonalIterator.findMutantSequences(dnaString),1);
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
        assertEquals(0,RowIterator.findMutantSequences(dnaString));
        assertEquals(0,ColumnIterator.findMutantSequences(dnaString));
        assertEquals(0,DiagonalIterator.findMutantSequences(dnaString));
    }

    @Test
    void findMutantSequences_true_ShouldNotThrowExceptionIfDnaStringIsNull(){
//        assertThrows(NullPointerException.class,() ->{RowIterator.findMutantSequences(null);});
//        assertThrows(NullPointerException.class,() ->{ColumnIterator.findMutantSequences(null);});
//        assertThrows(NullPointerException.class,() ->{DiagonalIterator.findMutantSequences(null);});

        assertEquals(0,RowIterator.findMutantSequences(null));
        assertEquals(0,ColumnIterator.findMutantSequences(null));
        assertEquals(0,DiagonalIterator.findMutantSequences(null));

    }

    @Test
    void findMutantSequences_true_ShouldNotThrowIndexOutOfBoundsOnSmallDnaStrings(){
        String[] dnaString = {
                "ATGC",
                "CAGT",
                "TTGT"};
        assertEquals(0,RowIterator.findMutantSequences(dnaString));
        assertEquals(0,ColumnIterator.findMutantSequences(dnaString));
        assertEquals(0,DiagonalIterator.findMutantSequences(dnaString));
    }

    @Test
    void findMutantSequences_true_shouldThrowExceptionIfStringLengthVaries(){
        String[] dnaString = {
                "ATG",
                "CAGT",
                "TTATT",
                "GTTA"};
        assertEquals(0,RowIterator.findMutantSequences(dnaString));
        assertEquals(0,ColumnIterator.findMutantSequences(dnaString));
        assertEquals(0,DiagonalIterator.findMutantSequences(dnaString));
    }


}