# Write your MySQL query statement below
select name as customers from customers left join orders ON customers.id=orders.customerId where orders.customerId IS NULL;