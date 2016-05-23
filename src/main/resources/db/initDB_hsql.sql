DROP TABLE user_roles IF EXISTS;
DROP TABLE votes IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE dishes IF EXISTS;
DROP TABLE menus IF EXISTS;
DROP TABLE restaurants IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ
  AS INTEGER
    START WITH 100000;

CREATE TABLE users
(
  id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  email      VARCHAR(255) NOT NULL,
  password   VARCHAR(255) NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOLEAN DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_idx ON restaurants (name);

CREATE TABLE menus
(
  id INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  restaurant_id INTEGER NOT NULL,
  name          VARCHAR(255) NOT NULL,
  menu_date     DATE    NOT NULL,
  CONSTRAINT menu_date_idx UNIQUE (restaurant_id, menu_date),

  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id)
    ON DELETE CASCADE
);

CREATE TABLE votes
(
  user_id       INTEGER NOT NULL,
  vote_date     DATE    NOT NULL,
  restaurant_id INTEGER NOT NULL,
  menu_id       INTEGER NOT NULL,
  CONSTRAINT user_vote_idx UNIQUE (user_id, vote_date),

  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id)
    ON DELETE CASCADE,
  FOREIGN KEY (menu_id) REFERENCES menus (id)
    ON DELETE CASCADE
);

CREATE TABLE dishes
(
  menu_id INTEGER NOT NULL,
  name    VARCHAR(255) NOT NULL,
  price   FLOAT   NOT NULL,

  CONSTRAINT menu_dishes_idx UNIQUE (menu_id, name),
  FOREIGN KEY (menu_id) REFERENCES menus (id)
    ON DELETE CASCADE
);