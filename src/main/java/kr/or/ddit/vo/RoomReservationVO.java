package kr.or.ddit.vo;

import lombok.Data;
import lombok.ToString;

@Data
public class RoomReservationVO {
	private String reserId;
	private String timeCode;
	private String roomId;
	private String reserCause;
	private String reserStatus;
	private String empId;
	
	
	@ToString.Exclude
	private RoomReservationVO roomReser; //Has A 
	@ToString.Exclude
	private TimeReservationVO timeReser; //Has A 
	
}
