package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.MemberUpdateRequest;
import com.example.demo.dto.MemberUpdateResponse;
import com.example.demo.dto.SignUpRequest;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Transactional
	public Long signUp(SignUpRequest request) {
		Member member = new Member(request.getName(), request.getGender());
		Member savedMember = memberRepository.save(member);
		return savedMember.getId();
	}

	@Transactional
	public MemberDto getMember(Long memberId) {
		Optional<Member> optionalMember = memberRepository.findById(memberId);
		Member member = optionalMember.get();
		MemberDto dto = new MemberDto(member.getId(), member.getName(), member.getGender());
		return dto;
	}

	@Transactional
	public MemberUpdateResponse updateMember(MemberUpdateRequest request){
		Optional<Member> optionalMember= memberRepository.findById(request.getId());
		Member member = optionalMember.get();

		member.setName(request.getName());
		member.setGender(request.getGender());

		return new MemberUpdateResponse(member.getName(), member.getGender());
	}


// 	1. 엔티티 저장하는 방법 -> repository.save() 호출
// 	2. 엔티티를 ID로 조회하는 방법 -> repository.findById() 호출
// 	3. 엔티티를 업데이트하는 방법 -> repository.findById()를 호출한 뒤 setter로 필드값들을 변경해준다.
}
