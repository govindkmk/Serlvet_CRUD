create database student_db;

use student_db;

create table student(
	id int(11) primary key auto_increment,
    roll_number varchar(20),
    name varchar(30),
    father_name varchar(30),
    email varchar(30),
    age int(11),
    department_name varchar(50),
    dob varchar(25),
    gender varchar(10)
);


drop table student;

select * from student;