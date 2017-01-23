package br.com.desafio.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.Member;
import br.com.desafio.domain.Team;
import br.com.desafio.repo.MemberRepo;
import br.com.desafio.repo.TeamRepo;

/**
 * Created by Ramir on 20/01/2017.
 */
@RestController
@RequestMapping(path = "/teams")
public class TeamController {
    private TeamRepo teamRepo;
    private MemberRepo memberRepo;

    @Autowired
    public TeamController(TeamRepo teamRepo, MemberRepo memberRepo) {
        this.teamRepo = teamRepo;
        this.memberRepo = memberRepo;
    }

    protected TeamController(){

    }

    @RequestMapping(method = RequestMethod.POST, path = "/join/member/{memberId}/onteam/{teamId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Team insertMemberOnTeam(@PathVariable(value = "memberId")Integer memberId, @PathVariable(value = "teamId")Integer teamId) throws NoSuchElementException{
        Team team = teamRepo.findOne(teamId);


        Member member = memberRepo.findOne(memberId);
        if(team == null){
            throw new NoSuchElementException("Team id "+teamId+" does not exist!");
        }
        if(member == null){
            throw new NoSuchElementException("Member id "+memberId+" does not exist!");
        }
        if(team.getTeamMembers().contains(member)){
            throw new NoSuchElementException("Member "+memberId+" already belongs to team "+teamId);
        }
        team.getTeamMembers().add(member);
        member.setTeam(team);
        teamRepo.save(team);
        return team;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
