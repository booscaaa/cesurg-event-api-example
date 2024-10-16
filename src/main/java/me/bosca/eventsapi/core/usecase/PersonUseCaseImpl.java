package me.bosca.eventsapi.core.usecase;

import me.bosca.eventsapi.core.domain.contract.PersonRepository;
import me.bosca.eventsapi.core.domain.contract.PersonUseCase;
import me.bosca.eventsapi.core.domain.entity.Person;
import me.bosca.eventsapi.core.dto.PersonInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonUseCaseImpl implements PersonUseCase {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getByID(int id) {
        return personRepository.getByID(id);
    }

    @Override
    public Person delete(int id) {
        return personRepository.delete(id);
    }

    @Override
    public List<Person> fetch() {
        return personRepository.fetch();
    }

    @Override
    public Person create(PersonInput person) {
        return personRepository.create(person.toEntity());
    }

    @Override
    public Person update(int id, PersonInput person) {
        return personRepository.update(id, person.toEntity());
    }
}
