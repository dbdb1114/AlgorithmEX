-- 코드를 입력하세요
-- 2022년 1월의 도서 판매 데이터를 기준으로 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가)
-- 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES)
-- 결과는 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리




# from BOOK bo, AUTHOR au, BOOK_SALES bs

# select * from book_sales

select au.AUTHOR_ID, au.AUTHOR_NAME, tot.CATEGORY, SUM(total_sales) as total_sales
from 
(select bo.category, bo.author_id, bs.sales * bo.price as total_sales
from book_sales bs join book bo on bs.BOOK_ID = bo.BOOK_ID 
where bs.sales_date like '2022-01%'
) as tot join AUTHOR au on tot.author_id = au.author_id
group by  au.AUTHOR_ID, tot.CATEGORY
order by au.author_id asc, tot.category desc