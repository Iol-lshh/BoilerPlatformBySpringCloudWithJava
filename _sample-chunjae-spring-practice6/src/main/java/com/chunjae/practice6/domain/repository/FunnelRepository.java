package com.chunjae.practice6.domain.repository;

import com.chunjae.practice6.domain.entity.Funnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunnelRepository extends JpaRepository<Funnel, Long> {
}
