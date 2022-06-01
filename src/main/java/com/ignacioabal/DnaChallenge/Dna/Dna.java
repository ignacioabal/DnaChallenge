package com.ignacioabal.DnaChallenge.Dna;

import com.ignacioabal.DnaChallenge.DnaAnalyzer.DnaAnalyzer;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class Dna{
    @Id
    @SequenceGenerator(name="dna_sequence", sequenceName = "dna_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dna_sequence")
    public long id;

    @Transient
    public String[] dna;

    @NotNull
    @Column(name = "dna")
    public String dnaString;

    @NotNull
    @Column
    public boolean isMutant;

    @Transient
    public void isDnaMutant(){
        if(!DnaAnalyzer.isDnaValidForAnalysis(dna)) return;
        isMutant = DnaAnalyzer.isMutant(dna);
    }

    /*
    * Parses the class' Dna property from an array of Strings to a String value.
    *
    * */
    @Transient
    public void parseDnaArrayToString(){
        StringBuffer stringBuffer = new StringBuffer();
        for(String dnaString: dna){
            stringBuffer.append(dnaString).append(",");
        }
        dnaString = stringBuffer.toString();
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }

    @Override
    public String toString() {
        return "Dna{" +
                "dna=" + Arrays.toString(dna) +
                ", isMutant=" + isMutant +
                '}';
    }
}
