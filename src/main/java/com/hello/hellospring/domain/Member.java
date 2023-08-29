package com.hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    //아래와 같이 설정하면 id컬럼이 primary key로 잡히는것과 같음.
    //@GeneratedValue(strategy = GenerationType.INDENTITY)는 순번이 자동으로 올라감(오라클의 시퀀스나 MySQL의 auto_increment와 같은 개념)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "username") < 실제 DB의 컬럼명을 username으로 맵핑해서 생성함.
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
