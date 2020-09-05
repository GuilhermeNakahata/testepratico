package com.testepratico.testepratico.services;


import com.testepratico.testepratico.entities.Pessoa;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class PessoaServiceTest {

    @InjectMocks
    private PessoaService mockPessoaService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findById() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCodigo((long) 1);
        pessoa.setNome("teste");
        pessoa.setCpf("123456");
        when(mockPessoaService.findById(Mockito.anyLong())).thenReturn(pessoa);
        Assert.assertEquals(mockPessoaService.findById((long) 1).getNome(), "teste");
    }

    @Test
    void findAll() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCodigo((long) 1);
        pessoa.setNome("teste");
        pessoa.setCpf("123456");
        List<Pessoa> list = new ArrayList<Pessoa>();
        list.add(pessoa);
        when(mockPessoaService.findAll()).thenReturn(list);
        Assert.assertEquals(mockPessoaService.findAll().get(0).getNome(), "teste");
    }
}