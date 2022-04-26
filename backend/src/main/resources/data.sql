INSERT INTO tb_user (name, email, password) VALUES ('User', 'user@gmail.com', '$2a$10$XrROko3sahrL28vmWKKWNOXewRoNPW..iAq02QWL0jeDOo24Lw.sO');
INSERT INTO tb_user (name, email, password) VALUES ('Admin', 'admin@gmail.com', '$2a$10$XrROko3sahrL28vmWKKWNOXewRoNPW..iAq02QWL0jeDOo24Lw.sO');

INSERT INTO tb_role (role_name) VALUES ('ROLE_USER');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);