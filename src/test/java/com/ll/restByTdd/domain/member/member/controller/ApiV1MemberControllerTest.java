package com.ll.restByTdd.domain.member.member.controller;


import com.ll.restByTdd.domain.member.member.entity.Member;
import com.ll.restByTdd.domain.member.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ApiV1MemberControllerTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("회원가입")
    void t1() throws Exception {
      ResultActions resultActions  = mvc.perform(
                post("/api/v1/members/join")
                        .content("""
                               {
                                    "username": "usernew",
                                    "password": "1234",
                                    "nickname": "유저신규"          
                               } 
                                """.stripIndent())
                        .contentType("application/json")
        )
        .andDo(print());

      Member member = memberService.findByUsername("usernew").get();

      System.out.println(resultActions);

      System.out.println("!!!!" +  member.getUsername());
      assertEquals("usernew", member.getUsername());
    }
}