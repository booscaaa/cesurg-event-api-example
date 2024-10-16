package me.bosca.eventsapi.infra.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.bosca.eventsapi.core.domain.contract.PersonRepository;
import me.bosca.eventsapi.core.domain.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person getByID(int id) {
        var query = "SELECT * FROM person WHERE id = :id;";
        return  (Person) entityManager.createNativeQuery(query, Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Person delete(int id) {
        var query = "DELETE FROM person WHERE id = :id RETURNING *;";
        return  (Person) entityManager.createNativeQuery(query, Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Person> fetch() {
        var query = "SELECT * FROM person;";
        return (List<Person>) entityManager.createNativeQuery(query, Person.class).getResultList();
    }

    @Override
    public Person create(Person person) {
        var query = "INSERT INTO person(name) VALUES(:name) RETURNING *;";
        return  (Person) entityManager.createNativeQuery(query, Person.class)
                .setParameter("name", person.getName())
                .getSingleResult();
    }

    @Override
    public Person update(int id, Person person) {
        var query = "UPDATE  person SET name = :name WHERE id = :id RETURNING *;";
        return  (Person) entityManager.createNativeQuery(query, Person.class)
                .setParameter("name", person.getName())
                .setParameter("id", id)
                .getSingleResult();
    }
}
