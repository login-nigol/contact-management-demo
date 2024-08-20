package cmd.repositories;

import cmd.model.Contacts;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static io.swagger.v3.oas.annotations.info.Contact.*;

@Repository
public class LocalContactsRepository {

    private final List<Contacts> contact = init();

    public List<Contacts> init() {
        List<Contacts> contact = new ArrayList<>();

        contact.add(Contacts.builder().id(UUID.randomUUID()).email("test@1.ru").name("user1").build());
        contact.add(Contacts.builder().id(UUID.randomUUID()).email("test@2.ru").name("user2").build());
        contact.add(Contacts.builder().id(UUID.randomUUID()).email("test@3.ru").name("user3").build());
        contact.add(Contacts.builder().id(UUID.randomUUID()).email("test@4.ru").name("user4").build());
        contact.add(Contacts.builder().id(UUID.randomUUID()).email("test@5.ru").name("user5").build());
        return contact;
    }
}
