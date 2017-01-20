package br.com.desafio.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ramir on 20/01/2017.
 */

@Entity
public class Membro implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nome;

    @ManyToOne
    private Time time;


    public Membro(String nome) {
        this.nome = nome;
    }

    protected Membro(){

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


    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
