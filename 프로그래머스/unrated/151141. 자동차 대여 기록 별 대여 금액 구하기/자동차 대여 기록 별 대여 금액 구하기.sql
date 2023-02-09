-- 코드를 입력하세요


select HISTORY_ID, (daily_fee * term * (100 - ifnull(discount_rate, 0)) div 100) as FEE
from (SELECT 
      case 
        when datediff(b.end_date, b.start_date)+1 >= 90 then "90일 이상"
        when datediff(b.end_date, b.start_date)+1 >= 30 then "30일 이상"
        when datediff(b.end_date, b.start_date)+1 >= 7 then "7일 이상"
      end
        as duration_type, car_type, DAILY_FEE, b.car_id, b.history_id, datediff(b.end_date, b.start_date)+1 as term
    from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
    on a.car_id = b.car_id
    where car_type = "트럭") sub1
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on sub1.car_type = p.car_type and p.duration_type = sub1.duration_type
order by fee desc, history_id desc
