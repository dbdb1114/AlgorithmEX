-- 코드를 입력하세요

-- 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 
-- 컬럼(컬럼명: AVAILABILITY)을 추가

-- CAR_ID	AVAILABILITY

SELECT
CAR_ID, 
IF(sum(START_DATE <= "2022-10-16" AND END_DATE >= "2022-10-16")>0, '대여중','대여 가능') as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by CAR_ID desc

