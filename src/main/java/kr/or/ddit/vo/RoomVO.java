package kr.or.ddit.vo;

import java.util.List;

public class RoomVO {
	private String roomId;
	private String roomHosu;
	private String roomName;
	private Long roomNum;
	private String roomImg;
	private String roomDetail;
	private String roomYn;
	
	private List<RoomReservationVO> roomReserList;// Has Many (1:n)
}
