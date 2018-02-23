<%@ tag pageEncoding="utf-8" %>
<%@ attribute name="msg" type="java.util.Set" required="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="msg" items="${msg}">
     <span><font color="red"><c:out value="${msg}"/></font></span>
</c:forEach>