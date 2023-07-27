-- 코드를 입력하세요 PRODUCT OFFLINE_SALE
-- PRODUCT_ID, PRODUCT_CODE, PRICE는 각각 상품 ID, 상품코드, 판매가
-- OFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE는 각각 오프라인 상품 판매 ID, 상품 ID, 판매량, 판매일

SELECT pro.product_code, pro.price * sum(off.sales_amount) as sales 
from product pro, offline_sale off 
where pro.PRODUCT_ID = off.PRODUCT_ID
group by off.PRODUCT_ID
order by sales desc ,product_code asc


# select * from OFFLINE_SALE off , product pro 
# where pro.product_code = 'C3000002' and pro.product_id = off.product_id
