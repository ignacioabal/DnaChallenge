package com.ignacioabal.DnaChallenge.DnaIterator;

public class DnaIterator {
      final int MUTANT_DNA_LETTER_REPETITIONS = 4;
      private int mutantSequences;
      private String[] dna;


     public DnaIterator(String[] dna) {
          this.dna = dna;
          mutantSequences = 0;
     }


     /**
      * @return {@code int} Number of mutant sequences found in Dna.
      */
     public int findMutantSequences(){
          if(dna == null) return 0;

          findMutantSequencesInRows();
          findMutantSequencesInColumns();
          findMutantSequencesInDiagonals();

          return mutantSequences;
     }


     /**
      * Finds mutant sequences in Dna rows.
      */
     private void findMutantSequencesInRows(){
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
   }

     /**
      * Finds mutant sequences in Dna's Columns.
      */
     private void findMutantSequencesInColumns() {
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
     }

     /**
      * Finds mutant sequences in Dna's diagonals.
      */
     private void findMutantSequencesInDiagonals() {
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
     }

     public void setDna(String[] dna) {
          this.dna = dna;
     }
}
