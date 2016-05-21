DELETE FROM user_roles;
DELETE FROM votes;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM menus;
DELETE FROM restaurants;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants ("id", "name")
VALUES (100003, 'Barbados');

INSERT INTO restaurants ("id", "name")
VALUES (100004, 'Ragnarok');

INSERT INTO restaurants ("id", "name")
VALUES (100005, 'Saran');

INSERT INTO menus ("id", "restauran_id", "name", "menu_date")
    VALUES ()





