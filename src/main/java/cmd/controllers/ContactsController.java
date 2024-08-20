package cmd.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cmd.model.Contacts;
import cmd.service.ContactService;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contacts> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Long id) {
        Optional<Contacts> contact = contactService.getContactById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contacts> createContact(@RequestBody Contacts contact) {
        Contacts savedContact = contactService.saveContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contacts> updateContact(@PathVariable Long id, @RequestBody Contacts contact) {
        try {
            Contacts updatedContact = contactService.updateContact(id, contact);
            return ResponseEntity.ok(updatedContact);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        try {
            contactService.deleteContact(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

//@RestController // указывает что это контроллер
//@RequestMapping("/contacts") // базовый URL для всех методов
//public class ContactsController {
//
//    @Autowired // внедрения зависимостей в поля, методы или конструкторы.
//    private ContactService contactService; // определяем как приватное
//
//    @GetMapping(value = "/")
//    public List<Contacts> getAllContacts() {
//        return contactService.getAllContact();
//    }
//
//}


//@RestController // указывает что это контроллер
//@RequestMapping("/contacts") // базовый URL для всех методов
//
//public class ContactsController {
//
//    @Autowired // Используется для автоматического внедрения зависимостей в поля, методы или конструкторы.
//                    // Spring Framework автоматически находит и внедряет подходящий бин в отмеченное место.
//    private ContactService contactService; // определяем как приватное
//
//    @Autowired
//    public void setContactService(ContactService contactService) {
//        this.contactService = contactService;
//    }
//
//    @GetMapping(value = "/")
//    public ResponseEntity<Contacts> getRandomContact() {
//        Contacts contact = contactService.getContact();
//        return ResponseEntity.ok(contact);
//    }
//}

//Конструкторное внедрение: Рекомендуемый способ, так как он позволяет создавать неизменяемые объекты и
// делает зависимости явными.
//Внедрение через поле: Удобный способ, но не рекомендуется, так как делает тестирование сложнее и зависимости
// менее явными.
//Внедрение через метод: Позволяет выполнять дополнительную логику при установке зависимости, но также делает
// зависимости менее явными.

//    private final ContactService contactService;
//
//    public ContactsController(ContactService contactService) { // Это пример конструкторного внедрения зависимостей.
//    Spring автоматически передает экземпляр ContactService в этот конструктор, когда создает бин ContactController.
//    Это возможно благодаря тому, что ContactService был зарегистрирован как бин через аннотацию @Service.
//        this.contactService = contactService;
//    }
//
//    @GetMapping(value = "/")
//    public ResponseEntity<Contacts> getRandomContact(){
//        Contacts contact = contactService.getContact();
//        return ResponseEntity.ok(contact);
//    }
//}

//    @GetMapping(value = "/oleg") // будет обрабатывать GET-запросы по пути "/contacts/oleg".
//
//    public ResponseEntity<Contacts> getRandomContacts() { // Метод возвращает объект ResponseEntity с типом тела Contacts.
//        Contacts contacts = Contacts.builder() // Contacts.builder(), вы создаете объект билдера, который предоставляет
//                // методы для установки значений полей объекта Contacts.
//                .id(UUID.randomUUID()) // UUID: Используется для генерации уникального идентификатора.
//                .name("Oleg")
//                .email("oleg@example.ru")
//                .build(); // Паттерн проектирования, используемый для создания объектов. Он помогает избежать
//        // использования сложных конструкторов и обеспечивает более читаемый код.
//        return ResponseEntity.ok(contacts); // ответ с кодом состояния 200 OK и телом, содержащим объект Contacts.
//    }
//}

// Паттерн Builder
//Паттерн "Builder" позволяет создавать объекты пошагово, обеспечивая более гибкий подход к их инициализации.
//В Java его можно реализовать вручную, но библиотека Lombok упрощает этот процесс с помощью аннотации @Builder.

// Конструкция Contacts.builder() используется для создания объекта Contacts с использованием паттерна "Builder".
//Паттерн "Builder" является одним из паттернов проектирования, который помогает создавать объекты сложных классов,
//делая код более читабельным и управляемым.

// Аннотация @Builder из библиотеки Lombok автоматически генерирует код для паттерна "Builder". Ваша сущность Contacts
//должна быть аннотирована этой аннотацией.