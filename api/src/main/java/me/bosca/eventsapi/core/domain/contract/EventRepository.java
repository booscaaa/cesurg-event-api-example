package me.bosca.eventsapi.core.domain.contract;

import me.bosca.eventsapi.core.domain.entity.Event;
import me.bosca.eventsapi.core.domain.entity.Person;

import java.util.List;

public interface EventRepository {
    public Event getByID(int id);
    public Event delete(int id);
    public List<Event> fetch();
    public Event create(Event event);
    public Event update(int id, Event event);
    public void addPerson(int eventID, int personID);
    public List<Person> fetchPeople(int eventID);
}
