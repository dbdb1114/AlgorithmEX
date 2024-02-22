-- 코드를 입력하세요

-- ****** 같은 날짜에는 회원ID, 상품ID에 대해서 하나의 판매 데이터만 존재함. **** 

-- 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여
-- 재구매한 회원ID와 상품ID를 출력하는 SQL문을 작성해주세요.

SELECT distinct a1.USER_ID, a1.PRODUCT_ID
FROM ONLINE_SALE a1, ONLINE_SALE a2 
WHERE a1.USER_ID = a2.USER_ID 
AND a1.PRODUCT_ID = a2.PRODUCT_ID
AND a1.SALES_DATE != a2.SALES_DATE
ORDER BY a1.USER_ID asc, a1.product_id desc 