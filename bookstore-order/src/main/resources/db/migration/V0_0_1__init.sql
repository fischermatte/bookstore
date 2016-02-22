    create table "order" (
        id binary(255) not null,
        customer_id varchar(255) not null,
        primary key (id)
    );

    create table domain_event (
        event_type varchar(31) not null,
        domain_event_id binary(255) not null,
        published_to_remote boolean not null,
        primary key (domain_event_id)
    );

    create table order_item (
        id binary(255) not null,
        primary key (id)
    );

    create table order_submitted_event (
        customer_id varchar(255),
        order_id binary(255),
        domain_event_id binary(255) not null,
        primary key (domain_event_id)
    );

    alter table order_submitted_event
        add constraint FK_5tn8nr4guct8jf4givxp1mjsd
        foreign key (domain_event_id)
        references domain_event;
