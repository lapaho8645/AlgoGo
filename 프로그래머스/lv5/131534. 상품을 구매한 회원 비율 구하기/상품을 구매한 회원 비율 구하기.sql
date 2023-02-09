-- 코드를 입력하세요
SELECT year(sales_date) as year, 
        month(sales_date) as month, 
        count(distinct o.user_id) as puchased_users, 
        format(count(distinct o.user_id)/total_cnt, 1) as PUCHASED_RATIO
from user_info u join online_sale o 
        on u.user_id = o.user_id , 
        (SELECT count(*) as total_cnt
            from user_info u 
            where year(joined) = '2021') as a
where year(joined) = '2021'
group by year(sales_date), month(sales_date)
order by year, month