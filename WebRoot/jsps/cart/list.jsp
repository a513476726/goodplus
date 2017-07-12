<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cartlist.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script src="<c:url value='/js/round.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/cart/list.css'/>">
	
	
	
	
	
	
  </head>
  <script type="text/javascript">
  	$(function(){	
  		total();
  		//全选按钮
  		$("#selectAll").click(function(){
  			//alert(123);
  			$(":checkbox[name=checkboxBtn]").each(function(){
  			//	alert(456);
  				if($("#selectAll").attr("checked")){
  					
  					$(this).attr("checked",true);
  				}else{
  					$(this).attr("checked",false);
  				}
  			});	
  		});
  		//  条目的  checkbox
  		$(":checkbox[name=checkboxBtn]").click(function(){
  			
  			total();
  		});
  		
  		
  		//  删除按钮加单击事件
  		
  		$(".delclass").click(function(){
  			if(confirm("您确定删除吗？")){
  				return  true  ;
  			}
  			return false  ;
  		});
  		
  		
  		//jian
  		
  		$(".jian").click(function(){
  			var  value  = Number($("#"+$(this).attr("jianid")+"quantity").val());
  			if(value==1){
  				///////////////////////////////////////shanchu
  				if(confirm("您确定删除该条目吗？")){
  					
  					location.href="/goodplus/deletecartitembycartitemid/"+$(this).attr("jianid");
  				}
  			}else{
  			
  				// -1
  				$("#"+$(this).attr("jianid")+"quantity").val(value-1);
  				//  subtotal
  				//   quantity  *     currprice
  				
  				var  quantity  =Number($("#"+$(this).attr("jianid")+"quantity").val());
  				
  				var  currprice  =Number($("#"+$(this).attr("jianid")+"currprice").text());
  			//	alert($("#"+$(this).attr("jianid")+"Total").text());
  				var   subtotal  = round( quantity *  currprice,2);
  				$("#"+$(this).attr("jianid")+"Total").text(subtotal);
  				//ajax
  				/* 
  				如果 是使用SpringMVC  jsonlib 的话  
  				1,contentType :  "application/json;charset=utf-8"
  				2,JSON.stringify(json对象)
  				3, 后台      用引用类型的  对象来  接收 。    Student   Person   @requestBody
  				4,如果  有返回 ，  那么   打  @responseBody 注解  在  返回值类型的前面。
  				
  				
  				
  				如果   使用  一般JSON格式传值
  				1,dataType: "json",
  				2,data :JSON对象
  				3，后台，  不打任何json lib注解，参数  与JSON 的key   名字相同  即可。可以多个
  				
  				*/
  				$.ajax({
  					cache: false,
  					async: false,
  					type: "POST",
  					dataType: "json",
  					/* contentType :  "application/json;charset=utf-8", */
  					data: {'quantity' : quantity,'currprice':currprice},
  					url: "/goodplus/updatequantity/"+$(this).attr("jianid"),
  					success: function(xxx) {
  						
  						
  					}
  				});
  			}
  			total();
  		});
  		
  		
  		
  		//jia
  		$(".jia").click(function(){
  				//alert(123);
  				// -1
  				var  value  = Number($("#"+$(this).attr("jianid")+"quantity").val());
  				$("#"+$(this).attr("jianid")+"quantity").val(value+1);
  				//  subtotal
  				//   quantity  *     currprice
  				
  				var  quantity  =Number($("#"+$(this).attr("jianid")+"quantity").val());
  				
  				var  currprice  =Number($("#"+$(this).attr("jianid")+"currprice").text());
  			//	alert($("#"+$(this).attr("jianid")+"Total").text());
  				var   subtotal  = round( quantity *  currprice,2);
  				$("#"+$(this).attr("jianid")+"Total").text(subtotal);
  				
  				//
  				
  				$.ajax({
  					cache: false,
  					async: false,
  					type: "POST",
  					dataType: "json",
  					/* contentType :  "application/json;charset=utf-8", */
  					data: {'quantity' : quantity},
  					url: "/goodplus/updatequantity/"+$(this).attr("jianid"),
  					success: function(xxx) {
  						
  						
  					}
  				});
  				
  			total();
  		});
  		
  	});
  
  	function  total(){
  		var  sum  =  0 ;
  		$(":checkbox[name=checkboxBtn][checked=true]").each(function (){
  			
  			var  value =Number($("#"+$(this).attr("id")+"Total").text()) ;
  			sum+=value ;
  		});
  		
  		$("#total").text(round(sum,2));
  	}
  </script>
  <body>
<%-- ${cartItems } --%>
	
	<c:choose >
	
		<c:when test="${fn:length(cartItems) == 0 }">
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="<c:url value='/images/icon_empty.png'/>"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>  
		</c:when>
		<c:otherwise>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<tr align="center" bgcolor="#efeae5">
		<td align="left" width="50px">
			<input type="checkbox" id="selectAll" checked="checked"/><label for="selectAll">全选</label>
		</td>
		<td colspan="2">商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>
	<c:forEach  items="${cartItems }"  var ="cartItem">

	<tr align="center">
		<td align="left">
			<input value="${cartItem.cartitemid }" id="${cartItem.cartitemid }" type="checkbox" name="checkboxBtn" checked="checked"/>
		</td>
		<td align="left" width="70px">
			<a class="linkImage" href="<c:url value='/selectbybid/${cartItem.book.bid }'/>"><img border="0" width="54" align="top" src="<c:url value='/${cartItem.book.imageB }'/>"/></a>
		</td>
		<td align="left" width="400px">
		    <a href="<c:url value='/selectbybid/${cartItem.book.bid }'/>"><span>${cartItem.book.bname }</span></a>
		</td>
		<td><span>&yen;<span class="currPrice" id="${cartItem.cartitemid }currprice">${cartItem.book.currprice }</span></span></td>
		<td>
			<a class="jian" jianid="${cartItem.cartitemid }" id="${cartItem.cartitemid }jian"></a><input class="quantity" readonly="readonly" id="${cartItem.cartitemid }quantity" type="text" value="${cartItem.quantity }"/><a class="jia" id="${cartItem.cartitemid }jia" jianid="${cartItem.cartitemid }"></a>
		</td>
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id="${cartItem.cartitemid }Total">${cartItem.subTotal}</span></span>
		</td>
		<td>
			<a  class="delclass" id="${cartItem.cartitemid }delid"  href="<c:url value='/deletecartitembycartitemid/${cartItem.cartitemid }'/>">删除</a>
			    
		</td>
	</tr>


</c:forEach>
	<tr>
		<td colspan="4" class="tdBatchDelete">
		
			<a  id="piliangdelid"  href="javascript:piliang()" >批量删除</a>
			<script type="text/javascript">
				function  piliang(){
				
						if(confirm("您确定删除选中的条目吗？")){
							var  ids  = new Array();
							$(":checkbox[name=checkboxBtn][checked=true]").each(function(){
								
								ids.push($(this).attr("id"));
							});
							
							location.href ="/goodplus/deletecartitems?ids="+ids;
							//return true ;
							return  true;
							
						}else{
							return false  ;
						}
						
					}
				
			
			</script>
			
		</td>
		<td colspan="3" align="right" class="tdTotal">
			<span >总计：</span><span class="price_t">&yen;<span id="total"></span></span>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right">
			<a href='javascript:jiesuan();' id="jiesuan" class="jiesuan"></a>
			<form id="form1" action="<c:url value='/jsps/cart/showitem.jsp'/>" method="post">
		<!-- <input type="hidden" name="cartItemIds" id="cartItemIds"/>
		<input type="hidden" name="method" value="loadCartItems"/> -->
	</form>
	<script type="text/javascript">
		function jiesuan(){
			//alert(123);
			var  ids = new Array();
			$(":checkbox[name='checkboxBtn'][checked=true]").each(function(){
				var id = $(this).attr("id");
				ids.push(id);
				
			});	
			$("#form1").attr("action","/goodplus/jiesuan/"+ids);
			$("#form1").submit();
			//return  true;
		}
	</script>
		</td>
	</tr>
</table>
	<!-- 
		spingmvc中，    获取请求参数 数据类型 为数组时
		1,  ajax  
		2,  name="ids"   value = "xxx"    
		2,  name="ids"   value = "yyy"    
		2,  name="ids"   value = "zzz"    
		
		<!--String []    ids -->
	 
<%-- 	<form id="form1" action="<c:url value='/jsps/cart/showitem.jsp'/>" method="post">
		
		
		<c:forEach items="">
			<input type="hidden" name="ids" id="ids"  value=""/>
		
		</c:forEach>
		
		
		
		
	</form>
		 	 --%>
		
		</c:otherwise>
	</c:choose>
	
	

<!-- <br/>
<br/> -->





  </body>
</html>
