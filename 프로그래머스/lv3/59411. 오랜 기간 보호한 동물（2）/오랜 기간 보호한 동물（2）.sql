-- 코드를 입력하세요
-- 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름 
SELECT  ins.animal_id, ins.name
from ANIMAL_INS ins , ANIMAL_OUTS outs
where ins.animal_id = outs.animal_id
order by  DATEDIFF( outs.datetime ,ins.datetime) desc
limit 2
