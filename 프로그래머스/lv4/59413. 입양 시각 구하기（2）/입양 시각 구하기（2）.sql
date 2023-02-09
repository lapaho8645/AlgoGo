-- 코드를 입력하세요
with recursive rc as (
    select 0 as h -- 재귀 초깃값
      union all
      select h + 1 -- 재귀
      from rc 
      where h < 23 -- 재귀 정지 조건
)
select h, ifnull(count, 0) as count from rc
left join (SELECT hour(datetime) as hour, count(*) as count
    from animal_outs
    group by hour(datetime)
    order by hour(datetime)) as b
on rc.h = b.hour

# SELECT hour(datetime) as hour, count(*) as count
#     from animal_outs
#     group by hour(datetime)
#     order by hour(datetime)