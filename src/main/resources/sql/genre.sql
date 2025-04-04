CREATE TABLE public.movie_genre (
                                    id int4 NOT NULL,
                                    genre_name varchar(255) NOT NULL,
                                    CONSTRAINT movie_genre_pkey PRIMARY KEY (id),
                                    CONSTRAINT uk_movie_genre_name UNIQUE (genre_name)
);


insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Music');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'History');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Animation');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Film-Noir');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Sci-Fi');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Sport');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Action');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Adventure');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Animated');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Biography');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Comedy');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Crime');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Dance');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Disaster');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Documentary');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Drama');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Erotic');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Family');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Fantasy');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Found Footage');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Historical');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Horror');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Independent');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Legal');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Live Action');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Martial Arts');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Musical');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Mystery');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Noir');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Performance');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Political');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Romance');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Satire');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Science Fiction');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Short');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Silent');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Slasher');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Sports');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Spy');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Superhero');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Supernatural');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Suspense');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Teen');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Thriller');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'War');
insert into movie_genre(id, genre_name)values(nextval('movie_genre_seq'),'Western');
