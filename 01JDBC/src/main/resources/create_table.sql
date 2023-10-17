create table books
(
    bid         int auto_increment
        primary key,
    book_num    char(8)      not null,
    book_name   varchar(100) not null,
    book_author varchar(10)  not null,
    book_price  float        not null,
    book_desc   varchar(100) null,
    book_stock  int          null,
    constraint book_num
        unique (book_num)
)
    engine = InnoDB;

create table classes
(
    cid        int auto_increment
        primary key,
    class_num  char(4)      not null,
    class_name varchar(20)  not null,
    class_desc varchar(100) null,
    constraint class_num
        unique (class_num)
)
    engine = InnoDB;

create table students
(
    sid        int auto_increment
        primary key,
    stu_num    char(8)      not null,
    stu_name   varchar(10)  not null,
    stu_gender char         not null,
    stu_age    int          null,
    stu_class  int          null,
    stu_desc   varchar(100) null,
    constraint stu_num
        unique (stu_num),
    constraint FK_StudentClass
        foreign key (stu_class) references classes (cid)
)
    engine = InnoDB;

create table records
(
    rid          int auto_increment
        primary key,
    stu_num      char(8) not null,
    book_num     char(8) not null,
    record_stock int     not null,
    record_date  date    null,
    constraint records_ibfk_1
        foreign key (stu_num) references students (stu_num),
    constraint records_ibfk_2
        foreign key (book_num) references books (book_num)
)
    engine = InnoDB;

create index FK_RecordBook
    on records (book_num);

create index FK_RecordStudent
    on records (stu_num);


