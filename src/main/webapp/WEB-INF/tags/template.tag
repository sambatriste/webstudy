<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="sidePage" %>
<%@ attribute name="pageTitle" required="true" %>

<c:set var="sidePage" value="${empty sidePage ? '/pages/common/side.jsp' : sidePage }"/>

<!DOCTYPE html>
<html>

<head lang="ja">
  <meta charset="UTF-8">
  <title><c:out value="${pageTitle}"/></title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
<div class="container">
  <!-- HEADER -->
  <div id="header">
    <jsp:include page="/pages/common/header.jsp"/>
  </div>
  <div id="content" class="row">
    <!-- SIDE -->
    <div id="side" class="col-sm-3">
      <jsp:include page="${sidePage}"/>
    </div>
    <!-- MAIN -->
    <div id="main" class="col-sm-9">
      <jsp:doBody/>
    </div>
  </div>
  <!-- FOOTER -->
  <div id="footer">
    <jsp:include page="/pages/common/footer.jsp"/>
  </div>
</div>

</body>
</html>
