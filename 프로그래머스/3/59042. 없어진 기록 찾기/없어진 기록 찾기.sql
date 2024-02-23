-- 코드를 입력하세요
-- SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부
-- ANIMAL_OUTS 테이블은 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부
-- ANIMAL_OUTS 테이블의 ANIMAL_ID는 ANIMAL_INS의 ANIMAL_ID의 외래 키입니다.

-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
SELECT outs.ANIMAL_ID, outs.NAME
from ANIMAL_INS ins right outer join ANIMAL_OUTS outs on ins.animal_id = outs.animal_id
where 1=1
    and ins.animal_id is null