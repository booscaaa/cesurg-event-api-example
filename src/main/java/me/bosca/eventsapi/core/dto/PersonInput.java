package me.bosca.eventsapi.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.bosca.eventsapi.core.domain.entity.Person;

public record PersonInput(
        @NotNull(message= "Preencha o nome, não pode ser nulo!")
        @NotBlank(message= "Preencha o nome, não pode ser vazio!")
        String name
) {
    public Person toEntity() {
        Person person = new Person();
        person.setName(name);
        return person;
    }
}
