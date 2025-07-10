create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(500) not null,
    fecha_creacion datetime not null,
    estado varchar(20) not null,
    autor_id varchar(80),
    curso varchar(200),

    primary key(id)

);