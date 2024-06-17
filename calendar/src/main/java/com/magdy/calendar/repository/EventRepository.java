package com.magdy.calendar.repository;

import com.magdy.calendar.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Event> findByScheduleId(Long scheduleId);
}
