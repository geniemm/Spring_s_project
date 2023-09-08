package com.care.root.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService ms;

	@GetMapping("/index")
	public String index() {
		System.out.println("index 페이지 연결");
		return "member/index";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("login 페이지 연결");
		return "member/login";
	}

	@GetMapping("/list")
	public String list(Model model) {
		ArrayList<MemberDTO> list = ms.getList();
		model.addAttribute("list", list);
		return "member/list";
	}

	@PostMapping("login_chk")
	public String loginChk(MemberDTO dto,HttpSession session) {
		int result = ms.loginChk(dto);
		if (result == 1) {
			System.out.println(dto.getId());
			session.setAttribute("id",dto.getId());	
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	
	@GetMapping("successLogin")
	public String success() {
		return "member/successLogin";
	}
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ArrayList<MemberDTO> list = ms.getList();
		model.addAttribute("list",list);
		return "member/memberInfo";
	}
	@GetMapping("info")
	public String info(@RequestParam String id, Model model) {
		MemberDTO dto = ms.info(id);
		model.addAttribute("dto", dto);
		return "member/info";
	}
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	@PostMapping("register")
	public String register(MemberDTO dto) {
		int result = ms.register(dto);
		if(result == 1) {
			return "redirect:/member/login";
		}
		
		return "redirect:/member/register";
	}

}
