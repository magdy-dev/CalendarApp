package com.magdy.calendar.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.magdy.calendar.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class EventDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Event> getAllEvents() {
        TypedQuery<Event> query = entityManager.createQuery("SELECT e FROM Event e", Event.class);
        return query.getResultList();
    }

    public Event getEventById(Long id) {
        return entityManager.find(Event.class, id);
    }

    public Event createEvent(Event event) {
        entityManager.persist(event);
        return event;
    }

    public Event updateEvent(Event event) {
        return entityManager.merge(event);
    }

    public void deleteEvent(Long event) {
        entityManager.remove(event);
    }

    public List<Event> getEventsByDateRange(LocalDateTime start, LocalDateTime end) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT e FROM Event e WHERE e.startTime BETWEEN :startTime AND :endTime",
                Event.class
        );
        query.setParameter("startTime", start);
        query.setParameter("endTime", end);
        return query.getResultList();
    }

    public List<Event> getEventsByScheduleId(Long scheduleId) {
        TypedQuery<Event> query = entityManager.createQuery(
                "SELECT e FROM Event e WHERE e.scheduleId = :scheduleId",
                Event.class
        );
        query.setParameter("scheduleId", scheduleId);
        return query.getResultList();
    }
}
