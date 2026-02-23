package com.ticketing.backend.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketing.backend.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByNameIgnoreCase(String name);
}