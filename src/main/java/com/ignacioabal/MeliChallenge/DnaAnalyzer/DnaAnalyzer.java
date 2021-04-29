package com.ignacioabal.MeliChallenge.DnaAnalyzer;

import com.ignacioabal.MeliChallenge.DnaIterator.DnaIterator;

public class DnaAnalyzer {

    public static boolean isMutant(String[] dna){
        DnaIterator dnaIterator = new DnaIterator(dna);
        int totalMutantSequences = dnaIterator.findMutantSequences();
        return totalMutantSequences > 2;
    }

    public static boolean isDnaValidForAnalysis(String[] dna){
        if(dna == null) return false;
        return areAllDnaRowsSameLength(dna);
    }

    private static boolean areAllDnaRowsSameLength(String[] dna){
        int firstRowLength = dna[0].length();

        for(String dnaString: dna){
            if(dnaString.length() != firstRowLength) return false;
        }

        return true;
    }
}
