# Write your MySQL query statement below



SELECT
    visited_on,
    SUM(amount) AS amount,
    ROUND(SUM(amount) / 7, 2) AS average_amount
FROM (
    SELECT
        c1.visited_on,
        c2.amount
    FROM (
        SELECT visited_on, SUM(amount) AS amount
        FROM Customer
        GROUP BY visited_on
    ) c1
    JOIN (
        SELECT visited_on, SUM(amount) AS amount
        FROM Customer
        GROUP BY visited_on
    ) c2
    ON c2.visited_on BETWEEN DATE_SUB(c1.visited_on, INTERVAL 6 DAY)
                         AND c1.visited_on
) AS daily
GROUP BY visited_on
HAVING COUNT(*) = 7
ORDER BY visited_on;
