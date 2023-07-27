-- 코드를 입력하세요 각 동물의 아이디, 이름, 들어온 날짜 결과는 아이디 순으로 
SELECT animal_id, name, date_Format(datetime,"%Y-%m-%d") as "날짜"
from animal_ins 
order by animal_id asc