package org.example.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // 2. static import 추가
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // 2. static import 추가
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // 2. static import 추가

@SpringBootTest
@AutoConfigureMockMvc // MockMvc를 자동으로 설정해주는 마법의 어노테이션
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;



    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers: 아티클 조회에 성공한다")
    @Test
    public void getAllMembers() throws Exception {
        // given
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when
        final ResultActions result = mockMvc.perform(get(url) // static import 덕분에 사용 가능
                .accept(MediaType.APPLICATION_JSON));

        // then
        result
                .andExpect(status().isOk()) // static import 덕분에 사용 가능
                // 응답이 배열([]) 형태이므로 $[0]으로 접근
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}