package com.example.Server.entity;

import javax.persistence.*;

@Entity
public class CountFilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer countPPTX;
    private Integer countDOCX;
    private Integer countPDF;
    // TODO
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public CountFilesEntity() {

    }

}
