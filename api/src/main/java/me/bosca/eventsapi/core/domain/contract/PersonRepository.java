package me.bosca.eventsapi.core.domain.contract;

import me.bosca.eventsapi.core.domain.entity.Person;

import java.util.List;

public interface PersonRepository {
    public Person getByID(int id);
    public Person delete(int id);
    public List<Person> fetch();
    public Person create(Person event);
    public Person update(int id, Person event);
}
