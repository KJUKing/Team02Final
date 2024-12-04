package kr.or.ddit.error;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ErrorSettingController {

	private static Logger LOGGER = LoggerFactory.getLogger(ErrorSettingController.class);
	
	
	@GetMapping("/error404")
	public String error404(Model model) {
		model.addAttribute("code","ERROR_404");
		return "/error/404page";
	}
	
	@GetMapping("/error500")
	public String error500(Model model) {
		model.addAttribute("code","ERROR_500");
		return "/error/500page";
	}
	
}
