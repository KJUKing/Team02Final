package kr.or.ddit.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.commons.validate.LoginGroup;
import lombok.Data;

@Data
public class EmployeeVO {
	@NotBlank(groups = LoginGroup.class)
	private String empId;
	@NotBlank(groups = LoginGroup.class)
	private String empPass;
	private String empName;
	private LocalDate empBirth;
	private String empGender;
	private String empAddr1;
	private String empAdd2;
	private String empPhone;
	private String empEmail;
	private LocalDate empJoin;
	private String empImg;
	private String empSign;
	private String empStatus;
	private Long empVacation;
	private String posiId;
	private String sempId;
	private String accountId;
}
