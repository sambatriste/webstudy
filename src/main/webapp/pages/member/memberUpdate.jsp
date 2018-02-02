<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
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
        <tags:error msg="${requestScope.errors['familyName']}" />
      </div>
      <div class="form-group">
        <label for="lastName">名</label>
        <input type="text"
               id="lastName"
               name="lastName"
               class="form-control"
               placeholder="太郎"
               value="${member.lastName}">
        <tags:error msg="${requestScope.errors['lastName']}" />
      </div>
      <input type="hidden" id="version" name="version" value="${member.version}"/>
      <div class="form-group">
        <input type="submit" value="更新">
      </div>
    </form>
  </body>
</html>
