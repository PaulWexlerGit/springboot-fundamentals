-- src/main/resources/data.sql

-- Insert genres
INSERT INTO genre (name, description) VALUES ('Rock', 'Rock music');

-- Insert artists
INSERT INTO artist (name, genre_id) VALUES ('Queen', 1);

-- Insert albums
INSERT INTO album (name, release_date, artist_id) VALUES ('A Night at the Opera', '1975-11-21', 1);

-- Insert songs
INSERT INTO song (name, duration, album_id) VALUES ('Bohemian Rhapsody', '00:06:07', 1);

-- Insert playlists
INSERT INTO playlist (name, description) VALUES ('My Rock Playlist', 'A collection of rock songs');

-- Insert playlist songs
INSERT INTO playlist_song (playlist_id, song_id) VALUES (1, 1);