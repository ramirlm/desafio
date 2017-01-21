package br.com.desafio;

import br.com.desafio.controller.TeamController;
import br.com.desafio.domain.Member;
import br.com.desafio.domain.Team;
import br.com.desafio.repo.MemberRepo;
import br.com.desafio.repo.TeamRepo;
import br.com.desafio.services.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesafioApplicationTests {

	@Autowired
	private MemberRepo memberRepo;

	@Autowired
    private TeamRepo teamRepo;

    @Autowired
    private TeamController teamController;

	@Test
	public void contextLoads() {
	}

	@Test(expected = NoSuchElementException.class)
	public void errorOnDuplicateMemberOnTeam(){
	    String membersName = "Ramir";
	    String teamsName = "Team A";

		Member member = memberRepo.save(new Member(membersName));
		Team team = teamRepo.save(new Team(teamsName));

        teamController.insertMemberOnTeam(member.getId(),team.getId());
		teamController.insertMemberOnTeam(member.getId(),team.getId());
	}

    @Test(expected = NoSuchElementException.class)
	public void errorOnAssociatingUnexistentMemberOnTeam(){
		String teamsName = "Team A";
		Team team = teamRepo.save(new Team(teamsName));
		teamController.insertMemberOnTeam(0,team.getId());
    }


}
