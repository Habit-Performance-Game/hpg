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
