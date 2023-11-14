package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// ?과 !에 각각 뭐가 들어갈까요? -> Entity, Id의 data type
public interface MemberRepository extends JpaRepository<Member, Long> {
}
