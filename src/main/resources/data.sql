-- src/main/resources/data.sql

-- Insert genres
INSERT INTO genre (name, description)
SELECT 'Rock', 'Rock music'
WHERE NOT EXISTS (SELECT 1
                  FROM genre
                  WHERE name = 'Rock');

-- Insert artists
INSERT INTO artist (name, genre_id)
SELECT 'Queen', 1
WHERE NOT EXISTS (SELECT 1
                  FROM artist
                  WHERE name = 'Queen'
                    AND genre_id = 1);

-- Insert albums
INSERT INTO album (name, release_date, artist_id)
SELECT 'A Night at the Opera', '1975-11-21', 1
WHERE NOT EXISTS (SELECT 1
                  FROM album
                  WHERE name = 'A Night at the Opera'
                    AND artist_id = 1);

-- Insert songs
INSERT INTO song (name, duration, album_id)
SELECT 'Bohemian Rhapsody', '00:06:07', 1
WHERE NOT EXISTS (SELECT 1
                  FROM song
                  WHERE name = 'Bohemian Rhapsody'
                    AND album_id = 1);

-- Insert playlists
INSERT INTO playlist (name, description)
SELECT 'My Rock Playlist', 'A collection of rock songs'
WHERE NOT EXISTS (SELECT 1
                  FROM playlist
                  WHERE name = 'My Rock Playlist');

-- Insert playlist songs
INSERT INTO playlist_song (playlist_id, song_id)
SELECT 1, 1
WHERE NOT EXISTS (SELECT 1
                  FROM playlist_song
                  WHERE playlist_id = 1
                    AND song_id = 1);