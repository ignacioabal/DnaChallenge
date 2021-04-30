package com.ignacioabal.MeliChallenge.Dna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

    /**
     * Queries the amount of mutant records in the database.
     *
     * @return {@code int} number of Mutant records in the database.
     */
    @Query(value = "SELECT COUNT(*) FROM dna WHERE dna.is_mutant='t'", nativeQuery = true)
    int countMutantRecords();


    /**
     * Queries the amount of human records in the database.
     *
     * @return {@code int} number of human records in the database.
     */
    @Query(value = "SELECT COUNT(*) FROM dna WHERE dna.is_mutant='f'",nativeQuery = true)
    int countHumanRecords();

    /**
     * Searches for a record in the database with the input dna.
     *
     * @param dna input dna to search for in the database.
     * @return {@code true} If record exists
     */
    @Query(value = "SELECT EXISTS(SELECT * FROM dna WHERE dna.dna=:#{#inputDna.dnaString})",nativeQuery = true)
    boolean dnaRecordExists(@Param("inputDna")Dna dna);
}
