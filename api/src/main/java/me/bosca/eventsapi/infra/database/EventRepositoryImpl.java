package me.bosca.eventsapi.infra.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.bosca.eventsapi.core.domain.contract.EventRepository;
import me.bosca.eventsapi.core.domain.entity.Event;
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
}
