DELETE FROM USER_ROLES;
DELETE FROM DISHES;
DELETE FROM MENUS;
DELETE FROM VOTES;
DELETE FROM USERS;
DELETE FROM RESTAURANTS;

ALTER SEQUENCE global_seq RESTART WITH 100000;
INSERT INTO USERS (NAME, EMAIL, PASSWORD) VALUES
  ('User', 'user@yandex.ru', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni');
INSERT INTO USERS (NAME, EMAIL, PASSWORD) VALUES
  ('Admin', 'admin@gmail.com', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');
INSERT INTO USER_ROLES (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);
INSERT INTO RESTAURANTS (NAME) VALUES
  ('Barbados');
INSERT INTO RESTAURANTS (NAME) VALUES
  ('Ragnarok');
INSERT INTO RESTAURANTS (NAME) VALUES
  ('Saran');
INSERT INTO MENUS (RESTAURANT_ID, NAME, MENU_DATE) VALUES
  (100002, 'Barbados menu', '2015-05-30');
INSERT INTO MENUS (RESTAURANT_ID, NAME, MENU_DATE) VALUES
  (100003, 'Ragnarok menu', '2015-05-30');
INSERT INTO MENUS (RESTAURANT_ID, NAME, MENU_DATE) VALUES
  (100004, 'Saran menu', '2015-05-31');

INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100005, 'Barbados soup', 2);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100005, 'Barbados salad', 0.5);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100005, 'Barbados meat', 2.5);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100005, 'Barbados coffee', 0.2);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100006, 'Ragnarok soup', 1.5);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100006, 'Ragnarok salad', 0.3);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100006, 'Ragnarok meat', 2);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100006, 'Ragnarok coffee', 0.1);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100007, 'Saran soup', 1.5);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100007, 'Saran salad', 0.3);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100007, 'Saran meat', 2);
INSERT INTO DISHES (MENU_ID, NAME, PRICE) VALUES
  (100007, 'Saran coffee', 0.1);

INSERT INTO VOTES (USER_ID, VOTE_DATE, RESTAURANT_ID, MENU_ID) VALUES
  (100000, '2015-05-30', 100002, 100005);
INSERT INTO VOTES (USER_ID, VOTE_DATE, RESTAURANT_ID, MENU_ID) VALUES
  (100000, '2015-05-31', 100004, 100007);
INSERT INTO VOTES (USER_ID, VOTE_DATE, RESTAURANT_ID, MENU_ID) VALUES
  (100001, '2015-05-30', 100003, 100006);
INSERT INTO VOTES (USER_ID, VOTE_DATE, RESTAURANT_ID, MENU_ID) VALUES
  (100001, '2015-05-31', 100004, 100007);



