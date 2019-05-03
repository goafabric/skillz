drop table if exists person;

create table person
(
	id varchar(36) not null
		constraint pk_person
			primary key,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	birthday timestamp,
	address_id varchar(255) NOT NULL,
	version bigint default 0
);

create table address
(
	id varchar(36) not null
		constraint pk_address
			primary key,
	street varchar(255) NOT NULL,
	city varchar(255) NOT NULL,
	version bigint default 0
);
