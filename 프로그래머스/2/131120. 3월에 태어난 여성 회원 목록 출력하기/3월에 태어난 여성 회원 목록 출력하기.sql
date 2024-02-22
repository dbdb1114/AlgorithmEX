-- 코드를 입력하세요
-- 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일 조회하기 
-- 전화번호 not null
-- 회원 id 기준으로 오름차순 정렬
SELECT MEMBER_ID, MEMBER_NAME, GENDER, SUBSTR(DATE_OF_BIRTH,1,10)
from MEMBER_PROFILE
WHERE 
TLNO IS NOT NULL 
AND SUBSTR(DATE_OF_BIRTH,6,2) = '03'
AND GENDER = 'W'
ORDER BY MEMBER_ID ASC