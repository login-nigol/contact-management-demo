package cmd.service;

import java.util.UUID;
import cmd.model.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public Contacts getContact() { // ручка
        return Contacts.builder()
                .id(UUID.randomUUID())
                .name("Вася Пупкин")
                .email("василий@пуп.ру")
                .build();
    }
}
