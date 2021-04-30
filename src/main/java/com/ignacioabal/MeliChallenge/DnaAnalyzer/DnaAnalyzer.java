package com.ignacioabal.MeliChallenge.DnaAnalyzer;

import com.ignacioabal.MeliChallenge.DnaIterator.DnaIterator;

public class DnaAnalyzer {

    /**
     * @param dna Dna to check if it's mutant.
     * @return {@code true} If Dna string is mutant.
     */
    public static boolean isMutant(String[] dna){
        DnaIterator dnaIterator = new DnaIterator(dna);
        int totalMutantSequences = dnaIterator.findMutantSequences();
        return totalMutantSequences > 2;
    }


    /**
     * @param dna Dna string Array to validate for analysis.
     * @return {@code true} If Dna is valid for analysis.
     */
    public static boolean isDnaValidForAnalysis(String[] dna){
        if(dna == null) return false;
        return areAllDnaRowsSameLength(dna);
    }

    /**
     * @param dna Dna string to validate.
     * @return {@code true} If all dna string rows are equal in length.
     */
    private static boolean areAllDnaRowsSameLength(String[] dna){
        int firstRowLength = dna[0].length();

        for(String dnaString: dna){
            if(dnaString.length() != firstRowLength) return false;
        }

        return true;
    }
}
