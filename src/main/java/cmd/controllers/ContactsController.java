package cmd.controllers;

import cmd.model.Contacts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @GetMapping(value = "/oleg") // будет обрабатывать GET-запросы по пути "/contacts/oleg".
    public ResponseEntity<Contacts> getRandomContacts() { // Метод возвращает объект ResponseEntity с типом тела Contacts.
        Contacts contacts = Contacts.builder()
                .id(UUID.randomUUID()) // UUID: Используется для генерации уникального идентификатора.
                .name("Oleg")
                .email("oleg@example.ru")
                .build(); // Паттерн проектирования, используемый для создания объектов. Он помогает избежать
                            // использования сложных конструкторов и обеспечивает более читаемый код.
        return ResponseEntity.ok(contacts); // ответ с кодом состояния 200 OK и телом, содержащим объект Contacts.
    }
}
