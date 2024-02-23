-- 코드를 입력하세요
-- REST_INFO 

-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문
SELECT
    FOOD_TYPE,
    REST_ID,
    REST_NAME,
    FAVORITES
FROM
    REST_INFO ri1
WHERE
    FAVORITES = (
        SELECT MAX(FAVORITES)
        FROM REST_INFO ri2
        WHERE ri1.FOOD_TYPE = ri2.FOOD_TYPE
    )
ORDER BY
    FOOD_TYPE DESC;