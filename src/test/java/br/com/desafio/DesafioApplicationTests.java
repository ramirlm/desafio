package br.com.desafio;

import br.com.desafio.domain.Membro;
import br.com.desafio.domain.Time;
import br.com.desafio.services.MembroService;
import br.com.desafio.services.TimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesafioApplicationTests {

	@Autowired
	private MembroService membroService;
	@Autowired
	private TimeService timeService;

	@Test
	public void contextLoads() {
	}

	@Test(expected = Exception.class)
	public void testaErroAoInserirMembroDuplicado(){
		Membro membro = membroService.criaMembro("Ramir");
		Time time = timeService.criaTime("Time A");
		timeService.insereMembroNoTime(membro,time);
		timeService.insereMembroNoTime(membro,time);
	}

}
