package com.ll.restByTdd.domain.member.member.controller;


import com.ll.restByTdd.domain.member.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ApiV1MemberControllerTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("테스트")
    void t1() {
        Long count = memberService.count();
        System.out.println("안녕");
        System.out.println(count == 7);
    }

    @Test
    @DisplayName("테스트2")
    void t2() {
        System.out.println("실행2");
    }
}