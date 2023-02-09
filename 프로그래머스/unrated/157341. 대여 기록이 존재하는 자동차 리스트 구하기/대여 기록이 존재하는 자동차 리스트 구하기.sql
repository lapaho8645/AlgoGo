-- 코드를 입력하세요
SELECT distinct car_id
from CAR_RENTAL_COMPANY_CAR crcc
join CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
using(car_id)
where CAR_TYPE = "세단" and month(start_date) = "10"
order by car_id desc