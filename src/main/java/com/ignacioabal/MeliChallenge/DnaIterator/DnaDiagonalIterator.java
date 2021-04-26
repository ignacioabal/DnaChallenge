package com.ignacioabal.MeliChallenge.DnaIterator;

public class DnaDiagonalIterator implements DnaIterator{
    protected int mutantSequences = 0;

    public DnaDiagonalIterator() {

    }

    @Override
    public int findMutantSequences(String[] dna) {
        return 0;
    }

    @Override
    public int getMutantSequences() {
        return mutantSequences;
    }
}
