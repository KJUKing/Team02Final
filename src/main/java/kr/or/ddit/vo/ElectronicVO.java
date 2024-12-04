package kr.or.ddit.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicVO {
    private String eleId;           // 결재문서번호
    private String eleTitle;        // 결재 제목
    private String eleContent;      // 결재 내용
    private String eleDatavalue;    // 결재데이터 값
    private String eleDraftdate;    // 임시저장일자
    private String elePreservation; // 보존기간
    private String eleStatus;       // 결재상태
    private String eleApprovalYn;   // 전결여부
    private String empId;           // 작성자 사원번호
    private String elelineId;       // 결재선번호
}
