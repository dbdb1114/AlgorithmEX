-- 코드를 입력하세요
-- 온라인 테이블과 오프라인 테이블에서 
-- 2022년 3월의 오프라인/온라인 상품 판매 데이터의 
-- 판매 날짜, 상품ID, 유저ID, 판매량을 출력하는 SQL문을 작성하시오.

-- 판매일을 기준으로 오름차순 정렬, 
-- 상품 ID를 기준으로 오름차순 정렬,
-- 유저 ID를 기준으로 오름차순 정렬 

select SUBSTR(SALES_DATE,1,10) as SALES_DATE, PRODUCT_ID, USER_ID,  SALES_AMOUNT
from
(SELECT ONLINE_SALE_ID as sale_ID, USER_ID, PRODUCT_ID,	SALES_AMOUNT, SALES_DATE FROM ONLINE_SALE
UNION ALL 
SELECT OFFLINE_SALE_ID as sale_ID, NULL as USER_ID, PRODUCT_ID,	SALES_AMOUNT, SALES_DATE FROM OFFLINE_SALE) as tbl
WHERE SUBSTR(SALES_DATE,6,2) = '03'
GROUP BY SALES_DATE, PRODUCT_ID, USER_ID
ORDER BY SALES_DATE asc, PRODUCT_ID asc , USER_ID asc