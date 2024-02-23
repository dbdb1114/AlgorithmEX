-- 코드를 입력하세요
-- CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- HISTORY_ID, CAR_ID, START_DATE, END_DATE 는 각각 
-- 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일

-- 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서 
-- 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 
-- 표시하는 컬럼(컬럼명: RENT_TYPE)을 추가하여 대여기록을 출력하는 SQL문을 작성해주세요. 
-- 결과는 대여 기록 ID를 기준으로 내림차순 정렬해주세요.

SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE,"%Y-%m-%d") as START_DATE, 
DATE_FORMAT(END_DATE, "%Y-%m-%d") as END_DATE,
CASE WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30
THEN '장기 대여' ELSE '단기 대여' END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE,"%Y-%m-%d") BETWEEN "2022-09-01" AND "2022-09-31"
ORDER BY HISTORY_ID desc

