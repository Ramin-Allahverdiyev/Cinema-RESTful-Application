insert
into
    category
(cat_status,name,created_at,updated_at)
values
    (1,'Comedy',CURRENT_DATE,CURRENT_DATE);
insert
into
    category
(cat_status,name,created_at,updated_at)
values
    (1,'Horror',CURRENT_DATE,CURRENT_DATE);

insert
into
    movie
(category_id,movie_status,title,created_at,updated_at)
values
    (1,1,'MrBean',CURRENT_DATE,CURRENT_DATE);

insert
into
    movie
(category_id,movie_status,title,created_at,updated_at)
values
    (2,1,'Devil',CURRENT_DATE,CURRENT_DATE);

insert
into
    session
(movie_id,session_status,show_time,created_at,updated_at)
values
    (1,1,'2023-06-21 15:00:00.000000',CURRENT_DATE,CURRENT_DATE);

insert
into
    session
(movie_id,session_status,show_time,created_at,updated_at)
values
    (2,1,'2023-07-23 19:30:00.000000',CURRENT_DATE,CURRENT_DATE);

insert
into
    hall
(hall_status,name,created_at,updated_at)
values
    (1,'BakuHall',CURRENT_DATE,CURRENT_DATE);

insert
into
    hall_session
(hall_id,session_id)
values
    (1,1);

insert
into
    hall
(hall_status,name,created_at,updated_at)
values
    (1,'SumHall',CURRENT_DATE,CURRENT_DATE);

insert
into
    hall_session
(hall_id,session_id)
values
    (2,2);


insert
into
    seat_type
(name,stype_status,created_at,updated_at)
values
    ('VIP',1,CURRENT_DATE,CURRENT_DATE);

insert
into
    seat_type
(name,stype_status,created_at,updated_at)
values
    ('STANDARD',1,CURRENT_DATE,CURRENT_DATE);

insert
into
    seat
(hall_id,price,seat_status,seat_type_id,created_at,updated_at)
values
    (1,11.5,1,1,CURRENT_DATE,CURRENT_DATE);

insert
into
    seat
(hall_id,price,seat_status,seat_type_id,created_at,updated_at)
values
    (2,13.99,1,2,CURRENT_DATE,CURRENT_DATE);

insert
into
    role
(name,role_status,created_at,updated_at)
values
    ('USER',1,CURRENT_DATE,CURRENT_DATE);

insert
into
    role
(name,role_status,created_at,updated_at)
values
    ('ADMIN',1,CURRENT_DATE,CURRENT_DATE);

insert
into
    users
(father_name,name,password,status,surname,username,created_at,updated_at)
values
    ('Murad','Samir','$2a$10$N67WGQtKzr8OjWSMp8mu6OzA6XkDG/wdEjUqaoaCkFMoM/Gb/YxWS',true,'Mirzeyev','MirSamir',CURRENT_DATE,CURRENT_DATE);

insert
into
    user_and_role
(user_id,role_id)
values
    (1,1);

insert
into
    users
(father_name,name,password,status,surname,username,created_at,updated_at)
values
    ('Akif','Ramin','$2a$10$N67WGQtKzr8OjWSMp8mu6OzA6XkDG/wdEjUqaoaCkFMoM/Gb/YxWS',true,'Rahmanov','Ramin777',CURRENT_DATE,CURRENT_DATE);

insert
into
    user_and_role
(user_id,role_id)
values
    (2,2);

insert
into
    ticket
(hall_id,seat_id,session_id,ticket_status,user_id,created_at,updated_at)
values
    (1,1,1,1,1,CURRENT_DATE,CURRENT_DATE);

insert
into
    ticket
(hall_id,seat_id,session_id,ticket_status,user_id,created_at,updated_at)
values
    (2,2,2,1,2,CURRENT_DATE,CURRENT_DATE);




