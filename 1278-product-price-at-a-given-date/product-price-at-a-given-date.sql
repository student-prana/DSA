# Write your MySQL query statement below
SELECT product_id, new_price AS price
FROM Products
WHERE change_date = (
    SELECT MAX(change_date)
    FROM Products p2
    WHERE p2.product_id = Products.product_id
      AND change_date <= '2019-08-16'
)
union

SELECT product_id, 10 AS price
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16';