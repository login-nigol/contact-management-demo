package cmd.controllers;

import cmd.model.RequestBodyClient;
import cmd.model.ResponseAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController  // используется для обозначения класса как контроллера, обрабатывает HTTP-запросы и возвращает
                    // данные в формате JSON или XML.
@RequestMapping("/demo") // используется для задания базового URL для всех методов в контроллере,
                            // будут доступны по URL, начинающемуся с /demo.
public class DemoController {

    @GetMapping("/{id}") // используется для обработки HTTP GET запросов, /{id} указывает, что метод будет
                            // принимать переменную часть URL, которая будет передана в метод в качестве параметра.
    public ResponseEntity<String> getItemById(@PathVariable("id") String value){ // @PathVariable связывает переменную
                    // из URL с параметром метода, значение из {id} в URL будет передано в метод как параметр value.
        String response = String.format("Передано значение: %s!", value); // Возвращает отформатированную строку,
                                                            // используя указанную локаль, строку формата и аргументы.
        return ResponseEntity.ok(response); // ResponseEntity.ok() создает объект ResponseEntity с HTTP статусом
        // 200 (OK), что указывает на успешное выполнение запроса, ResponseEntity позволяет более гибко управлять
        // HTTP-ответами, включая установку статуса, заголовков и тела ответа.
    }
    @PostMapping("/postItem")
    public ResponseEntity<String> postItemWithValue(@RequestBody String data){
        String response = String.format("postItem получил данные: %s!", data);
        return ResponseEntity.ok(response);
    }

    // @RestController
    //Эта аннотация используется для обозначения класса как контроллера, который обрабатывает HTTP-запросы и возвращает
    //данные в формате JSON или XML.
    //Она является сочетанием аннотаций @Controller и @ResponseBody, что означает, что все методы в этом классе будут
    //возвращать данные напрямую в HTTP-ответ, а не представление.
    // @RequestMapping(“/demo”)
    //Аннотация @RequestMapping используется для задания базового URL для всех методов в контроллере.
    //В данном случае, все методы в DemoController будут доступны по URL, начинающемуся с /demo.
    // @GetMapping(“/{id}”)
    //Аннотация @GetMapping используется для обработки HTTP GET запросов.
    //Путь /{id} указывает, что метод будет принимать переменную часть URL, которая будет передана в метод в качестве параметра.
    // @PathVariable(“id”)
    //Аннотация @PathVariable связывает переменную из URL с параметром метода.
    //В данном случае, значение из {id} в URL будет передано в метод как параметр value.
    // ResponseEntity.ok()
    //Метод ResponseEntity.ok() создает объект ResponseEntity с HTTP статусом 200 (OK), что указывает на успешное
    //выполнение запроса. ResponseEntity позволяет более гибко управлять HTTP-ответами, включая установку статуса,
    //заголовков и тела ответа.
    // Методы ResponseEntity
    //ResponseEntity.status(HttpStatus status): Позволяет задать конкретный HTTP статус для ответа.
    //ResponseEntity.badRequest(): Возвращает ответ с HTTP статусом 400 (Bad Request), указывающим на ошибку в запросе клиента.
    //ResponseEntity.notFound(): Возвращает ответ с HTTP статусом 404 (Not Found), указывающим, что запрашиваемый ресурс не найден.
    //ResponseEntity.noContent(): Возвращает ответ с HTTP статусом 204 (No Content), что указывает на успешное выполнение
    //запроса без возвращаемого содержимого.
    //ResponseEntity.created(URI location): Возвращает ответ с HTTP статусом 201 (Created) и заголовком Location,
    //указывающим на URL созданного ресурса.

//    @PostMapping("/postItem")
//    public ResponseEntity<String> postItemWithValue(@RequestBody String data) {
//        String response = String.format("postItemWithValue получил данные: %s", data);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<String> postItem(@RequestBody String data) {
//        String response = String.format("postItem получил данные: %s", data);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/post/postResponseAPI")
//    public ResponseEntity<ResponseAPI> postResponseAPI(@RequestBody RequestBodyClient requestBodyClient) {
//        ResponseAPI responseAPI = new ResponseAPI();
//        if (requestBodyClient == null || requestBodyClient.data == null || requestBodyClient.data.isEmpty()) {
//            responseAPI.statusCode = 400;
//            return ResponseEntity.badRequest().body(responseAPI);
//        }
//        responseAPI.statusCode = 200;
//        responseAPI.statusMessage = requestBodyClient.data.toUpperCase();
//        return ResponseEntity.ok(responseAPI);
//    }
}
