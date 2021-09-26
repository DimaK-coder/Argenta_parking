create table parking_space
(
    id       bigserial primary key,
    position varchar(10) not null,
    status   varchar(20) not null
);

insert into parking_space (position, status)
values ('A 1', 'FREE'),
       ('A 2', 'FREE'),
       ('A 3', 'FREE'),
       ('A 4', 'FREE'),
       ('A 5', 'FREE'),
       ('B 1', 'FREE'),
       ('B 2', 'FREE'),
       ('B 3', 'FREE'),
       ('B 4', 'FREE'),
       ('B 5', 'FREE');

create table gate
(
    id   bigserial primary key,
    name varchar(50) not null,
    type varchar(20) not null
);

insert into gate (name, type)
values ('Entrance gate ', 'TO_ENTER'),
       ('Exit', 'ON_DEPARTURE');

create table gate_parking_space
(
    gate_id          bigint    not null
        constraint gate_parking_space_gate_fkey
            references gate,
    parking_space_id bigint    not null
        constraint gate_parking_space_parking_space_fkey
            references parking_space,
    id               bigserial not null
        constraint gate_parking_space_pkey
            primary key
);

create table parking_ticket
(
    id               bigserial primary key,
    parking_space_id bigint
        constraint parking_ticket_parking_space_id_fkey
            references parking_space,
    type varchar(50) not null,
    parking_entrance_time timestamp,
    deleted boolean
);



