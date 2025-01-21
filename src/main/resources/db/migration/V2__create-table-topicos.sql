
create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    fecha_de_creacion datetime not null,
    status varchar(20) not null,
    autor varchar(100) not null,
    nombre_curso varchar(100) not null,
    categoria_curso varchar(20) not null,

    primary key(id)

);
