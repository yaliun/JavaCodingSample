<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- juqery 파일 두개 스타일 쉬트 / 이미지 3개-->
<title>Fancy Tree Menu</title>
<link type="text/css" href="CSS/Fancy_Tree_Menu.css" rel="stylesheet" />
<script type="text/javascript" src="Jquery/jquery.js"></script>
<script type="text/javascript" src="Jquery/treeMenu.js"></script>
 <style type="text/css">
 	.rightPrt {   position:absolute; left:324px; top:274px;}
 	div.link {  width:322px; height:255px; float:left; display:inline; }
	div.link a {  width:100%; height:100%; display:block; text-decoration:none; outline:none 0; } 
 </style>
</head>
<body> 
<div id="main" style="height:1200px;">
    <div id="treeMenu">
    <h2>Product List</h2>
        <ul>
			<li><a href="#" class="parent">케이블 메니지먼트</a><span></span>
				<div>
                    <ul>
				    <li><span></span><a href="#" class="parent">Cablofil / Wire Mesh Cable Tray</a>
                        <div>
                            <ul>
                            <li><span></span><a href="#">Cable Tray - Wire Mesh</a></li><!--소분류 -->
                            <li><span></span><a href="#">Cover</a></li><!--소분류 -->
                            <li><span></span><a href="#">액세서리</a></li><!--소분류 -->
				            </ul>
				        </div>
				    </li>
				    <li><span></span><a href="#" class="parent">Cablofil / Delta Strut</a></li><!--소분류 -->
				    <li><span></span><a href="#" class="parent">Cablofil / Pw Cable Management</a></li><!--소분류 -->
				    <li><span></span><a href="#" class="parent">Swifts / Cable Ladder</a></li><!--소분류 -->
				    <li><span></span><a href="#" class="parent">Swifts / Cable Tray</a></li><!--소분류 -->
				    <li><span></span><a href="#" class="parent">Salamandre </a></li><!--소분류 -->
				    <li><span></span><a href="#" class="parent">DLP</a></li><!--소분류 -->
				    </ul>
				</div>
            </li>
        </ul>
    </div>
</div>
</body>
</html>