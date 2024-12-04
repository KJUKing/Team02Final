<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<style>
	
	
	.custom-container {
        margin-top: -55px; 
    }
	
    .profile {
      display: flex;
      align-items: center;
      gap: 15px;
    }
    
    .profile img {
      width: 50px;
      height: 50px;
      border-radius: 50%;
    }
    
	    /* 카드 높이 균등화 */
	.announcement,
	.todo-list {
    height: 300px; /* 팀 결원 명단과 동일한 높이 */
	}
	
	 /* 캘린더 높이 */
	.calendar-container {
	  height: 500px;
	}
	
	   /* 팀 결원 명단 높이 */
	.team-status {
	  height: 150px;
	}
	
	.card announcement,
	.card todo-list {
		margin-bottom : 150px;
	}
	
.announcement-todo-container {
    display: flex;
    gap: 20px; /* 공지사항과 할 일 목록 사이 간격 */
    height: 100%; /* 부모 높이를 명확히 설정 */
}

.announcement,
.todo-list {
    flex: 1; /* 동일한 너비를 차지 */
    height: 63%; /* 부모 높이에 맞춰 아래로 늘어남 */
}

	
  </style>
<!--  <div class="container mt-4"> -->
<div class="container custom-container">
  <div class="row">
    <!-- 사용자 정보 -->
    <div class="col-md-6">
      <div class="card mb-3">
        <div class="card-body">
          <div class="profile">
            <img src="profile.jpg" alt="프로필 사진">
            <div>
              <p><strong>인사팀</strong><br>xxx 사원</p>
              <p>쪽지확인 | 결재확인</p>
            </div>
          </div>
          <div class="mt-3">
          <div>
            <p> xx:xx</p>
          </div>
            <button class="btn btn-primary btn-sm">출근</button>
            <button class="btn btn-secondary btn-sm">퇴근</button>
            <button class="btn btn-danger btn-sm">퇴근 및 로그아웃</button>
          </div>
        </div>
      </div>
          <!-- 공지사항 -->
<div class="row mt-3" style="height: 100%;">
    <div class="col-md-12 announcement-todo-container">
        <!-- 공지사항 -->
        <div class="card announcement">
            <div class="card-header">
                <h5 class="card-title mb-0">공지사항<button class="btn btn-outline-primary btn-sm">+</button></h5>
            </div>
            <div class="card-body">
                <p>금일 14:00 전 직원 회의가 있습니다.</p>
                
            </div>
        </div>

        <!-- 오늘의 할 일 목록 -->
        <div class="card todo-list">
            <div class="card-header">
                <h5 class="card-title mb-0">오늘의 할 일 목록</h5>
            </div>
            <div class="card-body">
                <ul class="list-group">
                    <li class="list-group-item"><input type="checkbox" />   ERD 수정하기</li>
                    <li class="list-group-item"><input type="checkbox" />   화면 정의서 만들기</li>
                    <li class="list-group-item"><input type="checkbox" />   프로세스 흐름도 만들기</li>
                </ul>
                <button class="btn btn-outline-primary btn-sm mt-3">추가</button>
            </div>
        </div>
    </div>
</div>



   </div>

    <!-- 캘린더 -->
    <div class="col-md-6">
      <div class="card calendar-container">
        <div class="card-header">
          <h5 class="card-title mb-0">2025년 1월</h5>
          <button class="btn btn-outline-primary btn-sm float-end">전체보기</button>
        </div>
        <div class="card-body">
          <!-- 캘린더 내용 -->
          <p> 캘린더</p>
        </div>
      </div>
             <!-- 팀 결원 명단 -->
  <div class="row mt-3">
    <div class="col-md-12">
      <div class="card team-status">
        <div class="card-header">
          <h5 class="card-title mb-0">금일 팀 결원 명단</h5>
        </div>
        <div class="card-body">
          <p>인사팀 xxx 부장: 연차<br>인사팀 xxx 사원: 병가</p>
        </div>
      </div>
    </div>
    </div>

  </div>
  
  </div>



    

 
</div>







