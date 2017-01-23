package br.com.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.repo.MemberRepo;

/**
 * Created by Ramir on 20/01/2017.
 */
@Service
public class MemberService {
    private MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }


}
