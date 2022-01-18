package se.bahram.security.mutualtls.httpsserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/https")
public class HelloHttpsRestController {

    @GetMapping("/hello/{name}")
    private ResponseEntity<String> hello(@PathVariable("name") String name) {
        return ResponseEntity.ok("Hello, " + name + "!");
    }
}
