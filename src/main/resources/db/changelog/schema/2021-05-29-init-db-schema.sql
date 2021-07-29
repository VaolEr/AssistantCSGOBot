-- liquibase formatted sql
-- Format: --changeset author:id attribute1:value1 attribute2:value2 [...]

-- changeset VaolEr:Create_teams_table
CREATE TABLE teams
(
    id              integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    api_id          VARCHAR(255) NOT NULL,
    name            VARCHAR(255) NOT NULL,
    country         VARCHAR(64),
    country_code    VARCHAR(8),
    abbreviation    VARCHAR(8)
);

-- changeset VaolEr:Create_users_table
CREATE TABLE users
(
    id         integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    telegram_chat_id integer NOT NULL
);

-- changeset VaolEr:Create_users_teams_table
CREATE TABLE users_teams
(
    id          integer GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
    user_id     integer NOT NULL,
    team_id     integer NOT NULL
);

-- changeset VaolEr:Alter_users_teams_table_fks
ALTER TABLE users_teams
    ADD CONSTRAINT users_teams_fk0 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_teams
    ADD CONSTRAINT users_teams_fk1 FOREIGN KEY (team_id) REFERENCES teams (id);
