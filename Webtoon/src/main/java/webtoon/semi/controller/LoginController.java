package webtoon.semi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import webtoon.semi.dto.Member;
import webtoon.semi.service.LoginService;

@Controller
@Slf4j

public class LoginController {

	    @Autowired
	    private LoginService loginService;

	    @GetMapping("/")
	    public String showMain() {
	        return "index";
	    }

	    @GetMapping("/login")
	    public String showLoginForm(Model model) {
	        model.addAttribute("login", new Member());
	        return "login";
	    }

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";
	    }

	    @GetMapping("/findId")
	    public String showFindIdForm(Model model) {
	        model.addAttribute("login", new Member());
	        return "findId";
	    }

	    @GetMapping("/sfPass")
	    public String showSfPassForm(Model model) {
	        model.addAttribute("login", new Member());
	        return "sfPass"; 
	    }

	    @PostMapping("/login")
	    public String postLogin(Model model,
	                            @RequestParam("login_id") String login_id,
	                            @RequestParam("login_pw") String login_pw,
	                            HttpSession session) {

	        Member member = loginService.getLogin(login_id, login_pw, login_id, login_pw);

	        if (member != null) {
	            session.setAttribute("loginSession", member);
	            return "redirect:/";
	        } else {
	            model.addAttribute("error", "일치하는 아이디와 비밀번호가 없습니다.");
	            model.addAttribute("login", new Member());
	            return "login";
	        }
	    }

	    @PostMapping("/findId")
	    public String postFindId(Model model,
	                             @RequestParam("login_name") String login_name,
	                             @RequestParam("login_email") String login_email) {

	        Member member = loginService.getLogin(login_email, login_email, login_name, login_email);
	        		

	        if (member != null) {
	            model.addAttribute("foundId", member.getLogin_id());
	            return "findId_result"; // findId_result.html에 대한 뷰 페이지를 반환
	        } else {
	            model.addAttribute("error", "일치하는 정보가 없습니다.");
	            return "findId_form"; // 다시 입력 폼으로 되돌아감
	        }
	    }

	    @PostMapping("/sfPass")
	    public String postFindPassword(Model model,
	                                   @RequestParam("login_id") String login_id,
	                                   @RequestParam("login_email") String login_email) {

	        Member member = loginService.getLogin(login_id, login_email, login_id, login_email);

	        if (member != null) {
	            model.addAttribute("foundPassword", member.getLogin_pw());
	            return "sfPass_result"; // sfPass_result.html에 대한 뷰 페이지를 반환
	        } else {
	            model.addAttribute("error", "일치하는 정보가 없습니다.");
	            return "sfPass_form"; // 다시 입력 폼으로 되돌아감
	        }
	    }
	}
