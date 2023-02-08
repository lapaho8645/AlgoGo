-- 코드를 입력하세요
SELECT MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from member_profile m join rest_review r
on m.member_id = r.member_id
where m.member_id = (select member_id
                    from rest_review 
                    group by member_id
                    order by count(*) desc limit 1)
order by REVIEW_DATE, REVIEW_TEXT