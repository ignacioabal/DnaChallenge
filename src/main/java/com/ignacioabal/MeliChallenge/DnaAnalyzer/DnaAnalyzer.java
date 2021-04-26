package com.ignacioabal.MeliChallenge.DnaAnalyzer;

import com.ignacioabal.MeliChallenge.DnaIterator.DnaColumnIterator;
import com.ignacioabal.MeliChallenge.DnaIterator.DnaDiagonalIterator;
import com.ignacioabal.MeliChallenge.DnaIterator.DnaIterator;
import com.ignacioabal.MeliChallenge.DnaIterator.DnaRowIterator;

public class DnaAnalyzer {
    private DnaIterator RowIterator;
    private DnaIterator ColumnIterator;
    private DnaIterator DiagonalIterator;

    public DnaAnalyzer(){
        InstantiateIterators();
    }

    public boolean isMutant(String[] dna){
        int totalMutantSequences = 0;
        totalMutantSequences += RowIterator.findMutantSequences(dna);
        totalMutantSequences += ColumnIterator.findMutantSequences(dna);
        totalMutantSequences += DiagonalIterator.findMutantSequences(dna);

        return totalMutantSequences > 2;
    }

    private void InstantiateIterators(){
        this.RowIterator = new DnaRowIterator();
        this.ColumnIterator = new DnaColumnIterator();
        this.DiagonalIterator = new DnaDiagonalIterator();
    }
}
