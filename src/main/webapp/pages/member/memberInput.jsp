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
        <c:forEach var="msg" items="${requestScope.errors['familyName']}">
          <span><c:out value="${msg}"/></span>
        </c:forEach>
      </div>
      <div>
        <label for="lastName">名</label>
        <input type="text"
               id="lastName"
               name="lastName"
               class="form-control"
               placeholder="太郎"
               value="${param.lastName}">
        <c:forEach var="msg" items="${requestScope.errors['lastName']}">
          <span><c:out value="${msg}"/></span>
        </c:forEach>
      </div>
      <div>
        <input type="submit" value="登録">
      </div>
    </form>
  </body>
</html>
