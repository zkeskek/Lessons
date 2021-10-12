use dvdrental;

select * from film where between 12.99 and 16.99;

select * from actor where (first_name, last_name) in (('Penelope','Nick','Ed'),('Penelope','Nick','Ed'));

select * from film where rental_rate in (0.99,2.99,4.99) and replacement_cost in (12.99,15.99,28.99);