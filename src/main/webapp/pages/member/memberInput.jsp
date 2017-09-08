<t:template pageTitle="メンバー登録">
  <form action="register" method="post">
    <div class="form-group">
      <label class="control-label" for="familyName">姓</label>
      <input type="text"
             id="familyName"
             name="familyName"
             class="form-control"
             placeholder="山田"
             value="${param.familyName}">
      <t:error target="familyName"/>
    </div>
    <div class="form-group">
      <label class="control-label" for="lastName">名</label>
      <input type="text"
             id="lastName"
             name="lastName"
             class="form-control"
             placeholder="太郎"
             value="${param.lastName}">
      <t:error target="lastName"/>
    </div>

    <div class="form-group">
      <input type="submit" value="登録" class="btn btn-primary">
    </div>
  </form>
</t:template>