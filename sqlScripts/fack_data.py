# coding: utf-8

# how to use: `python3 fack_data.py > fack_data.sql`

def fack_double_chat(filename):
    pass


def fack_room_chat(filename):
    pass


if __name__ == "__main__":
    print("-- chat setting\ninsert into chat_settings values (1);")

    print("\n-- chat users")
    print("insert into chat_users(username, passwd, setting) values ('ciaran', 'ciaran', 1);")
    temp = "insert into chat_users(username, passwd, setting) values ('user{0}', 'pass{0}', 1);"
    for i in range(10):
        print(temp.format(i+2))

    # chat room
    s = """\n-- chat rooms
insert into chat_rooms(name, owner) values ("Ciaran's room", 1);
insert into chat_rooms(name, owner) values ('Without Ciaran', 2);"""
    print(s)


    # room user part
    print("\n-- room user")
    temp1 = "insert into room_user(room, user) values (1, {0});"
    for i in range(11):
        print(temp1.format(i+1))
    temp2 = "insert into room_user(room, user) values (2, {0});"
    for i in range(10):
        print(temp2.format(i+2))

    # double chat
    print("\n-- double chat (friend relationship)")
    temp = "insert into double_chats(user1, user2) values ({0}, {1});"
    for i in range(5):
        print(temp.format(1, (i+1)*2))
        print(temp.format((i+1)*2, 1))

    # fack chating data

