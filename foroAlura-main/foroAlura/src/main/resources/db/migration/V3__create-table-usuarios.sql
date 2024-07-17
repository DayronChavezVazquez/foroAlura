create table usuarios(

   id bigint not null auto_increment,
     nombre varchar(250) not null,
     correo_Electronico varchar(250) not null,
     contraseña varchar(300) not null,

   primary key(id)

);