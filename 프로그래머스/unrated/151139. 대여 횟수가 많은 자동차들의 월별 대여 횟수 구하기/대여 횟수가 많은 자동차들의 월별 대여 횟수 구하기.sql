-- 코드를 입력하세요
SELECT month(start_date), CAR_ID, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between "2022-08-01" and "2022-10-31"
and car_id in (SELECT CAR_ID
            from CAR_RENTAL_COMPANY_RENTAL_HISTORY
            where start_date between "2022-08-01" and "2022-10-31"
            group by car_id
            having count(*) >= 5)
group by car_id, month(start_date)
having count(*) > 0
order by month(start_date), car_id desc
