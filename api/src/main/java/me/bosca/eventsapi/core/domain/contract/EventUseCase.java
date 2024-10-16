package me.bosca.eventsapi.core.domain.contract;

import me.bosca.eventsapi.core.domain.entity.Event;
import me.bosca.eventsapi.core.domain.entity.Person;
import me.bosca.eventsapi.core.dto.EventInput;

import java.util.List;

public interface EventUseCase {
    public Event getByID(int id);
    public Event delete(int id);
    public List<Event> fetch();
    public Event create(EventInput event);
    public Event update(int id, EventInput event);
    public void addPerson(int eventID, int personID);
    public List<Person> fetchPeople(int eventID);
}
