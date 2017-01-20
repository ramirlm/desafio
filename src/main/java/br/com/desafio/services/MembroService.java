package br.com.desafio.services;

import br.com.desafio.domain.Membro;
import br.com.desafio.repo.MembroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ramir on 20/01/2017.
 */
@Service
public class MembroService {
    private MembroRepositorio membroRepositorio;

    @Autowired
    public MembroService(MembroRepositorio membroRepositorio) {
        this.membroRepositorio = membroRepositorio;
    }

    public Membro criaMembro(String nome){
        Membro novoMembro = new Membro(nome);
        return membroRepositorio.save(novoMembro);
    }
}
