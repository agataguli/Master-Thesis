create table if not exists users
(
    name varchar not null
        constraint params_pkey
            primary key,
    password varchar not null,
    email varchar not null,
    comment varchar not null
);