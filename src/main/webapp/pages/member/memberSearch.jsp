<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>メンバー</title>
  </head>
  <body>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>姓</th>
          <th>名</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${member.memberId}</td>
          <td>${member.familyName}</td>
          <td>${member.lastName}</td>
        </tr>
      </tbody>
    </table>
  </body>
</html>
