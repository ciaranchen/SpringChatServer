# JavaChatServer

SSM 框架 Java聊天室 后端。

数据库使用 Sqlite

## 如何开始

通过使用`sqlScripts`文件夹下的脚本`create_tables.sql`创建数据库

```shell
sqlite3 src/main/resources/chatdb.db < sqlScripts/create_tables.sql
python3 sqlScripts/fake_data.py > sqlScripts/fake_data.sql
sqlite3 src/main/resources/chatdb.db < sqlScripts/fake_data.sql
```

## 使用gradle来启动项目

	推荐直接使用idea打开`build.gradle`

参见 [这篇文章](http://www.cnblogs.com/davenkin/p/gradle-spring-boot.html)

## 清空数据库

通过使用`sqlScripts`文件夹下的脚本`drop_tables.sql`清空数据库

```shell
sqlite3 src/main/resources/chatdb.db < sqlScripts/drop_tables.sql
```

## 实现内容

## 一些说明

如果您不想花费时间阅读一些臃肿代码的话，你最好阅读以下文档：

本项目存在API文档：在根目录下的`api.md`

本项目的问题和思考集: 根目录下的`note.md`
