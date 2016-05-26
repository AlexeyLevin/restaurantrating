DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM menus;
DELETE FROM votes;
DELETE FROM users;
DELETE FROM restaurants;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password) VALUES
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants (name) VALUES
  ('Barbados');
INSERT INTO restaurants (name) VALUES
  ('Ragnarok');
INSERT INTO restaurants (name) VALUES
  ('Saran');

INSERT INTO menus (restaurant_id, name, menu_date) VALUES
  (100002, 'Barbados menu', '2015-05-30'),
  (100003, 'Ragnarok menu', '2015-05-30'),
  (100004, 'Saran menu', '2015-05-31');


INSERT INTO dishes (menu_id, name, price) VALUES
  (100005, 'Barbados soup', 2),
  (100005, 'Barbados salad', 0.5),
  (100005, 'Barbados meat', 2.5),
  (100005, 'Barbados coffee', 0.2),

  (100006, 'Ragnarok soup', 1.5),
  (100006, 'Ragnarok salad', 0.3),
  (100006, 'Ragnarok meat', 2),
  (100006, 'Ragnarok coffee', 0.1),

  (100007, 'Saran soup', 1.5),
  (100007, 'Saran salad', 0.3),
  (100007, 'Saran meat', 2),
  (100007, 'Saran coffee', 0.1);

INSERT INTO votes (user_id, vote_date, restaurant_id, menu_id) VALUES
  (100000, '2015-05-30', 100002, 100005),
  (100000, '2015-05-31', 100004, 100007),

  (100001, '2015-05-30', 100003, 100006),
  (100001, '2015-05-31', 100004, 100007);



