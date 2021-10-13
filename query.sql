USE labor_sql;

-- Знайти виробників принтерів--
SELECT maker, type FROM Product
ORDER BY maker desc;

-- З таблиці Trip вивести інформацію про рейси, що вилітають в інтервалі часу між 12 та 17 годинами включно.
SELECT time_out FROM Trip
WHERE time_out between '1900-01-01 12:00:00' and '1900-01-01 17:00:00';

-- Виведіть виробника, тип, модель та частоту процесора для ноутбуків, частота процесорів яких перевищує 600 МГц.--
SELECT maker, type, laptop.model, speed FROM laptop, product
HAVING (speed) > 600;

-- Знайдіть виробників, що випускають одночасно ПК та ноутбуки (використати ключове слово ANY).
SELECT maker FROM product
WHERE maker = ANY (SELECT maker FROM pc, laptop);

-- За Вашингтонським міжнародним договором від початку 1922 р. заборонялося будувати лінійні кораблі водотоннажністю понад 35 тис. тонн. Вкажіть кораблі, що порушили цей договір (враховувати лише кораблі з відомим роком спущення на воду, тобто з таблиці Ships).
SELECT name, launched, displacement FROM Ships, Classes
WHERE launched IS NOT NULL AND displacement > 35000;

-- Для таблиці PC вивести всю інформацію з коментарями в кожній комірці
SELECT CONCAT('Code: ', code) AS code,
	   CONCAT('Model: ', model) AS model,
       CONCAT('Speed: ', speed) AS speed,
       CONCAT('Ram: ', ram) AS ram,
       CONCAT('Hd: ', hd) AS hd,
       CONCAT('Cd: ', cd) AS cd,
       CONCAT('Price: ', price) AS price
FROM pc;

-- Визначіть кількість рейсів до міста 'Moscow' для кожної дати таблиці Pass_in_trip.
SELECT date, count(date) FROM pass_in_trip JOIN trip ON pass_in_trip.trip_no = trip.trip_no
WHERE town_to = 'Moscow'
GROUP BY date;


SELECT maker, CASE when count(p.model) > 0 then concat('yes(', count(p.model), ')') else 'no' end as printer FROM product LEFT JOIN printer p on product.model = p.model
GROUP BY maker;


SELECT classes.class, count(name)
FROM classes
RIGHT JOIN (SELECT name, class FROM Ships UNION SELECT ship, null FROM outcomes) s on classes.class = s.class
GROUP BY classes.class