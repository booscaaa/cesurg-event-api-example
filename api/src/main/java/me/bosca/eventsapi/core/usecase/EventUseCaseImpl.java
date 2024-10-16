package me.bosca.eventsapi.core.usecase;

import me.bosca.eventsapi.core.domain.contract.EventRepository;
import me.bosca.eventsapi.core.domain.contract.EventUseCase;
import me.bosca.eventsapi.core.domain.entity.Event;
import me.bosca.eventsapi.core.domain.entity.Person;
import me.bosca.eventsapi.core.dto.EventInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventUseCaseImpl implements EventUseCase {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event getByID(int id) {
        return eventRepository.getByID(id);
    }

    @Override
    public Event delete(int id) {
        return eventRepository.delete(id);
    }

    @Override
    public List<Event> fetch() {
        return eventRepository.fetch();
    }

    @Override
    public Event create(EventInput event) {
        return eventRepository.create(event.toEntity());
    }

    @Override
    public Event update(int id, EventInput event) {
        return eventRepository.update(id, event.toEntity());
    }

    @Override
    public void addPerson(int eventID, int personID) {
        eventRepository.addPerson(eventID, personID);
    }

    @Override
    public List<Person> fetchPeople(int eventID) {
        return eventRepository.fetchPeople(eventID);
    }
}
