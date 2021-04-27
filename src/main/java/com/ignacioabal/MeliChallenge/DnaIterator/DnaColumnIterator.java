package com.ignacioabal.MeliChallenge.DnaIterator;

public class DnaColumnIterator implements DnaIterator {
    protected int mutantSequences = 0;
    final int MUTANT_DNA_LETTER_REPETITIONS = 4;


    public DnaColumnIterator() {
    }

    @Override
    public int findMutantSequences(String[] dna) {
        if (dna == null) return 0;


        int rowLength = dna[0].length();

        for (int LetterPosition = 0; LetterPosition < rowLength; LetterPosition++) {
            String previousLetter = "";
            int currentLetterRepetitions = 0;

            for (String dnaString : dna) {
                String currentLetter = dnaString.split("")[LetterPosition];

                if(previousLetter.equals("")){
                    currentLetterRepetitions++;
                    previousLetter=currentLetter;
                    continue;
                }

                if(currentLetterRepetitions == MUTANT_DNA_LETTER_REPETITIONS){
                    mutantSequences++;
                    currentLetterRepetitions=0;
                    continue;
                }

                if(currentLetter.equals(previousLetter)){
                    currentLetterRepetitions++;
                }else{
                    previousLetter=currentLetter;
                    currentLetterRepetitions=0;
                }

            }
        }


        return mutantSequences;
    }

    @Override
    public int getMutantSequences() {
        return mutantSequences;
    }


}
