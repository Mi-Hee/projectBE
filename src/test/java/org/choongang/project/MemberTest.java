package org.choongang.project;

import org.choongang.api.members.dto.RequestJoin;
import org.choongang.models.member.MemberJoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class MemberTest {

    @Autowired
    private MemberJoinService joinService;

    @Test
    public void insertData() {
        RequestJoin form =
                new RequestJoin(
                        "user01@test.org",
                        "12345678",
                        "12345678",
                        "사용자01",
                        "01010001000",
                        true);
        joinService.save(form);
    }
}
