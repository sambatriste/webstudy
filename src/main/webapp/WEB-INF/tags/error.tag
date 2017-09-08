<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="target" required="true" %>


<c:forEach var="msg" items="${requestScope.errors[target]}">
  <span class="help-block"><c:out value="${msg}"/></span>
</c:forEach>



