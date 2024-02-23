-- 코드를 입력하세요

-- 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성해주세요. 
-- 컬럼명은 '진료과 코드', '5월예약건수'로 지정

-- 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, 
-- 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬

SELECT MCDP_CD as '진료과 코드', COUNT(APNT_NO) as '5월예약건수'
from APPOINTMENT
where date_format(APNT_YMD,'%Y-%m') = '2022-05'
group by MCDP_CD
order by 2 asc,  1 asc

# select * 
# from APPOINTMENT
# where date_format(APNT_YMD,'%Y-%m') = '2022-05'