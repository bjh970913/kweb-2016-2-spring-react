INSERT INTO `role` VALUES (1, 'ROLE_USER');
INSERT INTO `role` VALUES (2, 'ROLE_ADMIN');

INSERT INTO `user` VALUES (1, 'admin@kweb.com',
                           '8b9c0ac6e5250ff2e6f5cc70d498f3094a72846110bfc91a1734b76634691da2d55acf756893f8d1090dd194251e4af87e9b261a43ade9561bd3487b42a58cb9');
INSERT INTO `user` VALUES (2, 'user@kweb.com',
                           '8b9c0ac6e5250ff2e6f5cc70d498f3094a72846110bfc91a1734b76634691da2d55acf756893f8d1090dd194251e4af87e9b261a43ade9561bd3487b42a58cb9');

INSERT INTO `user_user_roles` VALUES (1, 1);
INSERT INTO `user_user_roles` VALUES (1, 2);

INSERT INTO `user_user_roles` VALUES (2, 1);

INSERT INTO `board` VALUES (1, 'basic');
INSERT INTO `board` VALUES (2, 'info');
INSERT INTO `board` VALUES (3, 'etc');
