-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset VaolEr:Create_events_table
CREATE TABLE events
(
    id      integer PRIMARY KEY NOT NULL,
    title   VARCHAR(255) NOT NULL,
    tier    integer NOT NULL
);

-- changeset VaolEr:Create_teams_table
CREATE TABLE teams
(
    id              integer PRIMARY KEY NOT NULL,
    name            VARCHAR(255) NOT NULL,
    abbreviation    VARCHAR(255)
);

-- changeset VaolEr:Create_users_table
CREATE TABLE users
(
    id         integer PRIMARY KEY NOT NULL,
    tg_chat_id integer NOT NULL,
    event_id   INTEGER NOT NULL,
    team_id    INTEGER NOT NULL
);

-- changeset VaolEr:Create_users_teams_table
CREATE TABLE users_teams
(
    id          integer PRIMARY KEY NOT NULL,
    user_id     integer NOT NULL,
    team_id     integer NOT NULL
);

-- changeset VaolEr:Create_users_events_table
CREATE TABLE users_events
(
    id          integer PRIMARY KEY NOT NULL,
    user_id     integer NOT NULL,
    event_id    integer NOT NULL
);

-- changeset VaolEr:Alter_users_teams_table_fks
ALTER TABLE users_teams
    ADD CONSTRAINT users_teams_fk0 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_teams
    ADD CONSTRAINT users_teams_fk1 FOREIGN KEY (team_id) REFERENCES teams (id);

-- changeset VaolEr:Alter_users_events_table_fks
ALTER TABLE users_events
    ADD CONSTRAINT users_events_fk0 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_events
    ADD CONSTRAINT users_events_fk1 FOREIGN KEY (event_id) REFERENCES events (id);