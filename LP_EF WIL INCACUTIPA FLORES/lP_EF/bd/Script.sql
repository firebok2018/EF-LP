drop database if exists modelo;
create database modelo;
use modelo;

create table artefacto(
idartefacto int(11) primary key auto_increment,
nombre varchar(45),
stock int(11),
precio double,
fechaRegsitro varchar(30)
);

delimiter $$
create procedure add_artefacto(nom varchar(45),stock int(11),pre double,fecha varchar(30))
begin 
	insert into artefacto values(null,nom,stock,pre,fecha);
end $$
delimiter ;


delimiter $$
create procedure ls_art()
begin
 select*from artefacto;
end $$
delimiter ;

call ls_art();

delimiter $$
create procedure ls_m(num int(11))
begin
	select*from artefacto where stock<num;
end $$
delimiter ;
call ls_m(10);