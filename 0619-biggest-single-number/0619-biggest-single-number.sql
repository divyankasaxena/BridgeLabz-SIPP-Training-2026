# Write your MySQL query statement below


select MAX(num) AS num
from(
    select num 
    from MyNumbers
    Group by num
    HAVING COUNT(num) = 1
) AS unique_numbers ;