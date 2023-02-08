-- 코드를 입력하세요
SELECT a.AUTHOR_ID, AUTHOR_NAME, sub1.CATEGORY, sub1.total_sales
from author a join (select author_id, category, sum(price * sales) as total_sales
    from book b join book_sales s
    on b.book_id = s.book_id
    where year(s.sales_date) = "2022" and month(s.sales_date) = '01'
    group by author_id, category) as sub1
on a.author_id = sub1.author_id
order by author_id, category desc


# select b.book_id, author_id, category, price, sales
# from book_sales s join book b
# on s.book_id = b.book_id
# order by author_id, book_id, category