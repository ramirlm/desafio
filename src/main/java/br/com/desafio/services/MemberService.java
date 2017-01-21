package br.com.desafio.services;

import br.com.desafio.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Service;

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
