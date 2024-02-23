-- 코드를 입력하세요
-- GENDER 컬럼은 비어있거나 0 또는 1의 값을 가지며 0인 경우 남자를, 1인 경우는 여자를 나타냅니다.
-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문


SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, GENDER, count(distinct os.user_id) as USERS
from USER_INFO us join ONLINE_SALE os on us.user_id = os.user_id
WHERE us.GENDER IS NOT NULL 
group by 1,2,3
order by YEAR,MONTH,GENDER

# SELECT * from USER_INFO us join ONLINE_SALE os on us.user_id = os.user_id
# WHERE us.GENDER IS NOT NULL