package br.com.desafio.services;

import br.com.desafio.domain.Member;
import br.com.desafio.domain.Team;
import br.com.desafio.repo.MemberRepo;
import br.com.desafio.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ramir on 20/01/2017.
 */
@Service
public class TeamService {
    private TeamRepo teamRepo;
    private MemberRepo memberRepo;

    @Autowired
    public TeamService(TeamRepo teamRepo, MemberRepo memberRepo) {
        this.teamRepo = teamRepo;
        this.memberRepo = memberRepo;
    }







}
