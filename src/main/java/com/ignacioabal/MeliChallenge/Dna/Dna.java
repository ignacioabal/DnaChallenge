package com.ignacioabal.MeliChallenge.Dna;

import com.ignacioabal.MeliChallenge.DnaAnalyzer.DnaAnalyzer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.web.bind.annotation.GetMapping;

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

    @Column(name = "dna")
    public String dnaString;

    @Column
    public boolean isMutant;

    @Transient
    public boolean isDnaMutant(){
        if(!DnaAnalyzer.isDnaValidForAnalysis(dna)) return false;
        isMutant = DnaAnalyzer.isMutant(dna);
        return isMutant;
    }

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
