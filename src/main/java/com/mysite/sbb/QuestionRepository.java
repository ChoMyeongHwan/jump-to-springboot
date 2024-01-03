package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

// 레포지토리의 대상이 되는 엔티티의 타입(Question)과 해당 엔티티의 PK의 속성 타입(Integer)을 지정
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
}
