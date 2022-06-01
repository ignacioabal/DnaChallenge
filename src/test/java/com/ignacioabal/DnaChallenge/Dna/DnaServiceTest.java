package com.ignacioabal.DnaChallenge.Dna;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class DnaServiceTest {

    @Mock
    private Dna mockDna;
    @Mock
    private DnaRepository dnaRepositoryMock;

    private AutoCloseable autoCloseable;
    private DnaService dnaService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        dnaService = new DnaService(dnaRepositoryMock);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void analyzeDna_verifyDnaClassMethodsAreCalled() {
        dnaService.analyzeDna(mockDna);

        verify(mockDna).isDnaMutant();
        verify(mockDna).parseDnaArrayToString();
    }

    @Test
    void analyzeDna_verifyDnaRepositoryMethodIsCalled() {
        Dna dna = setupDnaInstance(true);
        dnaService.analyzeDna(dna);

        verify(dnaRepositoryMock).save(dna);

    }

    @Test
    void getDatabaseStatistics_verifyRepositoryCallsAreMade() {
        dnaService.getDatabaseStatistics();

        verify(dnaRepositoryMock).countHumanRecords();
        verify(dnaRepositoryMock).countMutantRecords();
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