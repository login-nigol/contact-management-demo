package cmd.service;

import java.util.UUID;
import cmd.model.Contacts;
import cmd.repositories.LocalContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service // обозначения класса как сервисного
public class ContactService {
    @Autowired
    private LocalContactsRepository localContactsRepository;

    public ContactService(LocalContactsRepository localContactsRepository) {
        this.localContactsRepository = localContactsRepository;
    }
    public Contacts getAllContact() { // ручка
        return localContactsRepository.findAll();
    }

}


//@Service // обозначения класса как сервисного
//public class ContactService {
//
//    public Contacts getContact() { // ручка
//        return Contacts.builder()
//                .id(UUID.randomUUID())
//                .name("Вася Пупкин")
//                .email("василий@пуп.ру")
//                .build();
//    }
//}
