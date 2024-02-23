-- 코드를 입력하세요
-- 상반기 주문 정보를 담은 FIRST_HALF
-- SHIPMENT_ID, FLAVOR, TOTAL_ORDER는 
-- 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량 기본 키는 FLAVOR

-- 7월의 아이스크림 주문 정보를 담은 JULY 테이블
-- SHIPMENT_ID, FLAVOR, TOTAL_ORDER
-- 출하 번호, 아이스크림 맛, 7월 아이스크림 총주문량을 나타냅니다.

-- 7월에는 아이스크림 주문량이 많아 같은 아이스크림에 대하여 
-- 서로 다른 두 공장에서 아이스크림 가게로 출하를 진행하는 경우가 있습니다. 
-- 이 경우 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다.

-- 상반기 테이블은 7월 테이블의 FLAVOR를 참조하고,
-- 7월 테이블은 상반기 테이블의 SHIPMENT_ID를 참조한다. 

-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 
-- 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.


-- 7월의 


SELECT flavor
FROM (select * from JULY UNION ALL select * from FIRST_HALF) tbl
group by flavor
order by sum(total_order) desc
limit 3
