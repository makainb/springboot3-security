INSERT INTO t_authorities(authority) VALUES('ROLE_USER');
INSERT INTO t_authorities(authority) VALUES('ROLE_ADMIN');
INSERT INTO t_authorities(authority) VALUES('ROLE_DEVELOPER');

-- 密码是 password
INSERT INTO t_user(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES ('zhangsan', '{bcrypt}$2a$12$2yOChyhSuJm/naTBUjGZb.6d6mu1NsXS8XWRFousQfRTwzy0ZQtWW'
       , true, true, true, true);
INSERT INTO t_user(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES ('admin', '{bcrypt}$2a$12$2yOChyhSuJm/naTBUjGZb.6d6mu1NsXS8XWRFousQfRTwzy0ZQtWW'
       , true, true, true, true);
INSERT INTO t_user(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES ('makai', '{bcrypt}$2a$12$2yOChyhSuJm/naTBUjGZb.6d6mu1NsXS8XWRFousQfRTwzy0ZQtWW',
        true, true, true, true);

INSERT INTO t_user_authorities(user_id, authorities_id) VALUES (1, 1);
INSERT INTO t_user_authorities(user_id, authorities_id) VALUES (1, 2);
INSERT INTO t_user_authorities(user_id, authorities_id) VALUES (1, 3);
INSERT INTO t_user_authorities(user_id, authorities_id) VALUES (2, 1);
INSERT INTO t_user_authorities(user_id, authorities_id) VALUES (2, 2);
INSERT INTO t_user_authorities(user_id, authorities_id) VALUES (3, 1);