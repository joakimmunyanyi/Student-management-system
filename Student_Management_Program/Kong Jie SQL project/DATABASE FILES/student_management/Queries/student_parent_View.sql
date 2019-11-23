create view student_parent_view as 
select DISTINCT
students_info.Fname,students_info.Lname,relatives_info.relative_name,relatives_info.relation
from students_info,relatives_info
