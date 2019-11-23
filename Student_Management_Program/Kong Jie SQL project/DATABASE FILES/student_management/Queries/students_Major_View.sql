create view students_Major_view as 
select students_info.Fname, majors_info.Major_name
from students_info , majors_info
where students_info.MID = majors_info.MID