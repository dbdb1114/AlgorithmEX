-- 코드를 입력하세요
-- 입양을 못 간 동물 중 가장 오래 보호소에 있었던 동물 3 마리 ( order by 하고 limit 하고)
-- 위 사항에 해당하는 동물 이름과 보호 시작일
SELECT ins.name, ins.datetime 
from animal_ins ins left join animal_outs outs
on ins.animal_id = outs.animal_id
where outs.animal_id is null 
order by datetime asc
limit 3