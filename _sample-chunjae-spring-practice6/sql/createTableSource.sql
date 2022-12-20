create table source(
    source_id bigint(20) PRIMARY KEY AUTO_INCREMENT not null,
    name varchar(20) not null,
    phone_number varchar(20) not null,
    created datetime default now(),
    last_updated datetime default now()
);
