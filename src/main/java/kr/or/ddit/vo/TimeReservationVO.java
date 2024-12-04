package kr.or.ddit.vo;

import java.util.List;

public class TimeReservationVO {
	private String timeCode;
	private String timeRange;
	
	private List<RoomReservationVO> roomReserList;// Has Many (1:n)
}
