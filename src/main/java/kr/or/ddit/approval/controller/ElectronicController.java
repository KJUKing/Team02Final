package kr.or.ddit.approval.controller;

import kr.or.ddit.approval.service.ElectronicService;
import kr.or.ddit.vo.ElectronicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/work2gether/{companyId}/electronic")
public class ElectronicController {

    @Autowired
    private ElectronicService service;

    // 1. 결재 문서 목록 조회 (RM-D06-001, RM-D06-002)
    @GetMapping
    public List<ElectronicVO> getElectronicList(
            @PathVariable("companyId") String companyId,
            HttpSession session) {
        validateCompanyId(companyId, session);
        String empId = (String) session.getAttribute("empId");
        return service.readElectronicList(companyId, empId);
    }

    // 2. 결재 문서 상세 조회 (RM-D06-003)
    @GetMapping("/{electronicId}")
    public ElectronicVO getElectronicDetail(
            @PathVariable("companyId") String companyId,
            @PathVariable("electronicId") String electronicId,
            HttpSession session) {
        validateCompanyId(companyId, session);
        String empId = (String) session.getAttribute("empId");
        return service.readElectronicDetail(companyId, electronicId, empId);
    }

    // 3. 결재 문서 생성 (RM-D02-001 ~ RM-D02-005)
    @PostMapping
    public void createElectronic(
            @PathVariable("companyId") String companyId,
            @RequestBody ElectronicVO electronicVO,
            HttpSession session) {
        validateCompanyId(companyId, session);
        String empId = (String) session.getAttribute("empId");
        electronicVO.setEmpId(empId);
//        electronicVO.setCompanyId(companyId); // ElectronicVO에 companyId 설정
        service.createElectronic(electronicVO);
    }

    // 4. 결재 문서 수정 (RM-D02-006)
    @PutMapping("/{electronicId}")
    public void updateElectronic(
            @PathVariable("companyId") String companyId,
            @PathVariable("electronicId") String electronicId,
            @RequestBody ElectronicVO electronicVO,
            HttpSession session) {
        validateCompanyId(companyId, session);
        String empId = (String) session.getAttribute("empId");
        electronicVO.setEmpId(empId);
//        electronicVO.setCompanyId(companyId); // ElectronicVO에 companyId 설정
        service.modifyElectronic(companyId, electronicId, electronicVO, empId);
    }

    // 5. 결재 문서 삭제 (임시 저장 문서 삭제 등)
    @DeleteMapping("/{electronicId}")
    public void deleteElectronic(
            @PathVariable("companyId") String companyId,
            @PathVariable("electronicId") String electronicId,
            HttpSession session) {
        validateCompanyId(companyId, session);
        String empId = (String) session.getAttribute("empId");
        service.removeElectronic(companyId, electronicId, empId);
    }

    // 회사 ID 검증 메소드
    private void validateCompanyId(String companyId, HttpSession session) {
        String sessionCompanyId = (String) session.getAttribute("companyId");
        if (!companyId.equals(sessionCompanyId)) {
//            throw new UnauthorizedException("유효하지 않은 회사 ID입니다.");
        }
    }
}
