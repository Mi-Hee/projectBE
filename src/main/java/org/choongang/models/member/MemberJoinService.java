package org.choongang.models.member;

import lombok.RequiredArgsConstructor;
import org.choongang.api.members.dto.RequestJoin;
import org.choongang.commons.constants.MemberType;
import org.choongang.entities.Member;
import org.choongang.repositories.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(RequestJoin join) {
        String password = passwordEncoder.encode(join.password());
        Member member = Member.builder()
                .email(join.email())
                .password(password)
                .name(join.name())
                .mobile(join.mobile())
                .type(MemberType.USER)
                .build();

        save(member);
    }

    public void save(Member member) {

        memberRepository.saveAndFlush(member);
    }
}