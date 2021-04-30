package com.ignacioabal.MeliChallenge.Dna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {


    @Query(value = "SELECT COUNT(*) FROM dna WHERE dna.is_mutant='t'", nativeQuery = true)
    int countMutantRecords();

    @Query(value = "SELECT COUNT(*) FROM dna WHERE dna.is_mutant='f'",nativeQuery = true)
    int countHumanRecords();

    @Query(value = "SELECT EXISTS(SELECT * FROM dna WHERE dna.dna=:#{#inputDna.dnaString})",nativeQuery = true)
    boolean dnaRecordExists(@Param("inputDna")Dna dna);
}
