-- 코드를 입력하세요
-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고]
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
SELECT b.category,  sum(bs.sales) as total_sales

from Book b join book_sales bs
on date_format(bs.sales_date,"%Y-%m") = "2022-01"
where b.book_id = bs.book_id
group by b.category
order by b.category asc
