-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info
where (food_type, favorites) in (SELECT FOOD_TYPE, max(FAVORITES) as maxFavorites
                            from rest_info
                            group by food_type
                            order by food_type desc
                            )
order by food_type desc


