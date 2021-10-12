use dvdrental;

select title, description from film;

select * from where length > 60 and length <75;

select * from where rental_rate = 0.99 and (replacement_cost = 12.99 || replacement_cost = 28.99);

select last_name from customer where first_name = "Mary" limit 1;

select * from film where length < 50 and rental_rate not in (2.99, 4.99);