-- 코드를 작성해주세요

-- ITEM_INFO, ITEM_TREE

-- ITEM_ID	ITEM_NAME	RARITY	PRICE
-- ITEM_ID	PARENT_ITEM_ID

-- 아이템의 희귀도가 'RARE'인 아이템들
-- 모든 다음 업그레이드 아이템의 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME), 아이템의 희귀도(RARITY)

-- 레어인 아이템의 모든 다음 업그레이드 아이템
-- 부모 아이템이 레어인 모든 아이템 => 부모의 아이템이 레어인 모든 아이템의 item_id
-- 그게 부모 아이템인 아이템 아이디들의 정보
-- info 테이블에서 레어인 아이템을 고르고 

select item_id, item_name, rarity
from item_info
where item_id in 
(select item_id from item_tree
where PARENT_ITEM_ID in 
(select item_id from item_info where rarity = 'rare')
)
order by item_id desc