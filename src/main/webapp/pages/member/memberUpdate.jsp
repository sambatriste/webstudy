<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>メンバー</title>
  </head>
  <body>
    <form action="update" method="post">
      <input type="hidden"
             name="memberId"
             value="${member.memberId}"/>
      <div class="form-group">
        <label for="familyName">姓</label>
        <input type="text"
               id="familyName"
               name="familyName"
               class="form-control"
               placeholder="山田"
               value="${member.familyName}">
        <c:forEach var="msg" items="${requestScope.errors['familyName']}">
          <span><c:out value="${msg}"/></span>
        </c:forEach>
      </div>
      <div class="form-group">
        <label for="lastName">名</label>
        <input type="text"
               id="lastName"
               name="lastName"
               class="form-control"
               placeholder="太郎"
               value="${member.lastName}">
        <c:forEach var="msg" items="${requestScope.errors['lastName']}">
          <span><c:out value="${msg}"/></span>
        </c:forEach>
      </div>

      <div class="form-group">
        <input type="submit" value="更新">
      </div>
    </form>
  </body>
</html>
