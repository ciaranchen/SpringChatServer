# coding: utf-8
# how to use: `python3 fack_data.py > fack_data.sql`

import os

basedir = os.path.abspath(os.path.dirname(__file__))
print('basedir: ' + basedir)
object_file = os.path.join(basedir, 'fake_data.sql')
print('write to: ' + object_file)
fw = open(object_file, 'w')


def fprint(*args, **kwargs):
    print(*args, file=fw, **kwargs)


def fake_double_record(filename, cid, ulist):
    print("reading: " + filename)
    lines = open(filename).readlines()
    record_template = "insert into records_double(channel, sender, msg, stamp) values({0}, {1}, '{2}', {3});"
    for u, t, c in zip(lines[0::3], lines[1::3], lines[2::3]):
        uid = ulist.index(u[:-1]) + 1
        stamp = 'datetime(\'' + t[:-1] + '\')'
        fprint(record_template.format(cid, uid, c[:-1], stamp))



def fake_room_record(filename, ulist):
    print("reading: " + filename)
    lines = open(filename).readlines()
    record_template = "insert into records_room(room, user, msg, stamp) values({0}, {1}, '{2}', {3});"
    for u, t, c in zip(lines[0::3], lines[1::3], lines[2::3]):
        stamp = 'datetime(\'' + t[:-1] + '\')'
        u_idx = ulist.index(u[:-1]) + 1
        room = 1
        fprint(record_template.format(room, u_idx, c[:-1], stamp))



if __name__ == "__main__":
    fprint("-- chat setting\ninsert into chat_settings values (1);")

    usr_list = ['ciaran'] + ['user' + str(i+2) for i in range(10)]
    psw_list = ['ciaran'] + ['pass' + str(i+2) for i in range(10)]

    fprint("\n-- chat users")
    temp = "insert into chat_users(username, password, setting) values ('{0}', '{1}', 1);"
    for u, p in zip(usr_list, psw_list):
        fprint(temp.format(u, p))

    # chat room
    s = """\n-- chat rooms
insert into chat_rooms(name, owner) values ("Ciaran's room", 1);
insert into chat_rooms(name, owner) values ('Without Ciaran', 2);"""
    fprint(s)


    # room user part
    fprint("\n-- room user")
    temp1 = "insert into room_user(room, user) values (1, {0});"
    for i in range(11):
        fprint(temp1.format(i+1))
    temp2 = "insert into room_user(room, user) values (2, {0});"
    for i in range(10):
        fprint(temp2.format(i+2))

    # double chat
    fprint("\n-- double chat (friend relationship)")
    temp = "insert into double_chats(user1, user2) values ({0}, {1});"
    for i in range(5):
        fprint(temp.format(1, (i+1)*2))
    for i in range(5):
        fprint(temp.format((i+1)*2, i*2+3))

    # fake chatting data
    fprint("\n-- room chat record")
    filename = os.path.join(basedir, 'room_records.txt')
    fake_room_record(filename, usr_list)

    fprint("\n-- double chat record")
    filename = os.path.join(basedir, 'double_records.txt')
    fake_double_record(filename, 3, usr_list)

