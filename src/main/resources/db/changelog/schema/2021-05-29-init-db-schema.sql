-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset VaolEr:Create_items_table
CREATE TABLE events
(
    id integer PRIMARY KEY NOT NULL
);

CREATE TABLE teams
(
    id integer PRIMARY KEY NOT NULL
);


CREATE TABLE users
(
    id         integer PRIMARY KEY,
    tg_chat_id integer NOT NULL,
    event_id   INTEGER NOT NULL REFERENCES events ON DELETE CASCADE ON UPDATE CASCADE,
    team_id    INTEGER NOT NULL REFERENCES teams ON DELETE CASCADE ON UPDATE CASCADE
);