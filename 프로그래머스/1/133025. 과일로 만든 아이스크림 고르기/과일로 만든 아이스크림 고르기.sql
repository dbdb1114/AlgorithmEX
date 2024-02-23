-- 코드를 입력하세요
-- 상반기 아이스크림 총주문량이 3,000보다 높으면서
-- 아이스크림의 주 성분이 과일인 아이스크림의 맛을
-- 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.
SELECT FH.FLAVOR
FROM FIRST_HALF FH JOIN ICECREAM_INFO ICE ON FH.FLAVOR = ICE.FLAVOR
WHERE INGREDIENT_TYPE = 'fruit_based' 
AND total_order > 3000
order by total_order desc


