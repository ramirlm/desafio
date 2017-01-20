package br.com.desafio.services;

import br.com.desafio.domain.Membro;
import br.com.desafio.domain.Time;
import br.com.desafio.repo.TimeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ramir on 20/01/2017.
 */
@Service
public class TimeService  {
    private TimeRepositorio timeRepositorio;

    @Autowired
    public TimeService(TimeRepositorio timeRepositorio) {
        this.timeRepositorio = timeRepositorio;
    }

    public Time criaTime(String nome){
        return timeRepositorio.save(new Time(nome));
    }

    public Time insereMembroNoTime(Membro membro, Time time){
        timeRepositorio.findOne(time.getId());
        time.getMembrosTime().add(membro);
        return timeRepositorio.save(time);
    }


}
