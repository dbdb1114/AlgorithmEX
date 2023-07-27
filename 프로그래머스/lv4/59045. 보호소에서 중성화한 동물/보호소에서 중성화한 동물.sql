-- 코드를 입력하세요 
-- 들어올 때는 중성화 하지 않았지만, 
-- 나갈 당시에는 중성화된 동물의 아이디,생물종,이름을 조회함
-- ANIMAL_ID, ANIMAL_TYPE, NAME
-- 아이디순으로 

-- Right Outer join
SELECT outs.ANIMAL_ID, outs.Animal_Type, outs.name
from animal_ins ins left join animal_outs outs

on ins.SEX_UPON_intake != outs.SEX_UPON_OUTCOME

where ins.animal_id = outs.animal_id

order by outs.animal_id asc

# where ins.sex_upon_intake != outs.SEX_UPON_OUTCOME


