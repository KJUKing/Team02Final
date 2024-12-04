package kr.or.ddit.employee.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.employee.dao.EmployeeLoginMapper;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.OAuthVO;

@Service
public class EmployeeLoginServiceImpl implements EmployeeLoginService {
	@Inject
	private EmployeeLoginMapper employeeMapper;
	
	@Override
	public EmployeeVO loginResult(EmployeeVO employee) {
		EmployeeVO myEmp = employeeMapper.loginResult(employee);
		
		if(myEmp==null) {
			// 로그인 실패했으면
			throw new PKNotFoundException("로그인 정보가 존재하지 않습니다.");
		} else {
			// 성공했으면
			return myEmp;
		}
	}

	@Override
	public OAuthVO getOAuthInfo(String employeeId) {
		OAuthVO myOAuth = employeeMapper.getOAuthInfo(employeeId);
		
		if(myOAuth==null) {
			// oauth 정보가 없으면
			throw new PKNotFoundException("oAuth 정보를 확인할 수 없습니다.");
		} else {
			// oauth 정보가 있으면 리턴
			return myOAuth;
		}
	}

}
