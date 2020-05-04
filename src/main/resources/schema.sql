DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id         INT          AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name  VARCHAR(250) NOT NULL,
  email      VARCHAR(250) DEFAULT NULL
);

create table book (
  id      INT AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(250),
  empl_id int not null,
  constraint book_empl_fk
  foreign key (empl_id) references employee (id)
);


create table student (
  id   int auto_increment primary key,
  name VARCHAR(250) not null
);

create table room (
  id   int auto_increment primary key,
  name varchar(250)
);

create table student_x_room (
  room_id    int not null,
  student_id int not null,
  constraint student_fk
  foreign key (student_id) references student (id),
  constraint room_fk
  foreign key (room_id) references room (id)
);

insert into student (name)
value ('Name 1');
insert into student (name)
value ('Name 2');
insert into student (name)
value ('Name 3');

insert into room (name)
value ('258');
insert into room (name)
value ('256');

insert into student_x_room (room_id, student_id)
value (1, 1);
insert into student_x_room (room_id, student_id)
value (1, 2);
insert into student_x_room (room_id, student_id)
value (2, 2);


select *
from employee
       left join book B on B.empl_id = employee.id;

insert into employee (first_name, last_name, email)
VALUE ('hobs', 'smith', 'email1@email.com');
insert into employee (first_name, last_name, email)
VALUE ('luisa', 'tayler', 'email2@email.com');
insert into employee (first_name, last_name, email)
VALUE ('maria', 'maria', 'email3@email.com');

insert into book (name, empl_id)
value ('book_name_1', 1);
insert into book (name, empl_id)
value ('book_name_2', 1);
insert into book (name, empl_id)
value ('book_name_3', 2);