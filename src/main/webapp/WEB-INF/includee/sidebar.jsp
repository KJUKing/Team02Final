<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    

     <!-- Layout wrapper -->
    <div class="layout-wrapper layout-content-navbar">
      <div class="layout-container">
        <!-- Menu -->

        <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
          <div class="app-brand demo">
            
            <!-- sneat 로고 시작 -->
<a href="${pageContext.request.contextPath }/index.do">
<img 
  alt="logo" 
  src="${pageContext.request.contextPath }/resources/sneat-1.0.0/assets/img/layouts/logo.png" 
  style="width: 65px; height: 55px; margin-left: -18px; margin-right: -10px;"></a>

              <!-- sneat 아이콘 끝 -->
              <a href="${pageContext.request.contextPath }/index.do">
              <span class="app-brand-text demo menu-text fw-bolder ms-2" style="margin-left: -5px;">Work2gether</span>
              </a>
              

            <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
              <i class="bx bx-chevron-left bx-sm align-middle"></i>
            </a>
          </div>

          <div class="menu-inner-shadow"></div>
          <ul class="menu-inner py-1">
			<!-- 타이틀  -->
          	<li class="menu-header small text-uppercase">
              <span class="menu-header-text">연락 관리</span>
            </li>
            <!-- 타이틀 끝 -->
            
            <!-- Dashboard -->
            <li class="menu-item active">
              <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/index.html" class="menu-link">
              <i class='menu-icon tf-icons bx bx-message-alt-edit'></i>
                <div data-i18n="Analytics">쪽지</div>
              </a>
            </li>

			<!-- 
				토글을 주고싶을땐 class="menu-link menu-toggle"
				토글은 안주고싶을땐 class="menu-link"
			 -->
			   <!-- 조직도 -->
            <li class="menu-item">
              <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/cards-basic.html" class="menu-link">
                <i class="menu-icon tf-icons bx bx-collection"></i>
                <div data-i18n="Basic">조직도</div>
              </a>
            </li>

            <!-- Layouts -->
            <li class="menu-item">		
              <a href="javascript:void(0);" class="menu-link menu-toggle">
                <i class='menu-icon tf-icons bx bx-mail-send'></i>
                <div data-i18n="Layouts">메일</div>
              </a>
			 
			 <!-- 세부 메뉴  -->
              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/layouts-without-menu.html" class="menu-link">
                    <div data-i18n="Without menu">Without menu</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/layouts-without-navbar.html" class="menu-link">
                    <div data-i18n="Without navbar">Without navbar</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/layouts-container.html" class="menu-link">
                    <div data-i18n="Container">Container</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/layouts-fluid.html" class="menu-link">
                    <div data-i18n="Fluid">Fluid</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/layouts-blank.html" class="menu-link">
                    <div data-i18n="Blank">Blank</div>
                  </a>
                </li>
              </ul>
            </li>
			 <!-- 세부 메뉴 끝   -->
            <li class="menu-header small text-uppercase">
              <span class="menu-header-text">작업페이지</span>
            </li>
            <li class="menu-item">
              <a href="javascript:void(0);" class="menu-link menu-toggle">
                <i class="menu-icon tf-icons bx bx-dock-top"></i>
                <div data-i18n="Account Settings">프로젝트 관리</div>
              </a>
              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/pages-account-settings-account.html" class="menu-link">
                    <div data-i18n="Account">#</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/pages-account-settings-notifications.html" class="menu-link">
                    <div data-i18n="Notifications">#</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/pages-account-settings-connections.html" class="menu-link">
                    <div data-i18n="Connections">#</div>
                  </a>
                </li>
              </ul>
            </li>
            <li class="menu-item">
              <a href="javascript:void(0);" class="menu-link menu-toggle">
<!--                 <i class="menu-icon tf-icons bx bx-lock-open-alt"></i> -->
                <i class='menu-icon tf-icons bx bx-calendar'></i>
                <div data-i18n="Authentications">일정 관리</div>
              </a>
              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/auth-login-basic.html" class="menu-link" target="_blank">
                    <div data-i18n="Basic">Login</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/auth-register-basic.html" class="menu-link" target="_blank">
                    <div data-i18n="Basic">Register</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/auth-forgot-password-basic.html" class="menu-link" target="_blank">
                    <div data-i18n="Basic">Forgot Password</div>
                  </a>
                </li>
              </ul>
            </li>
            <li class="menu-item">
              <a href="javascript:void(0);" class="menu-link menu-toggle">
                <i class='menu-icon tf-icons bx bx-copy-alt'></i>
                <div data-i18n="Misc">결재관리</div>
              </a>
              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/pages-misc-error.html" class="menu-link">
                    <div data-i18n="Error">Error</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/pages-misc-under-maintenance.html" class="menu-link">
                    <div data-i18n="Under Maintenance">Under Maintenance</div>
                  </a>
                </li>
              </ul>
            </li>
             <li class="menu-item">
              <a href="javascript:void(0);" class="menu-link">
                <i class='menu-icon tf-icons bx bx-cloud'></i>
                <div data-i18n="Misc">스토리지</div>
              </a>
              </li>
            <!-- Components -->
            <li class="menu-header small text-uppercase"><span class="menu-header-text">커뮤니티</span></li>
         
            <!-- User interface -->
            <li class="menu-item">
              <a href="javascript:void(0)" class="menu-link menu-toggle">
               
				<i class='menu-icon tf-icons bx bx-clipboard'></i>
                <div data-i18n="User interface">공지 사항</div>
              </a>
              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-accordion.html" class="menu-link">
                    <div data-i18n="Accordion">Accordion</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-alerts.html" class="menu-link">
                    <div data-i18n="Alerts">Alerts</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-badges.html" class="menu-link">
                    <div data-i18n="Badges">Badges</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-buttons.html" class="menu-link">
                    <div data-i18n="Buttons">Buttons</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-carousel.html" class="menu-link">
                    <div data-i18n="Carousel">Carousel</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-collapse.html" class="menu-link">
                    <div data-i18n="Collapse">Collapse</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-dropdowns.html" class="menu-link">
                    <div data-i18n="Dropdowns">Dropdowns</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-footer.html" class="menu-link">
                    <div data-i18n="Footer">Footer</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-list-groups.html" class="menu-link">
                    <div data-i18n="List Groups">List groups</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-modals.html" class="menu-link">
                    <div data-i18n="Modals">Modals</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-navbar.html" class="menu-link">
                    <div data-i18n="Navbar">Navbar</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-offcanvas.html" class="menu-link">
                    <div data-i18n="Offcanvas">Offcanvas</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-pagination-breadcrumbs.html" class="menu-link">
                    <div data-i18n="Pagination &amp; Breadcrumbs">Pagination &amp; Breadcrumbs</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-progress.html" class="menu-link">
                    <div data-i18n="Progress">Progress</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-spinners.html" class="menu-link">
                    <div data-i18n="Spinners">Spinners</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-tabs-pills.html" class="menu-link">
                    <div data-i18n="Tabs &amp; Pills">Tabs &amp; Pills</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-toasts.html" class="menu-link">
                    <div data-i18n="Toasts">Toasts</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-tooltips-popovers.html" class="menu-link">
                    <div data-i18n="Tooltips & Popovers">Tooltips &amp; popovers</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/ui-typography.html" class="menu-link">
                    <div data-i18n="Typography">Typography</div>
                  </a>
                </li>
              </ul>
            </li>

            <!-- Extended components -->
            <li class="menu-item">
              <a href="javascript:void(0)" class="menu-link menu-toggle">
<!--                 <i class="menu-icon tf-icons bx bx-copy"></i> -->
                <i class='menu-icon tf-icons bx bx-note'></i>
                <div data-i18n="Extended UI">문의 게시판</div>
              </a>
              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/extended-ui-perfect-scrollbar.html" class="menu-link">
                    <div data-i18n="Perfect Scrollbar">Perfect scrollbar</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/extended-ui-text-divider.html" class="menu-link">
                    <div data-i18n="Text Divider">Text Divider</div>
                  </a>
                </li>
              </ul>
            </li>

            <li class="menu-item">
              <a href="icons-boxicons.html" class="menu-link">
<!--                 <i class="menu-icon tf-icons bx bx-crown"></i> -->
                <i class='menu-icon tf-icons bx bx-columns'></i>
                <div data-i18n="Boxicons">설문 및 투표</div>
              </a>
            </li>
            
            <li class="menu-item">
              <a href="icons-boxicons.html" class="menu-link">
                 <i class='menu-icon tf-icons bx bxs-notification'></i>
                <div data-i18n="Boxicons">시설 예약</div>
              </a>
            </li>

            <!-- Forms & Tables -->
            <li class="menu-header small text-uppercase"><span class="menu-header-text">관리</span></li>
            <!-- Forms -->
            <li class="menu-item">
              <a href="javascript:void(0);" class="menu-link menu-toggle">
                <i class='menu-icon tf-icons bx bx-cog'></i>
                <div data-i18n="Form Elements">시스템 관리</div>
              </a>
              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/forms-basic-inputs.html" class="menu-link">
                    <div data-i18n="Basic Inputs">조직 관리</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/forms-input-groups.html" class="menu-link">
                    <div data-i18n="Input groups">로그 관리</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/forms-input-groups.html" class="menu-link">
                    <div data-i18n="Input groups">인사 관리</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/forms-input-groups.html" class="menu-link">
                  
                    <div data-i18n="Input groups">그룹웨어 결제정보</div>
                  </a>
                </li>
              </ul>
            </li>
<!--             <li class="menu-item"> -->
<!--               <a href="javascript:void(0);" class="menu-link menu-toggle"> -->
<!--                 <i class="menu-icon tf-icons bx bx-detail"></i> -->
<!--                 <div data-i18n="Form Layouts">Form Layouts</div> -->
<!--               </a> -->
<!--               <ul class="menu-sub"> -->
<!--                 <li class="menu-item"> -->
<%--                   <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/form-layouts-vertical.html" class="menu-link"> --%>
<!--                     <div data-i18n="Vertical Form">Vertical Form</div> -->
<!--                   </a> -->
<!--                 </li> -->
<!--                 <li class="menu-item"> -->
<%--                   <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/form-layouts-horizontal.html" class="menu-link"> --%>
<!--                     <div data-i18n="Horizontal Form">Horizontal Form</div> -->
<!--                   </a> -->
<!--                 </li> -->
<!--               </ul> -->
<!--             </li> -->
            <!-- Tables -->
<!--             <li class="menu-item"> -->
<%--               <a href="${pageContext.request.contextPath}/resources/sneat-1.0.0/html/tables-basic.html" class="menu-link"> --%>
<!--                 <i class="menu-icon tf-icons bx bx-table"></i> -->
<!--                 <div data-i18n="Tables">Tables</div> -->
<!--               </a> -->
<!--             </li> -->
<!--             Misc -->
<!--             <li class="menu-header small text-uppercase"><span class="menu-header-text">Misc</span></li> -->
            
<!--             <li class="menu-item"> -->
<!--               <a -->
<!--                 href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/" -->
<!--                 target="_blank" -->
<!--                 class="menu-link" -->
<!--               > -->
<!--                 <i class="menu-icon tf-icons bx bx-file"></i> -->
<!--                 <div data-i18n="Documentation">Documentation</div> -->
<!--               </a> -->
<!--             </li> -->
          </ul>
        </aside>
        <!-- / Menu -->
      </div>
    </div>
        
