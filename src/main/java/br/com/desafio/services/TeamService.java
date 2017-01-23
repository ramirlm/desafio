package br.com.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.repo.MemberRepo;
import br.com.desafio.repo.TeamRepo;

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
