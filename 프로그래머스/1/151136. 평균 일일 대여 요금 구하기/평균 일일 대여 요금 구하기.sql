-- 코드를 입력하세요
-- CAR_RENTAL_COMPANY_CAR 테이블에서

-- 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금
-- 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림
-- 컬럼명은 AVERAGE_FEE 로 지정해주세요.

SELECT ROUND(avg(DAILY_FEE),0) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where car_type = 'SUV'
GROUP BY car_type
