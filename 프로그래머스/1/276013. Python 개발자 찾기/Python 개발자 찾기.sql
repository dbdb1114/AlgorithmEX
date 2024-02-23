-- 코드를 작성해주세요
-- Python 스킬을 가진 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요.


select ID, EMAIL, FIRST_NAME,LAST_NAME
from DEVELOPER_INFOS
where SKILL_1 = 'Python' or SKILL_2 = 'Python' or SKILL_3 = 'Python'
order by id asc