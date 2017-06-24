<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="/WEB-INF/views/jsp/public/Header.jsp"></jsp:include>    
<div class="container" style="margin-top: 6px">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="carousel slide" id="carousel-556371">
        <ol class="carousel-indicators">
          <li data-slide-to="0" data-target="#carousel-556371">
          </li>
          <li data-slide-to="1" data-target="#carousel-556371">
          </li>
          <li data-slide-to="2" data-target="#carousel-556371" class="active">
          </li>
        </ol>
        <div class="carousel-inner">
          <div class="item">
            <img alt="" style="height: 460px; width: 100%" src="http://www.class.cn/shtml/focus_pic/toppic_20160726.jpg" />
            <div class="carousel-caption">
              <h4>
                轮播标题
              </h4>
              <p>
              轮播内容
              </p>
            </div>
          </div>
          <div class="item">
            <img alt="" style="height: 460px; width: 100%" src="http://www.class.cn/shtml/focus_pic/toppic_20160929.jpg" />
            <div class="carousel-caption">
             <h4>
                轮播标题
              </h4>
              <p>
              轮播内容
              </p>
            </div>
          </div>
          <div class="item active">
            <img alt="" style="height: 460px; width: 100%" src="http://www.class.cn/shtml/focus_pic/toppic_20160105.jpg" />
            <div class="carousel-caption">
              <h4>
                轮播标题
              </h4>
              <p>
              轮播内容
              </p>
            </div>
          </div>
        </div> <a class="left carousel-control" href="#carousel-556371" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-556371" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
      </div>
    </div>

  </div>
  <div class="row clearfix" style="margin-top: 10px;">
    <div class="col-md-10 col-md-push-2 column">
      <div class="row">
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px;" src="http://v2.data.class.cn/course/01/08/54/3/course_108543_298x150.jpg" />
            <div class="caption">
              <p>
                课程名称
              </p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px " src="http://v2.data.class.cn/course/01/05/97/7/course_105977_298x150.jpg" />
            <div class="caption">
              <p>  课程名称</p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px " src="http://v2.data.class.cn/course/00/06/97/5/course_6975_298x150.jpg" />
            <div class="caption">
              <p>  课程名称              </p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px " src="http://v2.data.class.cn/course/00/05/63/7/course_5637_298x150.jpg" />
            <div class="caption">
              <p> 课程名称              </p>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px " src="http://v2.data.class.cn/course/00/08/96/5/course_8965_298x150.jpg" />
            <div class="caption">
              <p>  课程名称 </p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px " src="http://v2.data.class.cn/course/00/08/96/5/course_8965_298x150.jpg" />
            <div class="caption">
              <p>  课程名称             </p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px " src="http://v2.data.class.cn/course/01/08/47/8/course_108478_298x150.jpg" />
            <div class="caption">
              <p>
                  课程名称
              </p>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="thumbnail">
            <img alt="300x200" style="width:236px; height:112px " src="http://v2.data.class.cn/course/01/05/93/8/course_105938_298x150.jpg" />
            <div class="caption">
              <p>
                  课程名称
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-2 col-md-pull-10 column">
      <div class="list-group">
		<a href="#" class="list-group-item active">
			<h4 class="list-group-item-heading">
				课程列表
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				IT
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				公务员
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				人力资源
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				职业发展
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				常用软件
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				课程培训
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				职业发展
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				常用软件
			</h4>
		</a>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-heading">
				课程培训
			</h4>
		</a>
	</div>
    </div>
  </div>
  
</div>
<jsp:include page="/WEB-INF/views/jsp/public/Footer.jsp"></jsp:include>
</body>
</html>
