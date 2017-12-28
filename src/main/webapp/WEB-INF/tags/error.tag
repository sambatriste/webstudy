<%@tag pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="value"  rtexprvalue="true" %>
<!DOCTYPE html>

<c:forEach var="msg" items="${value}">
  <span>
    <font color=#ff0000>
      <c:out value="${msg}"/>
    </font>
  </span>
</c:forEach>
