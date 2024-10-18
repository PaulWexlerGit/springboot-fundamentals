-- src/main/resources/schema.sql

CREATE TABLE IF NOT EXISTS genre
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    description VARCHAR
(
    255
),
    created_at TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS artist
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    genre_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY
(
    genre_id
) REFERENCES genre
(
    id
)
    );

CREATE TABLE IF NOT EXISTS album
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    release_date DATE,
    artist_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY
(
    artist_id
) REFERENCES artist
(
    id
)
    );

CREATE TABLE IF NOT EXISTS song
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    duration BIGINT, -- Changed from TIME to BIGINT to store duration in nanoseconds
    album_id BIGINT,
    created_at TIMESTAMP,
    FOREIGN KEY
(
    album_id
) REFERENCES album
(
    id
)
    );

CREATE TABLE IF NOT EXISTS playlist
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL,
    description VARCHAR
(
    255
),
    created_at TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS playlist_song
(
    playlist_id
    BIGINT,
    song_id
    BIGINT,
    PRIMARY
    KEY
(
    playlist_id,
    song_id
),
    FOREIGN KEY
(
    playlist_id
) REFERENCES playlist
(
    id
),
    FOREIGN KEY
(
    song_id
) REFERENCES song
(
    id
)
    );