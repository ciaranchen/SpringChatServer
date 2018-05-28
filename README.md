# JavaChatServer

SSM 框架 Java聊天后端

数据库使用 Sqlite

## 如何开始

通过使用`sqlScripts`文件夹下的脚本`create_tables.sql`创建数据库

```shell
sqlite3 src/main/resources/chatdb.db < sqlScripts/create_tables.sql
python3 sqlScripts/fack_data.py > sqlScripts/fack_data.sql
sqlite3 src/main/resources/chatdb.db < sqlScripts/fack_data.sql
```

## 使用gradle来启动项目



## 清空数据库

通过使用`sqlScripts`文件夹下的脚本`drop_tables.sql`清空数据库

