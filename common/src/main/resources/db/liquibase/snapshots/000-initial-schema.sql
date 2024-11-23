-- Warehouse table
create table warehouse (
    warehouse_id varchar(255) primary key,
    warehouse_name varchar(255) not null,
    warehouse_type varchar(50) not null,
    usage_purpose varchar(50) not null,
    active_status varchar(50) not null,
    city varchar(255) not null,
    street varchar(255) not null,
    postal_code varchar(20) not null,
    country varchar(20) not null,
    detail_address varchar(20),
    province_or_state varchar(20),
    opening_time time not null,
    closing_time time not null
);

-- Location table (Base abstract entity)
create table location (
    location_id varchar(255) primary key,
    location_name varchar(255) not null,
    parent_id varchar(255),
    constraint fk_location_parent foreign key (parent_id) references location (location_id) on delete set null
);

-- Zone table (Inherits from Location using JOINED strategy)
create table zone (
    location_id varchar(255) primary key,
    warehouse_id varchar(255) not null,
    zone_code varchar(255) not null,
    zone_type varchar(50) not null,
    location_active_status varchar(50) not null,
    constraint fk_zone_location foreign key (location_id) references location (location_id) on delete cascade,
    constraint fk_zone_warehouse foreign key (warehouse_id) references warehouse (warehouse_id) on delete cascade
);