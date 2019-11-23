select majors_info.Major_name,course_info.Course_name
from majors_info,course_info
where course_info.MID=majors_info.MID