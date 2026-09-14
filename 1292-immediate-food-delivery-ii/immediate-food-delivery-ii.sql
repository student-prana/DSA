# Write your MySQL query statement below
select round(avg(order_date=customer_pref_delivery_date)*100,2) as immediate_percentage
from Delivery
where(customer_id,order_date) in( select Customer_id,MIN(order_date)
from delivery
group by customer_id
)