-- 코드를 입력하세요
-- 5월 1일 기준으로 주문ID, 제품ID, 출고일자, 출고여부
-- 출고여부 : 5월 1일을 포함한 이전은 출고완료, 5월 1일 이후는 출고 대기, 미정이라면 출고미정 
-- 결과는 주문 ID를 기준으로 오름차순
SELECT ORDER_ID, PRODUCT_ID, date_format(OUT_DATE, "%Y-%m-%d") as OUT_DATE, 
    CASE 
    WHEN DATE_FORMAT(OUT_DATE,"%m-%d") <= "05-01" THEN "출고완료"
    WHEN DATE_FORMAT(OUT_DATE,"%m-%d") > "05-01" THEN "출고대기"
    Else "출고미정"
    END AS "출고여부"
From FOOD_ORDER
ORDER BY Order_id asc