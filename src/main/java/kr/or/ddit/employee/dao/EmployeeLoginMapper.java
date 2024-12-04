package kr.or.ddit.employee.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.OAuthVO;

@Mapper
public interface EmployeeLoginMapper {
	public EmployeeVO loginResult(EmployeeVO employee);
	public OAuthVO getOAuthInfo(String employeeId);

}
