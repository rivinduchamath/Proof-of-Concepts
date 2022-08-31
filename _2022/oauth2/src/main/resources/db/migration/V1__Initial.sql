create table auth_role
(
    id   int          not null
        primary key,
    name varchar(255) null,
    constraint UK_lc1sij60969nsgl5cy8bfgbsm
        unique (name)
);

create table auth_user
(
    id                      bigint        not null
        primary key,
    account_non_expired     bit           null,
    account_non_locked      bit           null,
    credentials_non_expired bit           null,
    email                   varchar(255)  null,
    enabled                 bit           null,
    password                varchar(1000) null,
    user_name               varchar(255)  null,
    constraint UK_klvc3dss72qnlrjp2bai055mw
        unique (email)
);

create table hibernate_sequence
(
    next_val bigint null
);

create table oauth_access_token
(
    token_id          varchar(255) not null
        primary key,
    authentication    mediumblob   null,
    authentication_id varchar(255) null,
    client_id         varchar(255) null,
    refresh_token     varchar(255) null,
    token             mediumblob   null,
    user_name         varchar(255) null
);

create table oauth_approvals
(
    user_id          varchar(255) not null
        primary key,
    client_d         varchar(255) null,
    expires_at       datetime(6)  null,
    last_modified_at datetime(6)  null,
    scope            varchar(255) null
);

create table oauth_client_details
(
    client_id               varchar(255) not null
        primary key,
    autoapprove             varchar(255) null,
    access_token_validity   int          null,
    additional_information  varchar(255) null,
    authorities             varchar(255) null,
    authorized_grant_types  varchar(255) null,
    client_secret           varchar(255) null,
    refresh_token_validity  int          null,
    resource_ids            varchar(255) null,
    scope                   varchar(255) null,
    web_server_redirect_uri varchar(255) null
);

create table oauth_client_token
(
    token_id          varchar(255) not null
        primary key,
    authentication_id varchar(255) null,
    client_id         varchar(255) null,
    token             mediumblob   null,
    user_name         varchar(255) null
);

create table oauth_code
(
    code           varchar(255) not null
        primary key,
    authentication bigint       null
);

create table oauth_refresh_token
(
    token_id       varchar(256) null,
    token          mediumblob   null,
    authentication mediumblob   null
);

create table permission
(
    id   int          not null
        primary key,
    name varchar(255) null
);

create table permission_role
(
    role_id       int not null,
    permission_id int not null,
    constraint FK3huxulpctka6pjojww9vn7uj2
        foreign key (role_id) references auth_role (id),
    constraint FK3tuvkbyi6wcytyg21hvpd6txw
        foreign key (permission_id) references permission (id)
);

create table role_user
(
    user_id bigint not null,
    role_id int    not null,
    constraint FK55mf7c7ag4e1bt08w8uyos9og
        foreign key (role_id) references auth_role (id),
    constraint FKlb2i1httc6dlloatt4sx3u9l9
        foreign key (user_id) references auth_user (id)
);




DROP TABLE if exists oauth_refresh_token;
create table if not exists oauth_refresh_token (
                                                   token_id VARCHAR(256),
                                                   token LONG VARBINARY,
                                                   authentication LONG VARBINARY
);

DROP TABLE oauth_code;
create table if not exists oauth_code (
             code VARCHAR(256), authentication LONG VARBINARY
);




INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('Web', '{bcrypt}$2a$12$v7BWLKlyF5H1k8NBYBvBI.C5SBziVSRZDpmW/6Es9kGpxe3l.dbKu', 'http://localhost:8080/login', 'READ,WRITE', '999999999', '999999999', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

INSERT INTO permission (id, NAME) VALUES
                                      (1,'create_profile'),
                                      (2,'read_profile'),
                                      (3,'update_profile'),
                                      (4,'delete_profile');

INSERT INTO auth_role (id, NAME) VALUES
                                (1,'ROLE_admin'),(2,'ROLE_operator'),(3,'ROLE_editor');

INSERT INTO permission_role (PERMISSION_ID, ROLE_ID) VALUES
                                                         (1,1),
                                                         (2,1),
                                                         (3,1),
                                                         (4,1),
                                                         (1,3),
                                                         (4,2),
                                                         (3,2);
insert into auth_user (id, email, password,user_name,  enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('1', 'CogAdmin','{bcrypt}$2a$12$v7BWLKlyF5H1k8NBYBvBI.C5SBziVSRZDpmW/6Es9kGpxe3l.dbKu','Chamath',  true,true,true,true);
insert into auth_user (id, email, password,user_name,  enabled, account_non_expired, credentials_non_expired, account_non_locked) VALUES ('2', 'CogAdmin2','{bcrypt}$2a$12$v7BWLKlyF5H1k8NBYBvBI.C5SBziVSRZDpmW/6Es9kGpxe3l.dbKu','Chamath2',  true,true,true,true);

INSERT INTO role_user (ROLE_ID, USER_ID)
VALUES
    (1, 1) ,
    (2, 1) ,
    (3, 1) ;

insert into hibernate_sequence
SET next_val = 7;