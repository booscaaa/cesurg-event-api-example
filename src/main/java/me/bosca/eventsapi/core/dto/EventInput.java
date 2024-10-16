package me.bosca.eventsapi.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.bosca.eventsapi.core.domain.entity.Event;

public record EventInput(
        @NotNull(message= "Preencha o nome, não pode ser nulo!")
        @NotBlank(message= "Preencha o nome, não pode ser vazio!")
        String name,
        String description
) {
    public Event toEntity() {
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);
        return event;
    }
}
