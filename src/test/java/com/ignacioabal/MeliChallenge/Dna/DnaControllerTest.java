package com.ignacioabal.MeliChallenge.Dna;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

class DnaControllerTest {

    @Mock
    private DnaService dnaService;
    @Mock
    private Dna dna;
    @Autowired
    private DnaController dnaController;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        dnaController = new DnaController(dnaService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void isMutant_verifyDnaServiceAndDnaClassMethodCalls() {
        dnaController.isMutant(dna);

        verify(dnaService).analyzeDna(dna);
        verify(dna).isMutant();
    }

    @Test
    void getStatistics() {
        dnaController.getStatistics();
        verify(dnaService).getDatabaseStatistics();
    }
}