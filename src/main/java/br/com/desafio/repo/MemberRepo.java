package br.com.desafio.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.desafio.domain.Member;

/**
 * Created by Ramir on 20/01/2017.
 */
public interface MemberRepo extends PagingAndSortingRepository<Member,Integer> {
    List<Member> findByName(@Param("name") String name, Pageable pageable);
}
