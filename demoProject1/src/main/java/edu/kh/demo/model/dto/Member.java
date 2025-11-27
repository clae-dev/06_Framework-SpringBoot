package edu.kh.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter+setter+toString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 초기화용 매개 변수
public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
}
