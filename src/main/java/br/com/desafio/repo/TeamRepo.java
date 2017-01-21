package br.com.desafio.repo;

import br.com.desafio.domain.Member;
import br.com.desafio.domain.Team;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Ramir on 20/01/2017.
 */

public interface TeamRepo extends PagingAndSortingRepository<Team,Integer> {
    List<Team> findByName(@Param("name") String name, Pageable pageable);
    List<Member> findByTeamMembersName(@Param("name") String name, Pageable pageable);
}
