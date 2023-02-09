-- 코드를 입력하세요
SELECT (price div 10000) * 10000 as price_group, count(*) as products
from product
group by price div 10000
order by price_group

# select *
# from product
# order by price