-- 코드를 입력하세요
# SELECT CAR_ID, 
#     if("2022-10-16" between max(start_date) and max(end_date), "대여중", "대여가능") as availability
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where start_date <= "2022-10-16"
# group by car_id
# order by car_id desc;
SELECT distinct c.car_id,
    case
        when "2022-10-16" between sd and ed then "대여중"
        else "대여 가능"
    end as availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY c
left join(SELECT CAR_ID, 
        max(start_date) as sd, max(end_date) as ed
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date <= "2022-10-16"
    group by car_id
    order by car_id desc) as sub1
on c.car_id = sub1.car_id
order by c.car_id desc

# select *  
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# order by car_id desc, start_date desc