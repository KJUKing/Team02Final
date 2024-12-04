package kr.or.ddit.approval.service;

import kr.or.ddit.vo.ElectronicVO;

import java.util.List;

public interface ElectronicService {
    List<ElectronicVO> readElectronicList(String companyId, String empId);

    ElectronicVO readElectronicDetail(String electronicId, String id, String empId);

    void removeElectronic(String companyId, String electronicId, String empId);

    void modifyElectronic(String companyId, String electronicId, ElectronicVO electronicVO, String empId);

    void createElectronic(ElectronicVO electronicVO);
}
