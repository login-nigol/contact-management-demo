package cmd.controllers;

import cmd.model.Contacts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/contacts") // базовый URL для всех методов
public class ContactsController {

    @GetMapping(value = "/oleg") // будет обрабатывать GET-запросы по пути "/contacts/oleg".
    public ResponseEntity<Contacts> getRandomContacts() { // Метод возвращает объект ResponseEntity с типом тела Contacts.
        Contacts contacts = Contacts.builder() // Contacts.builder(), вы создаете объект билдера, который предоставляет
                // методы для установки значений полей объекта Contacts.
                .id(UUID.randomUUID()) // UUID: Используется для генерации уникального идентификатора.
                .name("Oleg")
                .email("oleg@example.ru")
                .build(); // Паттерн проектирования, используемый для создания объектов. Он помогает избежать
        // использования сложных конструкторов и обеспечивает более читаемый код.
        return ResponseEntity.ok(contacts); // ответ с кодом состояния 200 OK и телом, содержащим объект Contacts.
    }
}

// Паттерн Builder
//Паттерн "Builder" позволяет создавать объекты пошагово, обеспечивая более гибкий подход к их инициализации.
//В Java его можно реализовать вручную, но библиотека Lombok упрощает этот процесс с помощью аннотации @Builder.

// Конструкция Contacts.builder() используется для создания объекта Contacts с использованием паттерна "Builder".
//Паттерн "Builder" является одним из паттернов проектирования, который помогает создавать объекты сложных классов,
//делая код более читабельным и управляемым.

// Аннотация @Builder из библиотеки Lombok автоматически генерирует код для паттерна "Builder". Ваша сущность Contacts
//должна быть аннотирована этой аннотацией.