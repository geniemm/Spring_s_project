package com.care.root.member.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired MemberMapper mm;
	ArrayList<MemberDTO> dto = new ArrayList<MemberDTO>();
	
	@Override
	public int loginChk(MemberDTO dto) {
		int result =0;
		
		System.out.println("id:"+dto.getId());
		String id = dto.getId();
		MemberDTO dd = mm.loginChk(id);
		
		if(dto.getId().equals(dd.getId()) && dto.getPw().equals(dd.getPw())){
			result =1;
		}
		return result;
		
	}
	
	public ArrayList<MemberDTO> getList(){
		ArrayList<MemberDTO> list = mm.getList();
		return list;
	}
	
	public MemberDTO info(String id) {
		MemberDTO dto = mm.loginChk(id);
		return dto;
	}
	public int register(MemberDTO dto) {
		int result = mm.register(dto);
		return result;
	}
	
}
