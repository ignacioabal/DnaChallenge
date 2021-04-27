package com.ignacioabal.MeliChallenge.DnaIterator;

public class DnaRowIterator implements DnaIterator{
    private int mutantSequences = 0;
    final int MUTANT_DNA_LETTER_REPETITIONS = 4;

    public DnaRowIterator() {
    }

    @Override
    public int findMutantSequences(String[] dna) {
        if(dna == null) return 0;


        for (String dnaString: dna) {
            int rowLength = dnaString.length();
            String[] row= dnaString.split("");
            String previousLetter = "";
            int currentLetterRepetitions = 0;

            for(int i = 0; i < rowLength;i++){
                String currentLetter = row[i];
                if(i == 0){
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
