create table category (
                          cat_status integer,
                          id integer generated by default as identity,
                          created_at timestamp(6),
                          updated_at timestamp(6),
                          name varchar(255),
                          primary key (id)
);

create table hall (
                      hall_status integer,
                      id integer generated by default as identity,
                      created_at timestamp(6),
                      updated_at timestamp(6),
                      name varchar(255),
                      primary key (id)
);

create table hall_session (
                              hall_id integer not null,
                              session_id integer not null,
                              primary key (hall_id, session_id)
);

create table movie (
                       category_id integer,
                       id integer generated by default as identity,
                       movie_status integer,
                       created_at timestamp(6),
                       updated_at timestamp(6),
                       title varchar(255),
                       primary key (id)
);

create table role (
                      id integer generated by default as identity,
                      created_at timestamp(6),
                      role_status integer,
                      updated_at timestamp(6),
                      name varchar(255),
                      primary key (id)
);

create table seat (
                      hall_id integer,
                      id integer generated by default as identity,
                      price float(53),
                      seat_status integer,
                      seat_type_id integer,
                      created_at timestamp(6),
                      updated_at timestamp(6),
                      primary key (id)
);

create table seat_type (
                           id integer generated by default as identity,
                           stype_status integer,
                           created_at timestamp(6),
                           updated_at timestamp(6),
                           name varchar(255),
                           primary key (id)
);
create table session (
                         id integer generated by default as identity,
                         movie_id integer,
                         session_status integer,
                         created_at timestamp(6),
                         show_time timestamp(6),
                         updated_at timestamp(6),
                         primary key (id)
);

create table ticket (
                        hall_id integer,
                        id integer generated by default as identity,
                        seat_id integer,
                        session_id integer,
                        ticket_status integer,
                        user_id integer,
                        created_at timestamp(6),
                        updated_at timestamp(6),
                        primary key (id)
);

create table user_and_role (
                               role_id integer not null,
                               user_id integer not null,
                               primary key (role_id, user_id)
);

create table users (
                       id integer generated by default as identity,
                       status boolean not null,
                       created_at timestamp(6),
                       updated_at timestamp(6),
                       father_name varchar(255),
                       name varchar(255),
                       password varchar(255),
                       surname varchar(255),
                       username varchar(255) unique,
                       primary key (id)
);
