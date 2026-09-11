/* Write your PL/SQL query statement below */
select p.project_id,round(avg(experience_years),2) as average_years
from Project p
join Employee e
on p.Employee_id=e.Employee_id
group by project_id;