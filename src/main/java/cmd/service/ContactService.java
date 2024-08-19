package cmd.service;

import java.util.UUID;
import cmd.model.Contacts;

public class ContactService {

    public Contacts getContacts() {
        return Contacts.builder()
                .id(UUID.randomUUID())
                .name("Вася Пупкин")
                .email("василий@пуп.ру")
                .build();
    }
}
