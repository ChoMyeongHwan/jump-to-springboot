package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter // 교재대로 원활한 진행을 위해 임시로 Setter 사용(엔티티는 Setter 사용을 지양, 추후 변경)
@Entity
public class Question {

    @Id
    // GenerationType.IDENTITY : 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT") // "내용"처럼 글자 수를 제한할 수 없는 경우에 사용
    private String content;

    private LocalDateTime createDate;

    // CascadeType.REMOVE: 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 위해서 사용함
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}
