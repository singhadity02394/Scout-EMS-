package com.scouttribe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scouttribe.entity.EventProvider;

public interface EventProviderRepository extends JpaRepository<EventProvider, Long> {
}

