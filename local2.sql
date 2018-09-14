alter table participants modify wavier date;

alter table participants modify wavier null;

alter table participants modify wavier date null;

insert into participants(lastname, firstname, wavier, username, password) values ('SCARPACE', 'MICHAEL', TO_DATE('2018/09/14','yyyy/mm/dd'),'mscarpace', 'password');  