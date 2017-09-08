<%@ tag import="jp.co.tis.adc.vote.validation.ValidationFilter" %>
<%@ tag import="jp.co.tis.adc.vote.validation.ValidationResult" %>
<%@ tag import="java.util.Map.Entry" %>
<%@ tag pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="target" required="true" %>

<c:set var="hoge" value="${requestScope.errors[target]}" scope="request"/>
<c:set var="tgt" value="${target}" scope="request"/>

<c:forEach var="msg" items="${requestScope.errors[target]}">
  <span class="help-block"><c:out value="${msg}"/></span>
</c:forEach>



