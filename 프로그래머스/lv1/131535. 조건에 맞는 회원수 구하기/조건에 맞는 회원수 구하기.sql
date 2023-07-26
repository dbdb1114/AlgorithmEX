-- 코드를 입력하세요
SELECT Count(USER_ID) as USERS 
from user_info
where Joined Between date("2021-01-01") and date("2021-12-31") and age >= 20 and age <= 29