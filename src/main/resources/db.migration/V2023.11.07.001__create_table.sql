create table if not exists users
(
    id          bigserial primary key,
    telegram_id bigint unique
);

create table if not exists companies
(
    id   bigserial primary key,
    name varchar(200) not null unique
);

create table if not exists price_qualities
(
    id   bigserial primary key,
    name varchar(10) not null unique
);

create table if not exists views
(
    id               bigserial primary key,
    item_name         varchar(200) not null unique,
    mview_path        text         not null unique,
    creating_date     date,
    company_id       bigint references companies (id),
    price_quality_id bigint references price_qualities (id),
    user_id          bigint references users (id)
);