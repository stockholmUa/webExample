<%@ page pageEncoding="UTF-8" 	contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<head>
	<meta charset="utf8" />
	<meta name="description" content="My first demo jee application" />
	<meta name="keywords" content="jee, java, web, demo, com.sourceit.webtasks" />
	<meta name="author" content="mike" />
	<meta name="copyright" content="Copyright 2015, Webtasks demo application" />
	<title>Demo web application</title>
	
	<link rel="stylesheet" type="text/css" media="all" href="${CONTEXT }/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" media="all" href="${CONTEXT }/resources/css/webtasks.css" />
	<script type="text/javascript" src="${CONTEXT }/resources/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${CONTEXT }/resources/js/webtasks.js"></script>
</head>
<body class="default-style">
	<header class="main-header group" id="main-header">
	<div class="header-left">
		<h1 class="logo header-chunk">
			<a href="http://source-it.com.ua/">source-it</a>
		</h1>
	</div>
	</header>
	
	<section class="main">
		<jsp:include page="${currentPage }" flush="true" />
	</section>
	
	<footer class="site-footer">

		<div class="footer-left">
			©2015 <a href="/">Sourceit</a>
			<em>Demo of web task.</em>
		</div>
	</footer>
</body>
</html>