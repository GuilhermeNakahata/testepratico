package com.testepratico.testepratico.repositories;

import com.testepratico.testepratico.entities.Pessoa;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
