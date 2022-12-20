package com.chunjae.practice6.domain.repository;

import com.chunjae.practice6.domain.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, Long> {
}
