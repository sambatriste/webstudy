<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>メンバー登録</title>
  </head>
  <body>
    <form action="register" method="post">
      <div>
        <label for="familyName">姓</label>
        <input type="text"
               id="familyName"
               name="familyName"
               class="form-control"
               placeholder="山田"
               value="${param.familyName}">
        <tags:error value="${requestScope.errors['familyName']}"/>
      </div>
      <div>
        <label for="lastName">名</label>
        <input type="text"
               id="lastName"
               name="lastName"
               class="form-control"
               placeholder="太郎"
               value="${param.lastName}">
        <tags:error value="${requestScope.errors['lastName']}"/>
      </div>
      <div>
        <input type="submit" value="登録">
      </div>
    </form>
  </body>
</html>
