package com.magdy.calendar.controller;

import com.magdy.calendar.entity.Event;
import com.magdy.calendar.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.equals(id);
        Event updatedEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> getEventsByDateRange(
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end
    ) {
        List<Event> events = eventService.getEventsByDateRange(start, end);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<Event>> getEventsByScheduleId(@PathVariable Long scheduleId) {
        List<Event> events = eventService.getEventsByScheduleId(scheduleId);
        return ResponseEntity.ok(events);
    }
}
