package br.com.desafio.repo;

import br.com.desafio.domain.Membro;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ramir on 20/01/2017.
 */
public interface MembroRepositorio extends CrudRepository<Membro,Integer>{
    TimeRepositorio findByNome(String nome);
}
