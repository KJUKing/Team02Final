package kr.or.ddit.employee.service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.OAuthVO;

public interface EmployeeLoginService {
	public EmployeeVO loginResult(EmployeeVO employee);
	public OAuthVO getOAuthInfo(String employeeId);
}
