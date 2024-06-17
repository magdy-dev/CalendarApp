package com.magdy.calendar.service;


import com.magdy.calendar.dao.EventDAO;
import com.magdy.calendar.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private final EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    public Event getEventById(Long id) {
        return eventDAO.getEventById(id);
    }

    public Event createEvent(Event event) {
        return eventDAO.createEvent(event);
    }

    public Event updateEvent(Event event) {
        return eventDAO.updateEvent(event);
    }

    public void deleteEvent(Long event) {
        eventDAO.deleteEvent(event);
    }

    public List<Event> getEventsByDateRange(LocalDateTime start, LocalDateTime end) {
        return eventDAO.getEventsByDateRange(start, end);
    }

    public List<Event> getEventsByScheduleId(Long scheduleId) {
        return eventDAO.getEventsByScheduleId(scheduleId);
    }
}
