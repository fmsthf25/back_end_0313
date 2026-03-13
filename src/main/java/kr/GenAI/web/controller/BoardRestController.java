package kr.GenAI.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.GenAI.web.dto.BoardCreateRequest;
import kr.GenAI.web.entity.Board;
import kr.GenAI.web.service.BoardService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/board")
//@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders ="*")
@CrossOrigin(origins = "http://10.1.1.6", allowedHeaders ="*")
public class BoardRestController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String index() {
		return "Hello~Spring Boot!";
	}
	
	@GetMapping("/list")
	public List<Board> list() {
		
		return service.getList();
	}
	
	@PostMapping(value="/register", consumes="multipart/form-data")
	public String register(@ModelAttribute BoardCreateRequest req) throws Exception {
		System.out.println("제목>> "+req);
		
		try {
			service.register(req);
			return "success";
			
		}catch (Exception e) {
			return "fail";
		}
		
	}
	
	
	
}
