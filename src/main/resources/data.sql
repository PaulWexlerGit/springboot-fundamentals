-- src/main/resources/data.sql

-- Insert genres
INSERT INTO genre (name, description)
SELECT 'Rock', 'Rock music'
WHERE NOT EXISTS (SELECT 1 FROM genre WHERE name = 'Rock');

INSERT INTO genre (name, description)
SELECT 'Pop', 'Pop music'
WHERE NOT EXISTS (SELECT 1 FROM genre WHERE name = 'Pop');

INSERT INTO genre (name, description)
SELECT 'Jazz', 'Jazz music'
WHERE NOT EXISTS (SELECT 1 FROM genre WHERE name = 'Jazz');

INSERT INTO genre (name, description)
SELECT 'Classical', 'Classical music'
WHERE NOT EXISTS (SELECT 1 FROM genre WHERE name = 'Classical');

-- Insert artists
INSERT INTO artist (name, genre_id)
SELECT 'Queen', 1
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Queen' AND genre_id = 1);

INSERT INTO artist (name, genre_id)
SELECT 'The Beatles', 1
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'The Beatles' AND genre_id = 1);

INSERT INTO artist (name, genre_id)
SELECT 'Elton John', 2
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Elton John' AND genre_id = 2);

INSERT INTO artist (name, genre_id)
SELECT 'Michael Jackson', 2
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Michael Jackson' AND genre_id = 2);

INSERT INTO artist (name, genre_id)
SELECT 'Miles Davis', 3
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Miles Davis' AND genre_id = 3);

INSERT INTO artist (name, genre_id)
SELECT 'John Coltrane', 3
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'John Coltrane' AND genre_id = 3);

INSERT INTO artist (name, genre_id)
SELECT 'Ludwig van Beethoven', 4
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Ludwig van Beethoven' AND genre_id = 4);

INSERT INTO artist (name, genre_id)
SELECT 'Wolfgang Amadeus Mozart', 4
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Wolfgang Amadeus Mozart' AND genre_id = 4);

-- Insert albums
INSERT INTO album (name, release_date, artist_id)
SELECT 'A Night at the Opera', '1975-11-21', 1
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'A Night at the Opera' AND artist_id = 1);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Abbey Road', '1969-09-26', 2
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Abbey Road' AND artist_id = 2);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Goodbye Yellow Brick Road', '1973-10-05', 3
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Goodbye Yellow Brick Road' AND artist_id = 3);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Thriller', '1982-11-30', 4
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Thriller' AND artist_id = 4);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Kind of Blue', '1959-08-17', 5
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Kind of Blue' AND artist_id = 5);

INSERT INTO album (name, release_date, artist_id)
SELECT 'A Love Supreme', '1965-01-12', 6
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'A Love Supreme' AND artist_id = 6);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Symphony No. 9', '1824-05-07', 7
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Symphony No. 9' AND artist_id = 7);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Requiem', '1791-12-05', 8
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Requiem' AND artist_id = 8);

-- Insert songs
INSERT INTO song (name, duration, album_id)
SELECT 'Bohemian Rhapsody', 367000000000, 1
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Bohemian Rhapsody' AND album_id = 1);

INSERT INTO song (name, duration, album_id)
SELECT 'Love of My Life', 217000000000, 1
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Love of My Life' AND album_id = 1);

INSERT INTO song (name, duration, album_id)
SELECT 'Come Together', 259000000000, 2
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Come Together' AND album_id = 2);

INSERT INTO song (name, duration, album_id)
SELECT 'Something', 182000000000, 2
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Something' AND album_id = 2);

INSERT INTO song (name, duration, album_id)
SELECT 'Bennie and the Jets', 317000000000, 3
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Bennie and the Jets' AND album_id = 3);

INSERT INTO song (name, duration, album_id)
SELECT 'Candle in the Wind', 240000000000, 3
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Candle in the Wind' AND album_id = 3);

INSERT INTO song (name, duration, album_id)
SELECT 'Thriller', 358000000000, 4
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Thriller' AND album_id = 4);

INSERT INTO song (name, duration, album_id)
SELECT 'Beat It', 258000000000, 4
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Beat It' AND album_id = 4);

INSERT INTO song (name, duration, album_id)
SELECT 'So What', 545000000000, 5
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'So What' AND album_id = 5);

INSERT INTO song (name, duration, album_id)
SELECT 'Freddie Freeloader', 589000000000, 5
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Freddie Freeloader' AND album_id = 5);

INSERT INTO song (name, duration, album_id)
SELECT 'A Love Supreme Part I', 467000000000, 6
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'A Love Supreme Part I' AND album_id = 6);

INSERT INTO song (name, duration, album_id)
SELECT 'A Love Supreme Part II', 480000000000, 6
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'A Love Supreme Part II' AND album_id = 6);

INSERT INTO song (name, duration, album_id)
SELECT 'Ode to Joy', 1440000000000, 7
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Ode to Joy' AND album_id = 7);

INSERT INTO song (name, duration, album_id)
SELECT 'Requiem in D Minor', 1500000000000, 8
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Requiem in D Minor' AND album_id = 8);

-- Insert more artists
INSERT INTO artist (name, genre_id)
SELECT 'Adele', 2
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Adele' AND genre_id = 2);

INSERT INTO artist (name, genre_id)
SELECT 'Taylor Swift', 2
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Taylor Swift' AND genre_id = 2);

INSERT INTO artist (name, genre_id)
SELECT 'Nirvana', 1
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Nirvana' AND genre_id = 1);

INSERT INTO artist (name, genre_id)
SELECT 'Pink Floyd', 1
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Pink Floyd' AND genre_id = 1);

INSERT INTO artist (name, genre_id)
SELECT 'Billie Eilish', 2
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Billie Eilish' AND genre_id = 2);

INSERT INTO artist (name, genre_id)
SELECT 'Duke Ellington', 3
WHERE NOT EXISTS (SELECT 1 FROM artist WHERE name = 'Duke Ellington' AND genre_id = 3);

-- Insert more albums
INSERT INTO album (name, release_date, artist_id)
SELECT '21', '2011-01-24', 9
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = '21' AND artist_id = 9);

INSERT INTO album (name, release_date, artist_id)
SELECT '1989', '2014-10-27', 10
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = '1989' AND artist_id = 10);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Nevermind', '1991-09-24', 11
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Nevermind' AND artist_id = 11);

INSERT INTO album (name, release_date, artist_id)
SELECT 'The Dark Side of the Moon', '1973-03-01', 12
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'The Dark Side of the Moon' AND artist_id = 12);

INSERT INTO album (name, release_date, artist_id)
SELECT 'When We All Fall Asleep, Where Do We Go?', '2019-03-29', 13
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'When We All Fall Asleep, Where Do We Go?' AND artist_id = 13);

INSERT INTO album (name, release_date, artist_id)
SELECT 'Ellington at Newport', '1956-07-07', 14
WHERE NOT EXISTS (SELECT 1 FROM album WHERE name = 'Ellington at Newport' AND artist_id = 14);

-- Insert more songs
INSERT INTO song (name, duration, album_id)
SELECT 'Rolling in the Deep', 228000000000, 9
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Rolling in the Deep' AND album_id = 9);

INSERT INTO song (name, duration, album_id)
SELECT 'Someone Like You', 285000000000, 9
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Someone Like You' AND album_id = 9);

INSERT INTO song (name, duration, album_id)
SELECT 'Shake It Off', 242000000000, 10
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Shake It Off' AND album_id = 10);

INSERT INTO song (name, duration, album_id)
SELECT 'Blank Space', 231000000000, 10
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Blank Space' AND album_id = 10);

INSERT INTO song (name, duration, album_id)
SELECT 'Smells Like Teen Spirit', 301000000000, 11
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Smells Like Teen Spirit' AND album_id = 11);

INSERT INTO song (name, duration, album_id)
SELECT 'Come as You Are', 219000000000, 11
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Come as You Are' AND album_id = 11);

INSERT INTO song (name, duration, album_id)
SELECT 'Money', 382000000000, 12
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Money' AND album_id = 12);

INSERT INTO song (name, duration, album_id)
SELECT 'Time', 413000000000, 12
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Time' AND album_id = 12);

INSERT INTO song (name, duration, album_id)
SELECT 'Bad Guy', 194000000000, 13
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Bad Guy' AND album_id = 13);

INSERT INTO song (name, duration, album_id)
SELECT 'Bury a Friend', 193000000000, 13
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Bury a Friend' AND album_id = 13);

INSERT INTO song (name, duration, album_id)
SELECT 'Diminuendo and Crescendo in Blue', 1140000000000, 14
WHERE NOT EXISTS (SELECT 1 FROM song WHERE name = 'Diminuendo and Crescendo in Blue' AND album_id = 14);

-- Insert playlists
INSERT INTO playlist (name, description)
SELECT 'My Rock Playlist', 'A collection of rock songs'
WHERE NOT EXISTS (SELECT 1 FROM playlist WHERE name = 'My Rock Playlist');

INSERT INTO playlist (name, description)
SELECT 'Pop Hits', 'Popular pop songs'
WHERE NOT EXISTS (SELECT 1 FROM playlist WHERE name = 'Pop Hits');

INSERT INTO playlist (name, description)
SELECT 'Jazz Classics', 'Classic jazz tunes'
WHERE NOT EXISTS (SELECT 1 FROM playlist WHERE name = 'Jazz Classics');

-- Insert playlist songs
INSERT INTO playlist_song (playlist_id, song_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 1 AND song_id = 1);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 1, 3
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 1 AND song_id = 3);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 1, 5
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 1 AND song_id = 5);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 2, 7
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 2 AND song_id = 7);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 2, 9
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 2 AND song_id = 9);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 2, 11
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 2 AND song_id = 11);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 3, 13
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 3 AND song_id = 13);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 3, 15
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 3 AND song_id = 15);

INSERT INTO playlist_song (playlist_id, song_id)
SELECT 3, 17
WHERE NOT EXISTS (SELECT 1 FROM playlist_song WHERE playlist_id = 3 AND song_id = 17);