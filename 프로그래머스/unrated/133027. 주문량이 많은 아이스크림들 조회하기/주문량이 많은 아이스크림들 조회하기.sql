-- 코드를 입력하세요
# select flavor
# from (SELECT (f.total_order + j.total_order) as total_order, f.flavor as flavor
#     from first_half f right outer join july j 
#     on f.shipment_id = j.shipment_id) as a
# order by total_order desc
select flavor
from 
    (SELECT *
    from first_half
        union 
    SELECT *
    from july) sub1
group by flavor
order by sum(total_order) desc limit 0,3