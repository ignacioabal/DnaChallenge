package com.ignacioabal.MeliChallenge.DnaIterator;

public class DnaColumnIterator implements DnaIterator{
    protected int mutantSequences = 0;


    public DnaColumnIterator() {
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
