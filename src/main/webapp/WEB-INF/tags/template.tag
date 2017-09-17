<%-- テンプレート --%>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="sidePage" %>
<%@ attribute name="pageTitle" required="true" %>

<c:set var="headerPage" value="/pages/common/header.jsp"/>
<c:set var="defaultSidePage" value="/pages/common/side.jsp"/>
<c:set var="sidePage" value="${empty sidePage ? defaultSidePage : sidePage }"/>
<c:set var="footerPage" value="/pages/common/footer.jsp"/>

<!DOCTYPE html>
<html>
  <head lang="ja">
    <meta charset="UTF-8">
    <title><c:out value="${pageTitle}"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
    <div class="container">
      <!-- HEADER -->
      <div id="header">
        <jsp:include page="${headerPage}"/>
      </div>
      <div id="content">
        <!-- SIDE -->
        <div id="side">
          <jsp:include page="${sidePage}"/>
        </div>
        <!-- MAIN -->
        <div id="main">
          <jsp:doBody/>
        </div>
      </div>
      <!-- FOOTER -->
      <div id="footer">
        <jsp:include page="${footerPage}"/>
      </div>
    </div>
  </body>
</html>
