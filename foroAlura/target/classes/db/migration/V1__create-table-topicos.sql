create table topicos(

   id_Topico bigint not null auto_increment,
   mensaje varchar(250) not null,
   nombre_Curso varchar(250) not null,
   titulo varchar(250) not null,
   fecha datetime not null,



   primary key(id_Topico)

);