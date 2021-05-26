create table space_ship_t (  
space_ship_id bigint not null auto_increment,  
space_ship_code varchar(15) not null,  
primary key(space_ship_id) 
);
create table seat_code_t ( 
seat_code_id bigint not null auto_increment, 
seat_code varchar(15) not null, 
space_ship_id bigint not null, 
primary key(seat_code_id), 
foreign key(space_ship_id) 
references space_ship_t(space_ship_id) 
);
create table airport_t ( 
airport_id bigint not null auto_increment, 
airport_code varchar(10) not null, 
airport_name varchar(50) not null, 
planet_id bigint not null, 
primary key (airport_id), 
foreign key (planet_id) references planet_t (planet_id) 
);
create table border_pass_t (
seat_code_id bigint not null,
tourist_id bigint not null,
flight_id bigint not null,
primary key(seat_code_id, tourist_id, flight_id),
foreign key (seat_code_id) references seat_code_t (seat_code_id),
foreign key (tourist_id) references tourist_t (tourist_id),
foreign key (flight_id) references flight_t (flight_id)
);
