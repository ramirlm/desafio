package br.com.desafio.repo;

import br.com.desafio.domain.Time;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ramir on 20/01/2017.
 */
public interface TimeRepositorio extends CrudRepository<Time,Integer>{
    TimeRepositorio findByNome(String nome);
}
