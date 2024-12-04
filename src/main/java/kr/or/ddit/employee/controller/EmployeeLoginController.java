package kr.or.ddit.employee.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.commons.validate.LoginGroup;
import kr.or.ddit.employee.service.EmployeeLoginService;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.OAuthVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/a001/login")
public class EmployeeLoginController {
	@Inject
	private EmployeeLoginService employeeLoginService;
	
	
	@GetMapping
	public String getLoginForm() {
		return "/employee/employeeLoginForm";
	}

	@PostMapping
	public String loginResult(
			@Validated(LoginGroup.class) EmployeeVO employee,
			BindingResult errors,
			RedirectAttributes redirectAttributes,
			HttpSession session
	) {
		
		if (!errors.hasErrors()) {
			// errors가 없다면
			// service, dao를 통해 일치하는 데이터가 맞는지 확인
			// 맞다면 로그인 성공 redirect:/
			// 맞지 않다면 로그인 실패 redirect:/a001/login
			try {
				EmployeeVO myEmp = employeeLoginService.loginResult(employee);
				OAuthVO myOAuth = employeeLoginService.getOAuthInfo(myEmp.getEmpId());
				session.setAttribute("myEmp", myEmp);
				return "redirect:/";
			} catch(PKNotFoundException e) {
				redirectAttributes.addFlashAttribute("message", "일치하는 정보가 없습니다.");
				return "redirect:/a001/login";
			}
			
			/*
			서비스를 통해 회원 정보가 있는지 없는지 조회(return count)
			있으면 데이터를 가지고 와서 session에 저장하고 oauth 테이블에서 데이터 가지고 와서 session 저장
			없으면 그냥 메세지 가지고 redirect
			
			서비스를 통해 회원 정보가 있는지 없는지 조회(return vo)
			있으면 해당 회원의 정보를 가진 vo를 return 없으면.. 어떻게 해야해?...
			*/
			
			
		} else {
			redirectAttributes.addFlashAttribute("message","다시 시도해주세요.");
			return "redirect:/a001/login";
		}
		
		
//		boolean result = true;
		// body에 있는 id(사번)과 password를 꺼내서, service와 dao를 통해 로그인 정보를 확인
		// 로그인 정보가 있다면,
//		if (result) {
//			// oAuth 정보 조회
//			// login(employee)정보와 oAuth 정보를 session.setAttribute();
//			// employee 관련 정보 : myAccount
//			// oauth 관련 정보 : myOAuth
//			// 아래 message 에 employee 정보에 저장된 이름을 formatting 해야함
//			String message = String.format("%s님, 환영합니다!⌯･˕･⌯ಣ", "name");
//			redirectAttributes.addFlashAttribute("message", message);
//			return "";
//		} else {
//			redirectAttributes.addFlashAttribute("message", "로그인 정보가 일치하지 않습니다.");
//			return "redirect:";
//		}

	}
}
