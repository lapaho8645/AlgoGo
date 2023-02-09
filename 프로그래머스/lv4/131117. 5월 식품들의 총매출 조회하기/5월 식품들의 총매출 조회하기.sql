-- 코드를 입력하세요
SELECT p.PRODUCT_ID, p.PRODUCT_NAME, sum(p.price * o.amount) as TOTAL_SALES
from FOOD_PRODUCT p join FOOD_ORDER o
on p.product_id = o.product_id
where year(o.produce_date) = "2022" and month(o.produce_date) = "05"
group by o.product_id
order by total_sales desc, p.product_id

# SELECT *
# from FOOD_PRODUCT p join FOOD_ORDER o
# on p.product_id = o.product_id