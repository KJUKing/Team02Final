package kr.or.ddit.notice.controller;

import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/work2gether/{companyId}/notice")
//이미 여기서 a001이라는 회사코드가 담겨있음 이걸 PathVariable에 담는거임
public class NoticeController {

    @Autowired
    private NoticeService service;

    // 공지사항 리스트갖고오기
    // 이제 근데 경로변수를 갖고와서 경로변수에 지정을해야함
    // 하지만 무턱대고가져와서 쓰기전에 세션에 갖고있는 내 회사명코드와 일치하는지 검증을해야함
    @GetMapping
    public String NoticeList(
            @PathVariable("companyId") String companyId,
            HttpSession session,
            Model model) {

        //나의 세션에서 companyId 꺼내오기
        //중요함!! 세션을 전역변수로꺼내오면안됨 싱글톤이고 다른사람들도 동시에 쓰기때문에 동시성문제 반드시 발생함.
        String sessionCompanyId = (String) session.getAttribute("companyId");

        //회사 ID 검증
        if(!companyId.equals(sessionCompanyId)) {
            return "redirect:/login";
        }

        List<NoticeVO> noticeList = service.readNoticeList();
        model.addAttribute("noticeList", noticeList);
        return "notice/noticeList";
    }

    @GetMapping("/{noticeId}")
    public String NoticeDetail(
            @PathVariable("companyId") String companyId,
            @PathVariable("noticeId") int noticeId,
            HttpSession session,
            Model model){

        String sessionCompanyId = (String) session.getAttribute("companyId");
        if(!companyId.equals(sessionCompanyId)) {
            return "redirect:/login";
        }
        NoticeVO notice = service.readNoticeDetail(noticeId);
        model.addAttribute("notice", notice);
        return "notice/noticeDetail";

    }

 //   @PostMapping()


}
