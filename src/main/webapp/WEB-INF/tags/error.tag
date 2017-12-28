<%@ tag pageEncoding="utf-8" %>

<%@ attribute name="msg" type="java.util.Set" required="true"%>
<c:forEach var="msg">
    <span><c:out value="${msg}"/></span>
</c:forEach>