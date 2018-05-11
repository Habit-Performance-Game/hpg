use hpg_db;


INSERT INTO hpg_db.avatars (id, name, url) VALUES (1, 'Sword', 'ra ra-sword ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (2, 'Knight', 'ra ra-knight-helmet ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (3, 'Claw', 'ra ra-bird-claw ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (4, 'Pirate', 'ra ra-blade-bite ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (5, 'Sword', 'ra ra-croc-sword ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (6, 'Arrow', 'ra ra-chemical-arrow ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (7, 'Raven', 'ra ra-raven ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (8, 'Castle Flag', 'ra ra-castle-flag ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (9, 'Skull', 'ra ra-death-skull ra-4x');
INSERT INTO hpg_db.avatars (id, name, url) VALUES (10, 'Crown', 'ra ra-queen-crown ra-4x');


INSERT INTO hpg_db.categories (id, category) VALUES (1, 'diet');
INSERT INTO hpg_db.categories (id, category) VALUES (2, 'fitness');
INSERT INTO hpg_db.categories (id, category) VALUES (4, 'meditation');
INSERT INTO hpg_db.categories (id, category) VALUES (3, 'study');
INSERT INTO hpg_db.categories (id, category) VALUES (5, 'volunteer');

INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (7, 'fas fa-tint fa-2x blue', 'Drink 8oz of water.', 8, 'ind', 1);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (8, 'ra ra-muscle-fat ra-2x red', 'Push-ups', 25, 'ind', 2);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (9, 'fas fa-book fa-2x green', 'Read for 30mins', 30, 'ind', 3);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (10, 'fas fa-hourglass-end fa-2x green', 'Meditation', 30, 'ind', 4);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (11, 'fas fa-utensils fa-2x green', 'Meals without Sugar', 10, 'ind', 1);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (12, 'fas fa-hands fa-2x green', 'Volunteer 20 hours.', 20, 'ind', 5);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (13, 'fas fa-keyboard fa-2x red', 'One hour of code for 100 days.', 100, 'ind', 3);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (14, 'ra ra-triforce ra-2x blue', 'Walk one mile for 20 days.', 20, 'ind', 2);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (15, 'ra ra-muscle-fat ra-2x gold', '500 Push-ups', 500, 'clan', 2);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (16, 'ra ra-boot-stomp ra-2x gold', 'Run 100 miles', 100, 'clan', 2);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (17, 'ra ra-boot-stomp ra-2x silver', 'Run 50 miles', 50, 'clan', 2);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (18, 'ra ra-muscle-fat ra-2x silver', '250 Push-ups', 250, 'clan', 2);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (19, 'fas fa-hands fa-2x silver', 'Volunteer 100 hours.', 100, 'clan', 5);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (20, 'fas fa-hands fa-2x gold', 'Volunteer 200 hours.', 200, 'clan', 5);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (21, 'fas fa-tint fa-2x silver', 'Drink 800oz of water.', 800, 'clan', 1);
INSERT INTO hpg_db.badges (id, icon_classes, name, req_amt, type, category_id) VALUES (22, 'fas fa-tint fa-2x gold', 'Drink 1600oz of water.', 1600, 'clan', 1);

#Clans

INSERT INTO hpg_db.clans (id, announcements, created_on, name, owner_id) VALUES (1, null, '2018-05-09 16:33:05', 'Dragons15', 1);
INSERT INTO hpg_db.clans (id, announcements, created_on, name, owner_id) VALUES (2, null, '2018-05-10 16:43:43', 'HPG-Cool-Guys', 1);
INSERT INTO hpg_db.clans (id, announcements, created_on, name, owner_id) VALUES (3, null, '2018-05-10 16:43:55', 'Sequoia', 1);
INSERT INTO hpg_db.clans (id, announcements, created_on, name, owner_id) VALUES (4, null, '2018-05-11 09:55:50', 'The Habit Group', 1);

# Add Users
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (1, 'blue', null, '2018-05-09 16:32:01', 'chanel@codeup.com', null, null, '$2a$10$23qzFpzRqWC4wzFStwwR5OCTRJ0o0ON5XIiY/hE466jmX6IjuJrFq', 'Chanel', 4, 2);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (2, 'red', null, '2018-05-11 10:13:46', 'tim@othy.com', null, null, '$2a$10$lXmxjrDVNvP204D4xF9Laev6erC/HIZujmk9ROS1FSvsfGfeI2f9a', 'Timothy54', 3, 4);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (3, 'black', null, '2018-05-11 10:15:05', 'luis@codeup.com', null, null, '$2a$10$ue9onLu/28aKONc/JW7vdudwmmScP77psyyuVk7UJU4coK9X.2eQm', 'Luis', 1, 2);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (4, 'blue', null, '2018-05-11 10:16:43', 'fer@codeup.com', null, null, '$2a$10$zxo65mzysfa9I5aW2nYhF.Y3g3MUhA6mjZZu4cW1erd4CXHC0yrx6', 'Fer', 7, 2);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (5, 'black', null, '2018-05-11 10:17:25', 'justin@codeup.com', null, null, '$2a$10$gM1aHE0Ix95s1.LsS/MjGe8Ga2X4YpOv/nn4OPES8VHDaxntSX0UC', 'Justin', 2, 2);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (6, 'blue', null, '2018-05-11 10:18:15', 'ryan@codeup.com', null, null, '$2a$10$/tnb2ZjEgN/UxX53TFbY7ObnboXdDVbrgyeQYgTffRgSp5xQxvReO', 'Ryan', 8, 2);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (7, 'red', null, '2018-05-11 10:18:44', 'stephen@codeup.com', null, null, '$2a$10$P0fC3zfaFnxDx0w6k4dU5OrMEYXCMpe0JkLE2WkgxR5Y.Qh5HvDZ.', 'Stephen', 10, 2);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (8, 'blue', null, '2018-05-11 10:18:15', 'ryan2@codeup.com', null, null, '$2a$10$fNvaQt3Tv/95fqWBq2cpXe71J.Vq9SD5TEJ7P89AUGQ2XDR4BnhA.', 'Bob', 8, 1);
INSERT INTO hpg_db.users (id, avatar_color, bio, created_on, email, first_name, last_name, password, username, avatar_id, clan_id) VALUES (9, 'red', null, '2018-05-11 10:18:44', 'stephen2@codeup.com', null, null, '$2a$10$ZNvI.z/XMUOg9dct/VtJGOPsURrSPjYF3pYkIwMIeBoeC68NUnr1m', 'Douglas', 3, 1);