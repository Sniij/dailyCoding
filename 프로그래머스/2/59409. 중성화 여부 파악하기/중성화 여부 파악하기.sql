SELECT animal_id
, name
, CASE WHEN REGEXP_LIKE(sex_upon_intake, 'Neutered|Spayed') THEN 'O'
ELSE 'X' END AS 중성화
FROM animal_ins
ORDER BY ANIMAL_ID;