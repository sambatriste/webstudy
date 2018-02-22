SELECT
  m.member_id,
  m.family_name,
  m.last_name,
  d.dept_id,
  d.dept_name
FROM member m
INNER JOIN DEPT d ON m.dept_id = d.dept_id
WHERE  member_id = /* id */0
;