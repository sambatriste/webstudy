<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>メンバー一覧</title>
  </head>
  <body>
    <h1>メンバー一覧</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>性</th>
          <th>名</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="row" items="${memberList}">
          <tr>
            <td>${row.memberId}</td>
            <td>${row.familyName}</td>
            <td>${row.lastName}</td>
            <td>
              <a href="search?memberId=${row.memberId}">参照</a>
              <a href="inputForUpdate?memberId=${row.memberId}">更新</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
