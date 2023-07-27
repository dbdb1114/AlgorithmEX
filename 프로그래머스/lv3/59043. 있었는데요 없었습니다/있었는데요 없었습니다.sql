-- 코드를 입력하세요
-- 보호 시작일보다 입양일이 더 빠른 동물
-- 아이디와 이름을 조회하는 SQL문을 작성해주세요.
SELECT ins.animal_id, ins.name
from animal_ins ins join ANIMAL_OUTS outs
on ins.animal_id = outs.animal_id
where ins.datetime > outs.datetime
order by ins.datetime asc 