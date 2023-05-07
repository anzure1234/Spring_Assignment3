package com.example.spring_assignment3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Content extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,length = 1000)
    private String brief;

    @Column(nullable = false,length = 1000)
    private String content;

    @Column
    private String sort;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member member;

}
