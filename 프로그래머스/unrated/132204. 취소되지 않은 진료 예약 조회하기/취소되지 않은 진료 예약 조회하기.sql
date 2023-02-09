-- 코드를 입력하세요
select pa.apnt_no, pt_name, pt_no, mcdp_cd, dr_name, apnt_ymd
from
(SELECT p.pt_name, p.pt_no, a.apnt_no
from patient p join appointment a
on p.pt_no = a.pt_no) as pa
join
(SELECT d.MCDP_CD, d.dr_name, a.APNT_YMD, a.APNT_CNCL_YN, a.apnt_no
from DOCTOR d join appointment a
on d.DR_ID = a.MDDR_ID) as da
on pa.apnt_no = da.apnt_no
where date_format(apnt_ymd, "%Y-%m-%d") = "2022-04-13" and APNT_CNCL_YN = "N" 
    and mcdp_cd = "CS"
order by apnt_ymd