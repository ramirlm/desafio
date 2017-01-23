package br.com.desafio.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Ramir on 20/01/2017.
 */
@Entity
public class Team implements Serializable{


    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Member> teamMembers;

    public Team(String name) {
        this.name = name;
    }

    public Team(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public List<Member> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Member> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
