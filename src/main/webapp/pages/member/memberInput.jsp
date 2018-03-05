<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <div class="form-group">
        <label for="deptId">部署</label>
        <select name="deptId" >
          <c:forEach var="dept" items="${allDept}">
            <option value=${dept.deptId}><c:out value="${dept.deptId} : ${dept.deptName}" /></option>
          </c:forEach>
        </select>
      </div>
      <div>
        <input type="submit" value="登録">
      </div>
    </form>
  </body>
</html>
