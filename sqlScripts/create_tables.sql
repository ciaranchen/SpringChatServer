CREATE TABLE IF not EXISTS chat_settings (
    id          INTEGER         PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE IF NOT EXISTS chat_users ( 
    id          INTEGER         PRIMARY KEY AUTOINCREMENT,
    username    VARCHAR(150)    NOT NULL unique,
    passwd      BOOLEAN         NOT NULL,
--    signUpDate  DATETIME        NOT NULL,
    setting     INTEGER         NOT NULL,
    FOREIGN KEY(setting) REFERENCES chat_settings
);

CREATE TABLE IF NOT EXISTS chat_rooms (
    id          INTEGER         PRIMARY KEY AUTOINCREMENT,
    name        VARCHAR(150)    NOT NULL,
    owner       INTEGER         NOT NULL,
    FOREIGN KEY(owner)  REFERENCES chat_users
);

CREATE TABLE IF NOT EXISTS room_user (
    id          INTEGER         PRIMARY KEY AUTOINCREMENT,
    room        INTEGER         NOT NULL,
    user        INTEGER         NOT NULL,
    FOREIGN KEY(room) REFERENCES chat_rooms,
    FOREIGN KEY(user) REFERENCES chat_users
);

CREATE TABLE IF NOT EXISTS double_chats (
    id          INTEGER         PRIMARY KEY AUTOINCREMENT,
    user1       INTEGER         NOT NULL,
    user2       INTEGER         NOT NULL,
    FOREIGN KEY(user1) REFERENCES chat_users,
    FOREIGN KEY(user2) REFERENCES chat_users
);

CREATE TABLE IF NOT EXISTS records_room (
    id          INTEGER         PRIMARY KEY AUTOINCREMENT,
    room        INTEGER         NOT NULL,
    user        INTEGER         NOT NULL,
    msg         TEXT            NOT NULL,
    stamp       DATETIME        NOT NULL,
    FOREIGN KEY(room) REFERENCES chat_rooms,
    FOREIGN KEY(user) REFERENCES chat_users
);

CREATE TABLE IF NOT EXISTS records_double (
    id          INTEGER         PRIMARY KEY AUTOINCREMENT,
    channel     INTEGER         NOT NULL,
    msg         TEXT            NOT NULL,
    stamp       DATETIME        NOT NULL,
    FOREIGN KEY(channel) REFERENCES double_chats
);