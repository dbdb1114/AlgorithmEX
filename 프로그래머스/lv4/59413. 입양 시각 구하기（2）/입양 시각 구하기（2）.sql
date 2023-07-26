SET @hour := -1;
select (@hour := @hour + 1) AS hour,
(select count(*) from animal_outs where hour(datetime) = @hour) as Count
from animal_outs
where @hour <23