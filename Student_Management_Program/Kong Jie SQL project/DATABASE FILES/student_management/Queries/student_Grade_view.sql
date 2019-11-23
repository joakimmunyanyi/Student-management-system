create view student_Grade_view as 
select students_info.Fname, majors_info.Major_name,course_info.Course_name,grade_info.Scores
from students_info , majors_info,course_info,grade_info
where students_info.MID = majors_info.MID and
			course_info.MID = majors_info.MID and
			grade_info.CID = course_info.CID and
			/*change SID number to corresponding student */
			students_info.SID = '101'