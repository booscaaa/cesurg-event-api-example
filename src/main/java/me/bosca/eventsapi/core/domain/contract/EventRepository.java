package me.bosca.eventsapi.core.domain.contract;

import me.bosca.eventsapi.core.domain.entity.Event;

import java.util.List;

public interface EventRepository {
    public Event getByID(int id);
    public Event delete(int id);
    public List<Event> fetch();
    public Event create(Event event);
    public Event update(int id, Event event);
}
