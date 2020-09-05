package com.testepratico.testepratico.services;

import com.testepratico.testepratico.entities.Pessoa;
import com.testepratico.testepratico.repositories.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa findById(Long codigo) {
        return repository.findById(codigo).orElse(null);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa update(Pessoa user) {
        Pessoa userFounded = findById(user.getCodigo());
        BeanUtils.copyProperties(user, userFounded, "id", "conta");
        return repository.save(userFounded);
    }

    public Pessoa createUser(Pessoa pessoa) {
        repository.save(new Pessoa(pessoa.getNome(), pessoa.getCpf()));
        return pessoa;
    }

    public boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
