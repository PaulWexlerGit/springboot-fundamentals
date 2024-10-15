-- src/main/resources/schema.sql

CREATE TABLE genre (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created_at TIMESTAMP
);

CREATE TABLE artist (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    genre_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY (genre_id) REFERENCES genre(id)
);

CREATE TABLE album (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    release_date DATE,
    artist_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY (artist_id) REFERENCES artist(id)
);

CREATE TABLE song (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    duration TIME,
    album_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY (album_id) REFERENCES album(id)
);

CREATE TABLE playlist (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created_at TIMESTAMP
);

CREATE TABLE playlist_song (
    playlist_id BIGINT,
    song_id BIGINT,
    PRIMARY KEY (playlist_id, song_id),
    FOREIGN KEY (playlist_id) REFERENCES playlist(id),
    FOREIGN KEY (song_id) REFERENCES song(id)
);