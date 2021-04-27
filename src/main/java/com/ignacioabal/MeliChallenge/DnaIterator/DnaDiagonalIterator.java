package com.ignacioabal.MeliChallenge.DnaIterator;

public class DnaDiagonalIterator implements DnaIterator{
    protected int mutantSequences = 0;
    final int MUTANT_DNA_LETTER_REPETITIONS = 4;

    public DnaDiagonalIterator() {

    }

    @Override
    public int findMutantSequences(String[] dna) {
        if(dna == null) return 0;

        int amountOfStrings = dna.length;
        int rowLenght = dna[0].length();

        for(int i =- (amountOfStrings-1);i < rowLenght-1;i++){
            String previousLetter = "";
            int currentLetterRepetitions = 0;

            int letterIndex = i-1;
            for (String dnaString: dna) {

                if(letterIndex < 0){
                    letterIndex++;
                    continue;
                }
                if(letterIndex >= rowLenght){
                    continue;
                }

               String currentLetter = dnaString.split("")[letterIndex];

               if(previousLetter.equals("")){
                   previousLetter = currentLetter;
                   currentLetterRepetitions++;
                   letterIndex++;
                   continue;
               }

                if(currentLetterRepetitions == MUTANT_DNA_LETTER_REPETITIONS){
                    mutantSequences++;
                    currentLetterRepetitions=0;
                    letterIndex++;
                    continue;
                }

                if(currentLetter.equals(previousLetter)){
                    currentLetterRepetitions++;
                }else{
                    previousLetter=currentLetter;
                    currentLetterRepetitions=0;
                }
                letterIndex++;

            }

        }

        return mutantSequences;
    }

    @Override
    public int getMutantSequences() {
        return mutantSequences;
    }
}
