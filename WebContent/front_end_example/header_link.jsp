 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 
 
 
 <div class="main-wrapper">

        <!-- Header Section Start -->
        <div class="header section">

            <!-- Header Main Start -->
            <div class="header-main">
                <div class="container">

                    <!-- Header Wrapper Start -->
                    <div class="header-wrapper">

                        <!-- Header Logo Start -->
                        <div class="header-logo">
                            <a href="<%= request.getContextPath() %>/Nutras-template/index.html"><img src="<%= request.getContextPath() %>/Nutras-template/assets/images/logo.png" alt="Logo"></a>
                        </div>
                        <!-- Header Logo End -->

                        <!-- Header Menu Start -->
                        <div class="header-menu d-none d-lg-flex">

                            <ul class="nav-menu">
                                 <li>
                                 <a href="#">資訊</a>
                                   <ul class="sub-menu">
                                        <li><a href="<%= request.getContextPath() %>/Nutras-template/courses.html">關於我們</a></li>
                                        <li><a href="<%= request.getContextPath() %>/Nutras-template/-courses.html">最新消息</a></li>
                                        <li><a href="#">常見問題</a>
										<li><a href="#">健康專欄</a>
										<li><a href="#">聯絡我們</a>
                                    </ul>
                                </li>
                                <li><a href="<%= request.getContextPath() %>/Nutras-template/about.html">專屬營養師</a></li>
                                <li>
                                    <a href="#">營養課程</a>
                                    <ul class="sub-menu">
                                        <li><a href="<%= request.getContextPath() %>/Nutras-template/courses.html">尋找課程</a></li>
                                        <li><a href="<%= request.getContextPath() %>/Nutras-template/my-courses.html">我的課程</a></li>
                                        <li><a href="#">課程頁面</a>
                                            <ul class="sub-menu">
                                                <li><a href="<%= request.getContextPath() %>/Nutras-template/courses-details-left-sidebar.html">課程頁面1</a></li>
                                                <li><a href="<%= request.getContextPath() %>/Nutras-template/courses-details-right-sidebar.html">課程頁面2</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">營養商城 </a>
                                    <ul class="sub-menu">
                                        <li><a href="<%= request.getContextPath() %>/Nutras-template/after-enroll.html">After Enroll</a></li>
                                        <li><a href="<%= request.getContextPath() %>/Nutras-template/courses-admin.html">Instructor Dashboard (Course List)</a></li>

                                    </ul>
                                </li>
                                <li>
                                    <a href="#">一般會員專區</a>
                                    <ul class="sub-menu">
                                        <li>
                                            <a href="#">一般會員</a>
                                            <ul class="sub-menu">
                                                <li><a href="<%= request.getContextPath() %>/Nutras-template/blog-grid.html">Blog Grid</a></li>
                                                <li><a href="<%= request.getContextPath() %>/Nutras-template/blog-left-sidebar.html">Blog Left Sidebar</a></li>
                                                <li><a href="<%= request.getContextPath() %>/Nutras-template/blog-right-sidebar.html">Blog Right Sidebar</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="#">營養師會員</a>
                                            <ul class="sub-menu">
                                                <li><a href="<%= request.getContextPath() %>/Nutras-template/blog-details-left-sidebar.html">Blog Details Left Sidebar</a></li>
                                                <li><a href="<%= request.getContextPath() %>/Nutras-template/blog-details-right-sidebar.html">Blog Details Right Sidebar</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="<%= request.getContextPath() %>/Nutras-template/contact.html">營養師會員專區</a></li>
                            </ul>


                        </div>
                        <!-- Header Menu End -->

                        <!-- Header Toggle Start -->
                        <div class="header-toggle d-lg-none">

                            <a class="btn btn-secondary btn-hover-primary" href="<%= request.getContextPath() %>/Nutras-template/login.html">Sign Up</a>

                            <a href="#" class="menu-toggle">
                                <span></span>
                                <span></span>
                                <span></span>
                            </a>
                        </div>
                        <!-- Header Toggle End -->

                    </div>
                    <!-- Header Wrapper End -->

                </div>
            </div>
            <!-- Header Main End -->

        </div>
        <!-- Header Section End -->
</div>