<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function _go() {
		var pc = $("#pageCode").val();//获取文本框中的当前页码
		if(!/^[1-9]\d*$/.test(pc)) {//对当前页码进行整数校验
			alert('请输入正确的页码！');
			return;
		}
		if(pc > ${info.pages}) {//判断当前页码是否大于最大页
			alert('请输入正确的页码！');
			return;
		}
		location = "/goodplus/getbooks/${cid }?pageNum="+pc;
	}
</script>






<div class="divBody">
  <div class="divContent">
    <%--上一页 --%>
	<c:choose>
		<c:when test="${info.pageNum eq 1}">
			<span class="spanBtnDisabled">上一页</span>
		</c:when>
		<c:otherwise>
			<a href="/goodplus/getbooks/${cid }?pageNum=${info.pageNum -1}" class="aBtn bold">上一页</a>
		</c:otherwise>
	</c:choose>
        
       
	<c:choose>
 	<c:when test="${info.pages <= 6 }">
 		<c:set var="begin" value="1"/>
 		<c:set var="end" value="${info.pages }"/>
 	</c:when>
 	<c:otherwise>
 		<c:set var="begin" value="${info.pageNum-2 }"/>
 		<c:set var="end" value="${info.pageNum + 3}"/>
 		<c:if test="${begin < 1 }">
 		  <c:set var="begin" value="1"/>
 		  <c:set var="end" value="6"/>
 		</c:if>
 		<c:if test="${end > info.pages }">
 		  <c:set var="begin" value="${info.pages-5 }"/>
 		  <c:set var="end" value="${info.pages }"/>
 		</c:if> 		
 	</c:otherwise>
 </c:choose>
 
 <c:forEach begin="${begin }" end="${end }" var="i">
   <c:choose>
   	  <c:when test="${i eq info.pageNum }">
   	    <span class="spanBtnSelect">${i }</span>
   	  </c:when>
   	  <c:otherwise>
   	    <a href="/goodplus/getbooks/${cid }?pageNum=${i}" class="aBtn">${i }</a>
   	  </c:otherwise>
   </c:choose>
           
 </c:forEach>
    
    <%-- 计算begin和end --%>
      <%-- 如果总页数<=6，那么显示所有页码，即begin=1 end=${pb.tp} --%>
        <%-- 设置begin=当前页码-2，end=当前页码+3 --%>
          <%-- 如果begin<1，那么让begin=1 end=6 --%>
          <%-- 如果end>最大页，那么begin=最大页-5 end=最大页 --%>

    
    <%-- 显示页码列表 --%>
         <!--  <span class="spanBtnSelect">1</span>
          <a href="" class="aBtn">2</a>
          <a href="" class="aBtn">3</a>
          <a href="" class="aBtn">4</a>
          <a href="" class="aBtn">5</a>
          <a href="" class="aBtn">6</a> -->

    
    <%-- 显示点点点 --%>
    <c:if   test="${end <info.pages }"></c:if>
      <span class="spanApostrophe">...</span> 

    
     <%--下一页 --%>
     <c:choose>
     	<c:when test="${info.pageNum == info.pages }">
     		<span class="spanBtnDisabled">下一页</span>
     	</c:when>
     	<c:otherwise>
     		 <a href="/goodplus/getbooks/${cid }?pageNum=${info.pageNum+1}" class="aBtn bold">下一页</a> 
     	</c:otherwise>
     </c:choose>
        
       
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <%-- 共N页 到M页 --%>
    <span>共${info.pages }页</span>
    <span>到</span>
    <input type="text" class="inputPageCode" id="pageCode" value="${info.pageNum }"/>
    <span>页</span>
    <a href="javascript:_go();" class="aSubmit">确定</a>
  </div>
</div>