<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>營材食教</title>

<!-- *************每一頁head裡面都要include這個css連結******************* -->
<%@ include file="/front_end_example/CSS_link.jsp" %>
<!-- *************每一頁head裡面都要include這個css連結******************* -->


<style>

.pagination {

margin-bottom: 30px;

}


</style>


</head>


<body>
<!-- *************每一頁body最前面都要include這個header連結******************* -->
<%@ include file="/front_end_example/header_link.jsp" %>
<!-- *************每一頁body最前面都要include這個header連結******************* -->



<div class="container this_page">
<!-- 服務很好先做一個置中的div(開頭) -->

       <!-- Courses Section Start -->
        <div class="section section-padding-02">
            <div class="container">

                <!-- Courses Search bar Start -->
                <div class="courses-search-bar">

                    <!-- Courses Select Start -->
                    <div class="courses-select">
                        <select>
                            <option data-display="All Category">All Category</option>
                            <option value="1">Education</option>
                            <option value="2">Design</option>
                            <option value="3">Education</option>
                            <option value="4">Design</option>
                        </select>
                    </div>
                    <!-- Courses Select End -->

                    <!-- Courses Search Start -->
                    <div class="courses-search">
                        <form action="#">
                            <input type="text" placeholder="Search here">
                            <button><i class="icofont-search"></i></button>
                        </form>
                    </div>
                    <!-- Courses Search End -->

                </div>
                <!-- Courses Search bar End -->

                <!-- Courses Wrapper End -->
                <div class="courses-wrapper-02">
                    <div class="row gx-xxl-5">
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-1.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$98</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Ryan Patterson</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Children Nutrition and Cooking</a></h4>
                                        <ul class="meta">
                                            <li>08 hr 20 mins</li>
                                            <li>28 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-2.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$72</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Arlene Daniels</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Introduction to Food and Health. </a></h4>
                                        <ul class="meta">
                                            <li>09 hr 25 mins</li>
                                            <li>16 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-3.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$68</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Selina Benton</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Nutrition and Lifestyle in Pregnancy</a></h4>
                                        <ul class="meta">
                                            <li>03 hr 38 mins</li>
                                            <li>18 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-4.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$98</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Ryan Patterson</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Expertise on Fitness, Nutrition and Health

                                            </a></h4>
                                        <ul class="meta">
                                            <li>02 hr 16 mins</li>
                                            <li>14 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-5.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$72</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Arlene Daniels</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Hacking exercise for health new science of fitness</a></h4>
                                        <ul class="meta">
                                            <li>06 hr 12 mins</li>
                                            <li>35 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-6.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$68</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Selina Benton</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Designing Your Personal Weight Loss Plan</a></h4>
                                        <ul class="meta">
                                            <li>09 hr 34 mins</li>
                                            <li>28 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-7.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$68</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Selina Benton</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Children Nutrition and Cooking</a></h4>
                                        <ul class="meta">
                                            <li>09 hr 34 mins</li>
                                            <li>28 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-8.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$68</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Arlene Daniels</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Introduction to Food and Health. </a></h4>
                                        <ul class="meta">
                                            <li>09 hr 34 mins</li>
                                            <li>28 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Courses End -->
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <!-- Single Courses Start -->
                            <div class="single-courses">
                                <div class="courses-images">
                                    <a href="courses-details-left-sidebar.html"><img src="assets/images/courses/courses-9.jpg" alt="courses"></a>
                                </div>
                                <div class="courses-content">
                                    <div class="courses-price">
                                        <span class="price">$68</span>
                                    </div>
                                    <div class="content-wrapper">
                                        <p class="author">By: <a href="#">Selina Benton</a></p>
                                        <h4 class="title"><a href="courses-details-left-sidebar.html">Nutrition and Lifestyle in Pregnancy</a></h4>
                                        <ul class="meta">
                                            <li>09 hr 34 mins</li>
                                            <li>28 Lectures</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Single Courses End -->
                        </div>
                    </div>
                </div>
                <!-- Courses Wrapper End -->

                <!-- Page Pagination End -->
                <div class="page-pagination">
                    <ul class="pagination justify-content-center">
                        <li><a href="#"><i class="icofont-rounded-left"></i></a></li>
                        <li><a class="active" href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#"><i class="icofont-rounded-right"></i></a></li>
                    </ul>
                </div>
                <!-- Page Pagination End -->

            </div>
        </div>
        <!-- Courses Section End -->

<br>
<br>
<br>
<br>





















<!-- 服務很好先做一個置中的div(結束) -->
</div>
<!-- *************每一頁body最後面都要include這個footer連結******************* -->
<%@ include file="/front_end_example/footer_link.jsp" %>
<!-- *************每一頁body最後面都要include這個footer連結******************* -->
<!-- *************每一頁body最後面都要include這個js連結******************* -->
<%@ include file="/front_end_example/js_link.jsp" %>
<!-- *************每一頁body最後面都要include這個js連結******************* -->
</body>
</html>