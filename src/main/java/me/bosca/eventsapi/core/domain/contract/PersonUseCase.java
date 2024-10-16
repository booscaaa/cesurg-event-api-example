package me.bosca.eventsapi.core.domain.contract;

import me.bosca.eventsapi.core.domain.entity.Person;
import me.bosca.eventsapi.core.dto.PersonInput;

import java.util.List;

public interface PersonUseCase {
    public Person getByID(int id);
    public Person delete(int id);
    public List<Person> fetch();
    public Person create(PersonInput event);
    public Person update(int id, PersonInput event);
}
