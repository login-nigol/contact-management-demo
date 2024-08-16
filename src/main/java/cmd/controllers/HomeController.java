package cmd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "start.html";
    }
}

// @Controller
//Эта аннотация сообщает Spring, что этот класс будет контроллером. Spring автоматически обнаруживает классы,
// аннотированные @Controller, и регистрирует их в контексте приложения как компоненты, которые могут
// обрабатывать HTTP-запросы.
// public class HomeController {
//Объявление класса HomeController. В этом классе содержится логика обработки запросов, поступающих на сервер.
// Имя класса может быть любым, но в данном случае оно логически связано с тем, что класс выполняет функции контроллера
// для главной страницы (home page) приложения.
// @GetMapping("/")
//Эта аннотация указывает, что метод home будет обрабатывать HTTP GET-запросы, отправленные на корневой путь ("/"),
// то есть на адрес, соответствующий главной странице приложения (например, http://localhost:8080/).
//
//@GetMapping: указывает тип HTTP-запроса, который будет обрабатываться (в данном случае GET).
// "/": указывает URL-адрес, по которому метод должен отвечать. В данном случае это корневой путь, что означает,
// что метод будет вызываться при переходе на главную страницу сайта.
//
// public String home(){
//Объявление метода home, который возвращает строку. Этот метод будет вызываться, когда сервер получит GET-запрос
// на указанный URL (корневой путь /).
//
//public String: указывает, что метод возвращает строку (String).
//home(): имя метода. Это может быть любое имя, но обычно выбирают описательное название, которое отражает его назначение.

// return "start.html";
//Эта строка возвращает имя HTML-файла, который будет использоваться для отображения. В данном случае, метод возвращает
// строку "start.html", что означает, что при обращении к корневому URL приложение должно отобразить HTML-страницу с
// именем start.html.
//
//return "start.html";: говорит Spring MVC, что нужно вернуть страницу start.html как ответ на HTTP-запрос. Spring ищет
// этот файл в конфигурации и находит его в одном из зарегистрированных каталогов представлений (например, в папке
// src/main/resources/templates).
//Итог
//В общем, этот код определяет контроллер, который отвечает за обработку GET-запросов на главную страницу вашего
// веб-приложения и отображает HTML-страницу start.html.