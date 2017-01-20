package br.com.desafio.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ramir on 20/01/2017.
 */
@Entity
public class Time implements Serializable{



    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nome;

    @OneToMany
    private List<Membro> membrosTime;

    public Time(String nome) {
        this.nome = nome;
    }

    protected Time(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Membro> getMembrosTime() {
        return membrosTime;
    }

    public void setMembrosTime(List<Membro> membrosTime) {
        this.membrosTime = membrosTime;
    }
}
