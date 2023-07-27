-- 코드를 입력하세요
SELECT animal_id, name, 

if (SEX_UPON_INTAKE like "%Neutered%" OR SEX_UPON_INTAKE like "%Spayed%" , "O","X") as "중성화"

from animal_ins

order by animal_id asc