package cmd.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.processing.Generated;
import java.util.UUID;

//@EntityScan(basePackages = "src/main/java/cmd/model/Contacts.java") // данный класс является сущностью JPA.
//@Table(name = "contacts") // имя таблицы, с которой будет сопоставлена сущность.
public class Contacts {

//    @JsonTypeId // Указывает, что поле id является первичным ключом.
//    @Generated(strategy = GeneratedType.AUTO) // значение для поля id будет генерироваться автоматически.

    private UUID id;
    private String name;
    private String email;
}
