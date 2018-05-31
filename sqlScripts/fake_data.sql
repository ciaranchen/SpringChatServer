-- chat setting
insert into chat_settings values (1);

-- chat users
insert into chat_users(username, password, setting) values ('ciaran', 'ciaran', 1);
insert into chat_users(username, password, setting) values ('user2', 'pass2', 1);
insert into chat_users(username, password, setting) values ('user3', 'pass3', 1);
insert into chat_users(username, password, setting) values ('user4', 'pass4', 1);
insert into chat_users(username, password, setting) values ('user5', 'pass5', 1);
insert into chat_users(username, password, setting) values ('user6', 'pass6', 1);
insert into chat_users(username, password, setting) values ('user7', 'pass7', 1);
insert into chat_users(username, password, setting) values ('user8', 'pass8', 1);
insert into chat_users(username, password, setting) values ('user9', 'pass9', 1);
insert into chat_users(username, password, setting) values ('user10', 'pass10', 1);
insert into chat_users(username, password, setting) values ('user11', 'pass11', 1);
update chat_users set avatar='ciaran.jpg' where username='ciaran';

-- chat rooms
insert into chat_rooms(name, owner) values ("Ciaran's room", 1);
insert into chat_rooms(name, owner) values ('Without Ciaran', 2);

-- room user
insert into room_user(room, user) values (1, 1);
insert into room_user(room, user) values (1, 2);
insert into room_user(room, user) values (1, 3);
insert into room_user(room, user) values (1, 4);
insert into room_user(room, user) values (1, 5);
insert into room_user(room, user) values (1, 6);
insert into room_user(room, user) values (1, 7);
insert into room_user(room, user) values (1, 8);
insert into room_user(room, user) values (1, 9);
insert into room_user(room, user) values (1, 10);
insert into room_user(room, user) values (1, 11);
insert into room_user(room, user) values (2, 2);
insert into room_user(room, user) values (2, 3);
insert into room_user(room, user) values (2, 4);
insert into room_user(room, user) values (2, 5);
insert into room_user(room, user) values (2, 6);
insert into room_user(room, user) values (2, 7);
insert into room_user(room, user) values (2, 8);
insert into room_user(room, user) values (2, 9);
insert into room_user(room, user) values (2, 10);
insert into room_user(room, user) values (2, 11);

-- double chat (friend relationship)
insert into double_chats(user1, user2) values (1, 2);
insert into double_chats(user1, user2) values (1, 4);
insert into double_chats(user1, user2) values (1, 6);
insert into double_chats(user1, user2) values (1, 8);
insert into double_chats(user1, user2) values (2, 3);
insert into double_chats(user1, user2) values (4, 5);
insert into double_chats(user1, user2) values (6, 7);
insert into double_chats(user1, user2) values (8, 9);

-- room chat record
insert into records_room(room, user, msg, stamp) values(1, 2, '请客请客', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:21:29.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '别啊', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:23:37.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '等我回去', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:23:39.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '等我回去  再大宴天下', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:24:07.0"));
insert into records_room(room, user, msg, stamp) values(1, 4, '你不还有一顿', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:24:35.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '我没了', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:24:42.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '我请过了', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:24:46.0"));
insert into records_room(room, user, msg, stamp) values(1, 4, '请您看下 Web大作业的群名', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:25:18.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '他说了不算', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:25:43.0"));
insert into records_room(room, user, msg, stamp) values(1, 5, '啥好事？', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:26:54.0"));
insert into records_room(room, user, msg, stamp) values(1, 4, '实习offer', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:27:14.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '鹅厂大佬', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:27:19.0"));
insert into records_room(room, user, msg, stamp) values(1, 6, 'orz', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:27:59.0"));
insert into records_room(room, user, msg, stamp) values(1, 6, '大佬大佬', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:28:07.0"));
insert into records_room(room, user, msg, stamp) values(1, 4, '在我面中科院自动化所面了一半的时候', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:28:14.0"));
insert into records_room(room, user, msg, stamp) values(1, 7, '恭喜啊，请客吧', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:36:38.0"));
insert into records_room(room, user, msg, stamp) values(1, 8, '恭喜啊，请客吧', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:36:48.0"));
insert into records_room(room, user, msg, stamp) values(1, 9, '恭喜啊，请客吧', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:37:29.0"));
insert into records_room(room, user, msg, stamp) values(1, 3, '恭喜啊，请客吧', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:43:33.0"));
insert into records_room(room, user, msg, stamp) values(1, 4, '恭喜啊，请客吧', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:44:02.0"));
insert into records_room(room, user, msg, stamp) values(1, 7, '哪有自己恭喜自己的', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:45:21.0"));
insert into records_room(room, user, msg, stamp) values(1, 6, '说明他要请客', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:45:47.0"));
insert into records_room(room, user, msg, stamp) values(1, 1, '请客吧还有什么好说的', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:46:06.0"));
insert into records_room(room, user, msg, stamp) values(1, 7, '今晚注意安全啊', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:47:06.0"));
insert into records_room(room, user, msg, stamp) values(1, 4, '我今晚在吉祥村怕啥', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-04-27 20:48:16.0"));

-- double chat record
insert into records_double(channel, sender, msg, stamp) values(3, 6, '咱们现在是不是还空一个位置？', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:19:13.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 1, '。。。', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:19:20.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 1, '不是妹子不要', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:19:25.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 6, '哦', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:19:51.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 6, '我不管', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:19:54.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 6, '我是pm', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:19:57.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 1, '。。。', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:20:06.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 1, '我是HR', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:20:12.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 1, '2333333', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:20:14.0"));
insert into records_double(channel, sender, msg, stamp) values(3, 6, '哦', strftime("%Y-%m-%d %H:%M:%S.%f", "2018-05-04 14:20:15.0"));
