create database PolyOE_ASM
use PolyOE_ASM
create table Users(
	id nvarchar(10) not null,
    password nvarchar(50) not null,
    fullname nvarchar(50) not null,
    email nvarchar(50) not null unique,
    admin bit not null,
    primary key(id)
)

create table Video(
	id nvarchar(10) not null,
    title nvarchar(50) not null,
    poster nvarchar(50) not null,
    views int not null,
    description nvarchar(50) not null,
    active bit not null,
    link nvarchar(200) not null unique,
    primary key(id)
)

create table Favorite(
	id bigint not null,
    userId nvarchar(50) not null unique,
    videoId nvarchar(50) not null unique,
    likeDate date not null,
    primary key(id),
    foreign key(userId) references Users(id),
    foreign key(videoId) references Video(id)
)

create table Share(
	id bigint not null,
    userId nvarchar(50) not null,
    videoId nvarchar(50) not null,
    emails nvarchar(50) not null,
    shareDate date not null,
    primary key(id),
    foreign key(userId) references Users(id),
    foreign key(videoId) references Video(id)
)
select* from users
select* from video
insert into users(id, password, fullname, email, admin) values ('1', '111', 'User01', 'user01@gmail.com', 0);
insert into users(id, password, fullname, email, admin) values ('2', '222', 'User02', 'user02@gmail.com', 1);
insert into users(id, password, fullname, email, admin) values ('3', '333', 'User03', 'user03@fpt.edu.vn', 1);
insert into users(id, password, fullname, email, admin) values ('4', '444', 'User04', 'user04@fpt.edu.vn', 0);
insert into users(id,password, fullname, email, admin) values ('5', '555', 'User05', 'user05@fpt.edu.vn', 0);
insert into users(id, password, fullname, email, admin) values ('6', '666', 'User06', 'user06@fpt.edu.vn', 1);
insert into users(id, password, fullname, email, admin) values ('7', '777', 'User07', 'user07@fpt.edu.vn', 1);
insert into users(id, password, fullname, email, admin) values ('8', '888', 'User08', 'user08@fpt.edu.vn', 0);

insert into video(id, title, poster, views, description, active, link) values ('1', 'Anh', 'England', 1000, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDk');
insert into video(id, title, poster, views, description, active, link) values ('2', 'Pháp', 'France', 1500, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDa');
insert into video(id, title, poster, views, description, active, link) values ('3', 'Mỹ', 'America', 1000, 'N', 1, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDb');
insert into video(id, title, poster, views, description, active, link) values ('4', 'Đức', 'Germany', 2000, 'N', 1, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDc');
insert into video(id, title, poster, views, description, active, link) values ('5', 'Việt Nam', 'Vietnam', 13000, 'N', 1, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDd');
insert into video(id, title, poster, views, description, active, link) values ('6', 'Trung Quốc', 'China', 4000, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDe');
insert into video(id, title, poster, views, description, active, link) values ('7', 'Nhật Bản', 'Japan', 100, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDf');
insert into video(id, title, poster, views, description, active, link) values ('8', 'Hàn Quốc', 'Korea', 100, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDg');
insert into video(id, title, poster, views, description, active, link) values ('9', 'Nga', 'Russia', 7000, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDh');
insert into video(id, title, poster, views, description, active, link) values ('10', 'Úc', 'Australia', 8000, 'N', 1, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDl');
insert into video(id, title, poster, views, description, active, link) values ('11', 'Lào', 'Laos', 5000, 'N', 1, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDm');
insert into video(id, title, poster, views, description, active, link) values ('12', 'Thái Lan', 'Thailand', 1400, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDn');
insert into video(id, title, poster, views, description, active, link) values ('13', 'Ấn Độ', 'India', 300, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDo');
insert into video(id, title, poster, views, description, active, link) values ('14', 'Tây Ban Nha', 'Spain', 200, 'N', 1, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDp');
insert into video(id, title, poster, views, description, active, link) values ('15', 'Bồ Đào Nha', 'Portugal', 800, 'N', 0, 'https://youtu.be/4oIQP_lXu8U?si=JGFbjTCLsy0PxiDq');
insert into favorite(id, userId, videoId, likeDate) values (1, '1', '1', '2020-09-08');
insert into share(id, userId, videoId, emails, shareDate) values (1, '1', '1', 'user01@gmail.com', '2021-09-08');
insert into share(id, userId, videoId, emails, shareDate) values (2, '3', '1', 'user03@gmail.com', '2021-10-08');