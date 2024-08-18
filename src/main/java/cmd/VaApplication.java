package cmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "src/main/java/cmd/model/Contacts.java")
public class VaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaApplication.class, args);
	}

}
