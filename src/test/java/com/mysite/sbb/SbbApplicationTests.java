package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 스프링부트 테스트 클래스임을 의미
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent()); // assertTrue(값)은 값이 true인지를 테스트
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }
}
