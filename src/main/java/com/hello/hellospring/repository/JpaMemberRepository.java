package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    //JPA는 EntityManager로 동작함.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        //JPQL
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)  //parameter로 String name을 받아옴
                .getResultList();                   //반환결과 가져오기
        return result.stream().findAny();           //반환타입이 Optional
    }

    @Override
    public List<Member> findAll() {
        //JPQL
        //Member 객체 자체를 조회하는것임. 그러므로 *가 아닌 Member의 alias인 m이 들어감.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
