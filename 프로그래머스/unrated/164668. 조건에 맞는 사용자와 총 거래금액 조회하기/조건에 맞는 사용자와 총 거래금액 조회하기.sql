-- 코드를 입력하세요
-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액
-- > 거래상태가 '완료', 거래금액이 70만원 이상, 
SELECT us.USER_ID, us.NICKNAME, sum(ubo.price) as TOTAL_SALES
from Used_goods_user us join Used_goods_board ubo
on us.USER_ID = ubo.WRITER_ID
where ubo.STATUS = 'DONE' 
group by us.user_ID
having sum(ubo.price) >= 700000
order by total_sales asc
# as TOTAL_SALES