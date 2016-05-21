DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP           DEFAULT now(),
  enabled    BOOL                DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_idx ON restaurants (name);

CREATE TABLE menus
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restauran_id INTEGER NOT NULL,
  name         VARCHAR NOT NULL,
  menu_date    DATE    NOT NULL,
  CONSTRAINT menu_date_idx UNIQUE (restauran_id, menu_date),

  FOREIGN KEY (restauran_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE votes
(
  user_id      INTEGER NOT NULL,
  vote_date    DATE    NOT NULL,
  restauran_id INTEGER NOT NULL,
  menu_id      INTEGER NOT NULL,
  CONSTRAINT user_vote_idx UNIQUE (user_id, vote_date),

  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (restauran_id) REFERENCES restaurants (id) ON DELETE CASCADE,
  FOREIGN KEY (menu_id) REFERENCES menus (id) ON DELETE CASCADE
);

CREATE TABLE dishes
(
  menu_id INTEGER NOT NULL,
  name    VARCHAR NOT NULL,
  price   FLOAT   NOT NULL,

  CONSTRAINT menu_dishes_idx UNIQUE (menu_id, name),
  FOREIGN KEY (menu_id) REFERENCES menus (id) ON DELETE CASCADE
);