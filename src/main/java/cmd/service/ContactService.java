package cmd.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cmd.model.Contacts;
//import cmd.repositories.ContactRepository;
import cmd.repositories.LocalContactsRepository;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ContactService {
    @Autowired
    private LocalContactsRepository localContactsRepository;

    public List<Contacts> getAllContacts() {
        return localContactsRepository.findAll();

    }

    public Optional<Contacts> getContactById(Long id) {
        return localContactsRepository.findById(id);
    }

    public Contacts saveContact(Contacts contact) {
        return localContactsRepository.save(contact);
    }

    public Contacts updateContact(Long id, Contacts contact) {
        if (localContactsRepository.existsById(id)) {
            contact.setId(Long id);
            return localContactsRepository.save(contact);
        } else {
            throw new RuntimeException("Contact not found");
        }
    }

    public void deleteContact(Long id) {
        if (localContactsRepository.existsById(id)) {
            localContactsRepository.deleteById(id);
        } else {
            throw new RuntimeException("Contact not found");
        }
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
