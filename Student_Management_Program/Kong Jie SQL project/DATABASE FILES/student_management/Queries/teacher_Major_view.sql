create view teacher_Major_view as 
select teachers_info.Teacher_name,majors_info.Major_name
from teachers_info,majors_info
where teachers_info.MID = majors_info.MID