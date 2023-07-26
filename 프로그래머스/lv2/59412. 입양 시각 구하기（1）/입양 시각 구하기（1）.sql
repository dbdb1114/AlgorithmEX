-- 코드를 입력하세요
SELECT HOUR(datetime) AS hour, Count(datetime) as count
from ANIMAL_OUTS
where HOUR(datetime) between "09" and "19"
group by HOUR(datetime)
order by HOUR(datetime)
