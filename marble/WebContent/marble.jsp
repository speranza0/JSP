<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marble 게임</title>
    <link rel="stylesheet" href="css/page.css" />
    <link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main.jsp">Marble 게시판</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">Marble 메인</a></li>
				<li class="active"><a href="marble.jsp">Marble 게임</a></li>
				<li><a href="list.jsp">랭킹</a></li>
				<li><a>${member.id}님의 정보</a></li>
			</ul>
			<%
				String userID = null;
				if (session.getAttribute("id") != null) {
					userID = (String) session.getAttribute("id");
				}
					if(userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<%
					} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
					}
			%>
		</div>
	</nav>
	<div id="root">
      <div class="container">
        <main id="marble">
          <div class="contents">
            <table id="board">
              <tr class="line1">
                <td>
                  <span id="pos1"
                    ><img id="horse" src="images/knight.png" alt=""
                  /></span>
                </td>
                <td><span id="pos2"></span></td>
                <td><span id="pos3"></span></td>
                <td><span id="pos4"></span></td>
                <td><span id="pos5"></span></td>
                <td><span id="pos6"></span></td>
                <td><span id="pos7"></span></td>
                <td><span id="pos8"></span></td>
              </tr>
              <tr class="line2">
                <td><span id="pos24"></span></td>
                <td class="content-box" colspan="6">
                  <p id="round"></p>
                  <p id="announce"></p>
                  <p id="alert"></p>
                </td>
                <td><span id="pos9"></span></td>
              </tr>
              <tr class="line3">
                <td><span id="pos23"></span></td>
                <td class="content-box" colspan="6" rowspan="3">
                  <div><img id="dicepic" src="images/d1.png" alt="" /></div>
                  <button type="button" class="shuffle">굴려굴려 주사위</button>
                </td>
                <td><span id="pos10"></span></td>
              </tr>
              <tr class="line4">
                <td><span id="pos22"></span></td>
                <td><span id="pos11"></span></td>
              </tr>
              <tr class="line5">
                <td><span id="pos21"></span></td>
                <td><span id="pos12"></span></td>
              </tr>
              <tr class="line6">
                <td><span id="pos20"></span></td>
                <td><span id="pos19"></span></td>
                <td><span id="pos18"></span></td>
                <td><span id="pos17"></span></td>
                <td><span id="pos16"></span></td>
                <td><span id="pos15"></span></td>
                <td><span id="pos14"></span></td>
                <td><span id="pos13"></span></td>
              </tr>
            </table>
            <div id="rule">
              <p>규칙 설명</p>
              <p>1. 주사위를 굴리면 그 숫자만큼 말이 이동한다.</p>
              <p>2. 빨간색 칸에 들어가면 시작위치로 돌아간다.</p>
              <p>
                3. 초록색 칸에 들어가면 1~3까지의 보너스 숫자만큼 추가 이동한다.
              </p>
              <p>4. 3바퀴를 돌면 승리한다.</p>
            </div>
          </div>
        </main>
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
    	var id = "${member.id}";
    	var path = "${contextPath}";
    </script>
    <script src="js/page.js"></script>
</body>
</html>