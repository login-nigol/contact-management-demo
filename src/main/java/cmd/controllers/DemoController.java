package cmd.controllers;

import cmd.model.RequestBodyClient;
import cmd.model.ResponseAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/postItem")
    public ResponseEntity<String> postItemWithValue(@RequestBody String data) {
        String response = String.format("postItemWithValue получил данные: %s", data);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> postItem(@RequestBody String data) {
        String response = String.format("postItem получил данные: %s", data);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/post/postResponseAPI")
    public ResponseEntity<ResponseAPI> postResponseAPI(@RequestBody RequestBodyClient requestBodyClient) {
        ResponseAPI responseAPI = new ResponseAPI();
        if (requestBodyClient == null || requestBodyClient.data == null || requestBodyClient.data.isEmpty()) {
            responseAPI.statusCode = 400;
            return ResponseEntity.badRequest().body(responseAPI);
        }
        responseAPI.statusCode = 200;
        responseAPI.statusMessage = requestBodyClient.data.toUpperCase();
        return ResponseEntity.ok(responseAPI);
    }
}
