package cmd.service;

import org.springframework.stereotype.Service;
@Service
public class StringService {

    public String process (String value){
        return value.toUpperCase() + "!!!";
    }
    public String process1 (String value){
        return value.toUpperCase() + "???";
    }
}
