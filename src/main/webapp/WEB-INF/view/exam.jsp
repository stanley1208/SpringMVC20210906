<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Exam CRUD</title>
<script>
	function deleteExam(id){
		if(confirm('是否要刪除學員編號:'+id)){
			var del_url='${ pageContext.request.contextPath }/mvc/exam/delete/'+id;
			//alert(del_url);
			console.log(del_url);
			window.location.href=del_url;
		}
	}
</script>
<script type="text/javascript" 
src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      google.charts.setOnLoadCallback(drawChart2);
      
      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['考試代號', '報考人數'],
          <c:forEach items="${stat1}" var="s">
          ['${s.key}',${s.value}],
          </c:forEach>
        ]);

        var options = {
          title: '各科考試報名人數'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
      
      function drawChart2() {

          var data = google.visualization.arrayToDataTable([
            ['繳費狀況', '人數'],
            <c:forEach items="${stat2}" var="s">
            ['${s.key}',${s.value}],
            </c:forEach>
          ]);

          var options = {
            title: '繳費狀況人數'
          };

          var chart = new google.visualization.ColumnChart(document.getElementById('columnchart'));

          chart.draw(data, options);
        }
    </script>
<style>
	.error{color:#FF0000}
</style>
</head>
<body style="padding: 15px;">
	<table border="0">
		<tr>
			<!-- 表單資料處理 CRUD -->
			<td valign="top">
				<form:form modelAttribute="exam" 
							class="pure-form" 
							method="post"
							action="${ pageContext.request.contextPath }/mvc/exam/${ action }">
					<fieldset>
						<legend>Exam Post 考試註冊</legend>
						學員編號：<form:input path="id" placeholder="請輸入學員編號" />
						<form:errors path="id" cssClass="error"/>
						<p/>
						考試代號：<form:select path="name">
							<form:option value="">請選擇</form:option>
							<form:option value="808">OCP I 808</form:option>
							<form:option value="809">OCP II 809</form:option>
							<form:option value="900">OCAD 900</form:option>
							
							
						</form:select>
						<form:errors path="name" cssClass="error"/>
						<p/>
						考試時段（可複選）：
						<form:checkbox path="slot" value="A" />上午（A）
						<form:checkbox path="slot" value="B" />下午（B）
						<form:checkbox path="slot" value="C" />晚上（C）
						<form:errors path="slot" cssClass="error"/>
						<p/>
						繳費狀況：
						已繳 <form:radiobutton path="pay" value="true"/>
						未繳 <form:radiobutton path="pay" value="false"/>
						<form:errors path="pay" cssClass="error"/>
						<p/>
						備註：
						<form:textarea path="note"/>
						<p/>
						<button type="submit" class="pure-button pure-button-primary">${ action }</button>
						<button type="reset" class="pure-button pure-button-primary">reset</button>
						<p/>
						錯誤訊息:
						<form:errors path="*" /><!-- 顯示所有的錯誤 -->
					</fieldset>
				</form:form>
				<!-- 資料呈現 -->
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>id</th>
							<th>exam</th>
							<th>slot</th>
							<th>pay</th>
							<th>note</th>
							<th>edit</th>
							<th>delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${ exams }">
						<tr>
							<td>${ e.id }</td>
							<td>${ e.name }</td>
							<td>${ e.slotToString }</td>
							<td>${ e.pay }</td>
							<td>${ e.note }</td>
							<td>
								<button type="button" 
										onclick="location.href='${ pageContext.request.contextPath }/mvc/exam/get/${ e.id }'"
										class="pure-button pure-button-primary">
									edit
								</button>
							</td>
							<td>
								<button type="button" 
										onclick="deleteExam('${e.id}')"
										class="pure-button pure-button-primary">
									delete
								</button>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
			<!-- 資料統計圖 -->
			<td valign="top">
				<!-- 各科考試報名人數 -->
				${stat1 }
				<div id="piechart" style="width: 500px; height: 300px"></div>
				<p/>
				<!-- 考試付款狀況 -->
				${stat2 }
				<div id="columnchart" style="width: 500px; height: 300px"></div>
				
			</td>
		</tr>
	</table>
</body>
</html>