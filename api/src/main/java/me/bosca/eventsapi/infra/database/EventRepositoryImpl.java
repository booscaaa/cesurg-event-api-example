package me.bosca.eventsapi.infra.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import me.bosca.eventsapi.core.domain.contract.EventRepository;
import me.bosca.eventsapi.core.domain.entity.Event;
import me.bosca.eventsapi.core.domain.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Event getByID(int id) {
        var query = "SELECT * FROM event WHERE id = :id;";
        return  (Event) entityManager.createNativeQuery(query, Event.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Event delete(int id) {
        var query = "DELETE FROM event WHERE id = :id RETURNING *;";
        return  (Event) entityManager.createNativeQuery(query, Event.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Event> fetch() {
        var query = "SELECT * FROM event;";
        return (List<Event>) entityManager.createNativeQuery(query, Event.class).getResultList();
    }

    @Override
    public Event create(Event event) {
        var query = "INSERT INTO event(name, description) VALUES(:name, :description) RETURNING *;";
        return  (Event) entityManager.createNativeQuery(query, Event.class)
                .setParameter("name", event.getName())
                .setParameter("description", event.getDescription())
                .getSingleResult();
    }

    @Override
    public Event update(int id, Event event) {
        var query = "UPDATE  event SET name = :name, description = :description WHERE id = :id RETURNING *;";
        return  (Event) entityManager.createNativeQuery(query, Event.class)
                .setParameter("name", event.getName())
                .setParameter("description", event.getDescription())
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void addPerson(int eventID, int personID) {
        var query = """
            INSERT INTO event_person (person_id, event_id) 
            VALUES (:personID, :eventID);
            """;

        entityManager.createNativeQuery(query, Event.class)
                .setParameter("personID", personID)
                .setParameter("eventID", eventID)
                .executeUpdate();
    }

    @Override
    public List<Person> fetchPeople(int eventID) {
        var query = """
           SELECT p.id, p.name FROM event_person ep
           INNER JOIN person p ON p.id = ep.person_id
           WHERE event_id = :eventID;
           """;

        return (List<Person>) entityManager.createNativeQuery(query, Person.class)
                .setParameter("eventID", eventID)
                .getResultList();
    }


}
