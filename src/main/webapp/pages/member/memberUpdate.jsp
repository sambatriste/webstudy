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
        <t:error target="familyName"/>
      </div>
      <div class="form-group">
        <label for="lastName">名</label>
        <input type="text"
               id="lastName"
               name="lastName"
               class="form-control"
               placeholder="太郎"
               value="${member.lastName}">
        <t:error target="lastName"/>
      </div>

      <div class="form-group">
        <input type="submit" value="更新">
      </div>
    </form>
  </body>
</html>
