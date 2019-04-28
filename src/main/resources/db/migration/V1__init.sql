drop table if exists person;

create table person
(
	id varchar(36) not null
		constraint pk_country
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	version bigint default 0
);
