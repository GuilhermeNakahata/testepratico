package com.testepratico.testepratico.controller;

import com.testepratico.testepratico.entities.Pessoa;
import com.testepratico.testepratico.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testepratico")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping("/pessoas")
    public List<Pessoa> getUsers() {
        return service.findAll();
    }

    @GetMapping("/pessoas/{id}")
    public Pessoa getUser(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/pessoas/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PutMapping("/pessoas")
    public Pessoa updateUser(@RequestBody Pessoa user) {
        return service.update(user);
    }

    @PostMapping("/pessoas")
    public Pessoa createUser(@RequestBody Pessoa user) {
        return service.createUser(user);
    }
}
