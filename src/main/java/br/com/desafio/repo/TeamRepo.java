package br.com.desafio.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.desafio.domain.Member;
import br.com.desafio.domain.Team;

/**
 * Created by Ramir on 20/01/2017.
 */

public interface TeamRepo extends PagingAndSortingRepository<Team,Integer> {
    List<Team> findByName(@Param("name") String name, Pageable pageable);
    List<Member> findByTeamMembersName(@Param("name") String name, Pageable pageable);
}
