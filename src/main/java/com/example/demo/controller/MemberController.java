 package com.example.demo.controller;

 import com.example.demo.dto.MemberDto;
 import com.example.demo.dto.MemberUpdateRequest;
 import com.example.demo.dto.MemberUpdateResponse;
 import com.example.demo.dto.SignUpRequest;
 import org.springframework.web.bind.annotation.*;

 import com.example.demo.service.MemberService;

 // 여기 무슨 어노테이션이 들어갈까요?
 @RestController
 public class MemberController {
 	private final MemberService memberService;
 	public MemberController(MemberService memberService) {
 		this.memberService = memberService;
 	}

 	// API 3가지를 설계해주세요
 // 	1. Member 회원가입
 // 	SignUpRequest 클래스를 하나 만들어서 그것으로 외부로부터 회원기입 정보(Member의 필드들)을 받아와 주세요
 // 	그리고 MemberService 메서드로 DTO를 전달해서 Member의 생성자로 생성합니다.
 	// 리턴타입은 String 그대로 두셔도 됩니다.
 	@PostMapping("/members")
	// 회원가입시 필요한 정보를 담은 Dto를 넣어주세요
 	public Long signup(@RequestBody SignUpRequest request) {
		 return memberService.signUp(request);
 	}


 // 	2. Member 조회
 //  넘겨받은 memberId로 DB에서 조회를 해서 패스워드를 제외한 Member의 모든 정보를 담은 Dto 클래스를 반환하도록 해주세요
 // 	우선 MemberDto 클래스를 dto 패키지에 직접 만들어주세요
 // 	그리고 MemberService 에서 MemberRepository로 부터 받은 Member의 정보를 MemberDto로 옮기면 됩니다.

 	@GetMapping("/members")
 	public MemberDto getMemberDto(@RequestParam("id") Long memberId) {
 		return memberService.getMember(memberId);
 	}


 // 	3. Member 정보 업데이트
 //  변경된 정보와 변경할 정보를 Dto로 각각 요청/응답하면됩니다.
 // 	MemberService 에서 Member 정보를 변경하면 됩니다.

 	@PatchMapping("/members")
 	public MemberUpdateResponse update(@RequestBody MemberUpdateRequest request) {
 		return memberService.updateMember(request);
 	}

 }
