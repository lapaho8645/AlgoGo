-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
from online_sale
group by 1,2
having count(*) > 1
order by 1, 2 desc