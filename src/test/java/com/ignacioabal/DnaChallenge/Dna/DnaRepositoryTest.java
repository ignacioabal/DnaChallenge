package com.ignacioabal.DnaChallenge.Dna;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DnaRepositoryTest {

    @Autowired
    DnaRepository dnaRepository;

    @Test
    void countMutantRecords_ShouldCountOneMutantRecordIfMutantRecordInserted() {
        Dna dna = setupDnaInstance(true);

        dnaRepository.save(dna);

        assertEquals(1, dnaRepository.countMutantRecords());
        assertEquals(0, dnaRepository.countHumanRecords());
    }

    @Test
    void countHumanRecords_ShouldCountOneMutantRecordIfMutantRecordInserted() {
        Dna dna = setupDnaInstance(false);


        dnaRepository.save(dna);

        assertEquals(0, dnaRepository.countMutantRecords());
        assertEquals(1, dnaRepository.countHumanRecords());
    }

    @Test
    void dnaRecordExists_ShouldOnlyReturnRecordIfExists() {
        Dna dna = setupDnaInstance(false);

        assertFalse(dnaRepository.dnaRecordExists(dna));

        dnaRepository.save(dna);

        assertTrue(dnaRepository.dnaRecordExists(dna));
    }

    Dna setupDnaInstance(boolean isMutant) {
        Dna dna = new Dna();
        dna.setDna(new String[]{
                "ATGCGA",
                "CGGTCC",
                "TTATGT",
                "ACAAGG",
                "CTCCTA",
                "TCACTG"});
        dna.setMutant(isMutant);
        dna.parseDnaArrayToString();

        return dna;
    }
}