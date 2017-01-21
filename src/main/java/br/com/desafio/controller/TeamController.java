package br.com.desafio.controller;

import br.com.desafio.domain.Member;
import br.com.desafio.domain.Team;
import br.com.desafio.repo.MemberRepo;
import br.com.desafio.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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
        return team;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
