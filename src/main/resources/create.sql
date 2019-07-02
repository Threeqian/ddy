# create database
# drop database if exists sport;
# create database sport;
use sport;

# create tables
drop table if exists user_info;
create table user_info(
    user_openid varchar(28) not null,
    user_name varchar(20),
    user_img varchar(255),
    user_tag varchar(20),
    user_introduction varchar(255),
    user_score DOUBLE,
    PRIMARY KEY (user_openid)
);

drop table if exists invite_info;
create table invite_info(
    invite_id INT auto_increment,
    inviter_id varchar(28),
    invite_sport_type varchar(20),
    invite_location varchar(255),
    invite_description varchar(255),
    announce_date DATETIME,
    valid_day INT,
    invite_number INT NOT NULL,
    PRIMARY KEY (invite_id),
    FOREIGN KEY (inviter_id) REFERENCES user_info(user_openid)
);

drop table if exists accept_info;
create table accept_info(
    accept_id INT auto_increment,
    invite_id INT,
    accepter_id varchar(28),
    PRIMARY KEY (accept_id),
    FOREIGN KEY (accepter_id) REFERENCES user_info(user_openid),
    FOREIGN KEY (invite_id)REFERENCES invite_info(invite_id)
);

# initialize test data
# insert user
insert into user_info (user_openid, user_name, user_img, user_tag, user_introduction, user_score)
values ('oB4nYjnoHhuWrPVi2pYLuPjnCaU0','aaa','https://images.nowcoder.com/head/25m.png',
        'ping_pong','test_user 1',1.0);

insert into user_info (user_openid, user_name, user_img, user_tag, user_introduction, user_score)
values ('oB4nYjvY13SVtaWC-AFztM2f3TlU','bbb','https://images.nowcoder.com/head/35m.png',
                              'football','test_user 2',2.0);

insert into user_info (user_openid, user_name, user_img, user_tag, user_introduction, user_score)
values ('oB4nYjhJHQVaD0PL7qs0W1kL-_ls','ccc','https://images.nowcoder.com/head/45m.png',
        'table_tennis','test_user 3',3.0);

# insert invitations
insert into invite_info (invite_id, inviter_id, invite_sport_type, invite_location, invite_description, announce_date, valid_day, invite_number)
values (null,'oB4nYjnoHhuWrPVi2pYLuPjnCaU0','ping-pong',
        'local','play ping-pong','2019-07-01 10:00:00',
        2,1);

insert into invite_info (invite_id, inviter_id, invite_sport_type, invite_location, invite_description, announce_date, valid_day, invite_number)
values (null,'oB4nYjvY13SVtaWC-AFztM2f3TlU','football',
        'local','play football','2019-07-01 11:00:00',
        3,12);

insert into invite_info (invite_id, inviter_id, invite_sport_type, invite_location, invite_description, announce_date, valid_day, invite_number)
values (null,'oB4nYjhJHQVaD0PL7qs0W1kL-_ls','table_tennis',
        'local','play table_tennis','2019-07-01 12:00:00',
        4,2);

# insert acceptation
insert into accept_info (accept_id, invite_id, accepter_id)
values (null,1,'oB4nYjvY13SVtaWC-AFztM2f3TlU');

insert into accept_info (accept_id, invite_id, accepter_id)
values (null,2,'oB4nYjnoHhuWrPVi2pYLuPjnCaU0');

insert into accept_info (accept_id, invite_id, accepter_id)
values (null,2,'oB4nYjhJHQVaD0PL7qs0W1kL-_ls');

insert into accept_info (accept_id, invite_id, accepter_id)
values (null,3,'oB4nYjvY13SVtaWC-AFztM2f3TlU');
