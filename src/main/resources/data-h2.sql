insert into products(id, code, image, price, size, status, variety) values(1,"MWBLU20","blueberry.png",2.0,20,"DISCONTINUED"",Blueberry");
insert into products(id, code, image, price, size, status, variety) values(2,"MWBLU32","blueberry.png",4.0,32,"DISCONTINUED","Blueberry");
insert into products(id, code, image, price, size, status, variety) values(3,"MWCRA20","cranberry.png",2.0,20,"ACTIVE","Cranberry");
insert into products(id, code, image, price, size, status, variety) values(4,"MWCRA32","cranberry.png",4.0,32;"ACTIVE","Cranberry");

insert into customers(id, address, city, email, first_name, last_name, phone, state, zip_code) values(1,"8157 Longview Court","Seattle","cshaw0@mlb.com","Carol","Shaw","206-804-8771","WA","98121"); 
insert into customers(id, address, city, email, first_name, last_name, phone, state, zip_code) values(2,"3934 Petterle Trail","Austin","ecarr1@oracle.com","Elizabeth","Carr","512-187-2507","TX","78732");
insert into customers(id, address, city, email, first_name, last_name, phone, state, zip_code) values(3,"8699 Clarendon Terrace","Kansas City","eramos2@plala.or.jp","Ernest","Ramos","512-187-2507","MO","64199");
insert into customers(id, address, city, email, first_name, last_name, phone, state, zip_code) values(4,"2830 Novick Lane","Irving","jcarter3@harvard.edu","Jane","Carter","214-839-0542","TX","75037");

insert into employees(id, address, city, email, first_name, last_name, state, zip_code) values(
    (1,"5 Jenifer Crossing","Lynchburg","jpowell0@hplussport.com","Jack","Powell","VA","24515"), 
    (2,"97 Vidon Alley","Manchester","egarcia1@hplussport.com","Emily","Garcia","NH","31050"),
    (3,"2482 1st Road","Houston","rdean2@hplussport.com","Richard","Dean","TX","77228"),
    (4,"5230 Rigney Circle","Alexandria","jporter3@hplussport.com","Jane", "Porter","VA","22301"));

insert into order_details(id, creation_date, quantity, total, product_id) values(
    (1,"2022-10-09",10,20.0,5),
    (2,"2022-10-12",2,8.0,2),
    (3,"2022-10-13",4,8.0,13),
    (4,"2022-10-13",4,8.0,13)
);

insert into orders(id, customer_id, employee_id, order_details_id) values(
    (1,5,4,1),
    (2,5,6,2),
    (3,6,13,4),
    (4,6,3,5)
);
