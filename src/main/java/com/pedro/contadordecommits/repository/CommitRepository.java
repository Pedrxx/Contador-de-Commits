package com.pedro.contadordecommits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.contadordecommits.entity.Commit;

public interface CommitRepository extends JpaRepository<Commit,Long> {

}