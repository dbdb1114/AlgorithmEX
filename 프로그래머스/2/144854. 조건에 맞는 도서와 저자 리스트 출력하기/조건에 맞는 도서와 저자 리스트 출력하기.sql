-- 코드를 입력하세요
-- '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문


SELECT BOOK_ID, AUTHOR_NAME, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK bo join AUTHOR au on bo.author_id = au.author_id
where category = '경제'
order by PUBLISHED_DATE 

# select * FROM BOOK bo join AUTHOR au on bo.author_id = au.author_id where category = '경제'