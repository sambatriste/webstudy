<t:template pageTitle="メンバー更新">
  <form action="update" method="post">
    <input type="hidden"
           name="id"
           value="${member.id}"/>
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
</t:template>