## WebSocket相关

### WebSocket连接

#### URL

> [ws://localhost:8080/ws](ws://localhost:8080/ws)

#### JS 示例

``` JavaScript
let wsUri = "ws://localhost:8080/ws";
stomp = Stomp.client(wsUri);
stomp.connect(headers, passcode, callback);
```

## 用户相关API

### 1. 用户验证

#### 接口功能

> 从用户名密码获得user_id

#### URL

> [http://127.0.0.1:8080/http/user/login](http://127.0.0.1:8080/http/user/login)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|username |true |string | 用户名 |
|password |ture |string | 密码 |

#### 返回字段

    直接返回用户的`user_id`

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/user/login?username=ciaran&password=ciaran](http://127.0.0.1:8080/http/user/login?username=ciaran&password=ciaran)

    1

### 2. 获取用户私聊情况

#### 接口功能

> 从用户名user_id获得私聊对话的用户名和user_id

#### URL

> [http://127.0.0.1:8080/http/user/relationship](http://127.0.0.1:8080/http/user/relationship)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|user |true |Long | 用户名 |

#### 返回字段

返回用户好友的`user_id`和`username`
用JSON标识的列表，表中的每个元素具有以下属性

|属性名|类型|说明|
|:----- |:-------|----- |
|id |Long | 该用户的user_id |
|username |String | 该用户的用户名 |

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/user/relationship?user=1](http://127.0.0.1:8080/http/user/relationship?user=1)

    [{"id":2,"username":"user2"},{"id":4,"username":"user4"},{"id":6,"username":"user6"},{"id":8,"username":"user8"},{"id":10,"username":"user10"}]

### 3. 获取用户群聊情况

#### 接口功能

> 从用户名user_id获得群聊对话的房间名和房间id

#### URL

> [http://127.0.0.1:8080/http/user/room](http://127.0.0.1:8080/http/user/room)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|user |true |Long | 用户的 user_id |

#### 返回字段

返回所在聊天室的`user_id`和`username`
用JSON标识的列表，表中的每个元素具有以下属性

|属性名|类型|说明|
|:----- |:-------|----- |
|id |Long | 该用户的user_id |
|username |String | 该用户的用户名 |

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/user/relationship?user=1](http://127.0.0.1:8080/http/user/relationship?user=1)

    [{"id":2,"username":"user2"},{"id":4,"username":"user4"},{"id":6,"username":"user6"},{"id":8,"username":"user8"},{"id":10,"username":"user10"}]


## 私聊相关API

### 1. 发送消息

#### 接口功能

> 用户发送消息

#### URL

> [ws://127.0.0.1:8080/ws/double/send](ws://127.0.0.1:8080/ws/double/send)

#### 支持格式

> STOMP

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|channel  |true |Long  | 私聊的channel的channel_id  |
|sender   |true |Long  | 消息发送者的user_id        |
|to       |true |Long  | 消息接收者的user_id        |
|msg      |true |string| 发送的消息                 |

#### JS示例

``` JavaScript
// after connected.
stomp.send("/double/send", {}, JSON.stringify({'channel': 3, 'sender': 1, 'to': 6, 'msg': "qwertasdfg"}));
```

### 2. 接受私聊消息

#### 接口功能

> 用户接受私聊消息

#### WebSocket地址

> [ws://127.0.0.1:8080/ws/double/send/{user_id}](ws://127.0.0.1:8080/ws/double/send/{user_id})

#### 返回参数

|参数|类型|说明|
|:----- |:-----|----- |
|channel    |long  | 消息发送者的user_id |
|sender     |long  | 消息接收者的user_id |
|msg        |string| 发送的消息 |

#### JS示例

``` JavaScript
// after connected
stomp.subscribe('/double/recv/6', function (g) {
	// do something with g.body
});
```

### 3. 查询记录

#### 接口功能

> 查询用户的聊天记录

#### URL

> [http://127.0.0.1:8080/http/double/record](http://127.0.0.1:8080/http/double/record)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|user |true |Long | 用户私聊的 channel |

#### 返回字段

用JSON标识的列表，表中的每个元素具有以下属性。

|属性名|类型|说明|
|:----- |:-------|----- |
|id       |Long | 该记录的id |
|channel  |Long | 该记录的channel id |
|sender   |Long | 该记录的发送者的user id |
|msg      |String | 这条消息的內容 |
|stamp    |Date | 这条消息的发送时间 |

> 列表的长度最长为20

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/double/record?cid=3](http://127.0.0.1:8080/http/double/record?cid=3)

    [{"id":10,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:20:15.015+0000"},{"id":9,"channel":3,"sender":1,"msg":"2333333","stamp":"2018-05-04T06:20:14.014+0000"},{"id":8,"channel":3,"sender":1,"msg":"我是HR","stamp":"2018-05-04T06:20:12.012+0000"},{"id":7,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:20:06.006+0000"},{"id":6,"channel":3,"sender":6,"msg":"我是pm","stamp":"2018-05-04T06:19:57.057+0000"},{"id":5,"channel":3,"sender":6,"msg":"我不管","stamp":"2018-05-04T06:19:54.054+0000"},{"id":4,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:19:51.051+0000"},{"id":3,"channel":3,"sender":1,"msg":"不是妹子不要","stamp":"2018-05-04T06:19:25.025+0000"},{"id":2,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:19:20.020+0000"},{"id":1,"channel":3,"sender":6,"msg":"咱们现在是不是还空一个位置？","stamp":"2018-05-04T06:19:13.013+0000"}]

### 4. 偏移的查询记录

#### 接口功能

> 带偏移地查询用户的聊天记录（用于加载不同时期的聊天记录）

#### URL

> [http://127.0.0.1:8080/http/double/record_offset](http://127.0.0.1:8080/http/double/record_offset)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|user   |true |Long | 用户私聊的 channel |
|offset |true |Long | 偏移聊天记录距离最新的聊天记录的条数 |

#### 返回字段

用JSON标识的列表，表中的每个元素具有以下属性

|属性名|类型|说明|
|:----- |:-------|----- |
|id       |Long | 该记录的id |
|channel  |Long | 该记录的channel id |
|sender   |Long | 该记录的发送者的user id |
|msg      |String | 这条消息的內容 |
|stamp    |Date | 这条消息的发送时间 |

> 列表的长度最长为20

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/double/record_offset?cid=3&offset=5](http://127.0.0.1:8080/http/double/record_offset?cid=3&offset=5)

    [{"id":10,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:20:15.015+0000"},{"id":9,"channel":3,"sender":1,"msg":"2333333","stamp":"2018-05-04T06:20:14.014+0000"},{"id":8,"channel":3,"sender":1,"msg":"我是HR","stamp":"2018-05-04T06:20:12.012+0000"},{"id":7,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:20:06.006+0000"},{"id":6,"channel":3,"sender":6,"msg":"我是pm","stamp":"2018-05-04T06:19:57.057+0000"},{"id":5,"channel":3,"sender":6,"msg":"我不管","stamp":"2018-05-04T06:19:54.054+0000"},{"id":4,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:19:51.051+0000"},{"id":3,"channel":3,"sender":1,"msg":"不是妹子不要","stamp":"2018-05-04T06:19:25.025+0000"},{"id":2,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:19:20.020+0000"},{"id":1,"channel":3,"sender":6,"msg":"咱们现在是不是还空一个位置？","stamp":"2018-05-04T06:19:13.013+0000"}]

### 5. 添加用户

#### 接口功能

> 添加两个用户之间的私聊（好友）关系

#### URL

> [http://127.0.0.1:8080/http/double/add](http://127.0.0.1:8080/http/double/add)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|user   |true |Long | 用户1的user id |
|friend |true |Long | 用户2的user id |

#### 返回字段

返回新增的关系的channel的id

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/double/add?user=1&friend=7](http://127.0.0.1:8080/http/double/add?user=1&friend=7)

    11

## 群聊相关API

### 1. 发送群聊消息

#### 接口功能

> 用户发送消息

#### URL

> [ws://127.0.0.1:8080/ws/room/send](ws://127.0.0.1:8080/ws/room/send)

#### 支持格式

> STOMP

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|room   |true |Long  | 房间的room_id            |
|user   |true |Long  | 消息发送者的user_id       |
|msg    |true |string| 发送的消息                |

#### JS示例

``` JavaScript
// after connected.
stomp.send("/room/send", {}, JSON.stringify({'room': 1, 'user': 1, msg: 'something in the room'}));
```

### 2. 接受群聊消息

#### 接口功能

> 用户接受私聊消息

#### WebSocket地址

> [ws://127.0.0.1:8080/ws/double/room/{room_id}](ws://127.0.0.1:8080/ws/double/room/{room_id})

#### 返回参数

|参数|类型|说明|
|:----- |:-----|----- |
|room       |long   | 房间的room_id         |
|user       |long   | 消息发送者的user_id    |
|msg        |string | 发送的消息             |
|stamp      |Date   | 消息发送的时间         |

#### JS示例

``` JavaScript
// after connected
stomp.subscribe('/room/recv/1', function (g) {
	// do something with g.body
});
```

### 3. 查询记录

#### 接口功能

> 查询用户的聊天记录

#### URL

> [http://127.0.0.1:8080/http/room/record](http://127.0.0.1:8080/http/room/record)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|room |true |Long | 房间的room_id  |

#### 返回字段

用JSON标识的列表，表中的每个元素具有以下属性。

|属性名|类型|说明|
|:----- |:-----|----- |
|room       |long   | 房间的room_id         |
|user       |long   | 消息发送者的user_id   |
|msg        |string | 发送的消息            |
|stamp      |Date   | 消息发送的时间        |

> 列表的长度最长为20

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/double/record?cid=3](http://127.0.0.1:8080/http/double/record?cid=3)

    [{"id":10,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:20:15.015+0000"},{"id":9,"channel":3,"sender":1,"msg":"2333333","stamp":"2018-05-04T06:20:14.014+0000"},{"id":8,"channel":3,"sender":1,"msg":"我是HR","stamp":"2018-05-04T06:20:12.012+0000"},{"id":7,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:20:06.006+0000"},{"id":6,"channel":3,"sender":6,"msg":"我是pm","stamp":"2018-05-04T06:19:57.057+0000"},{"id":5,"channel":3,"sender":6,"msg":"我不管","stamp":"2018-05-04T06:19:54.054+0000"},{"id":4,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:19:51.051+0000"},{"id":3,"channel":3,"sender":1,"msg":"不是妹子不要","stamp":"2018-05-04T06:19:25.025+0000"},{"id":2,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:19:20.020+0000"},{"id":1,"channel":3,"sender":6,"msg":"咱们现在是不是还空一个位置？","stamp":"2018-05-04T06:19:13.013+0000"}]

### 4. 偏移的查询记录

#### 接口功能

> 带偏移地查询用户的聊天记录（用于加载不同时期的聊天记录）

#### URL

> [http://127.0.0.1:8080/http/room/record_offset](http://127.0.0.1:8080/http/room/record_offset)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|user   |true |Long | 用户私聊的 channel |
|offset |true |Long | 偏移聊天记录距离最新的聊天记录的条数 |

#### 返回字段

用JSON标识的列表，表中的每个元素具有以下属性

|属性名|类型|说明|
|:----- |:-------|----- |
|id       |Long     | 该记录的id |
|channel  |Long     | 该记录的channel id |
|sender   |Long     | 该记录的发送者的user id |
|msg      |String   | 这条消息的內容 |
|stamp    |Date     | 这条消息的发送时间 |

> 列表的长度最长为20

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/double/record_offset?cid=3&offset=5](http://127.0.0.1:8080/http/double/record_offset?cid=3&offset=5)

    [{"id":10,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:20:15.015+0000"},{"id":9,"channel":3,"sender":1,"msg":"2333333","stamp":"2018-05-04T06:20:14.014+0000"},{"id":8,"channel":3,"sender":1,"msg":"我是HR","stamp":"2018-05-04T06:20:12.012+0000"},{"id":7,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:20:06.006+0000"},{"id":6,"channel":3,"sender":6,"msg":"我是pm","stamp":"2018-05-04T06:19:57.057+0000"},{"id":5,"channel":3,"sender":6,"msg":"我不管","stamp":"2018-05-04T06:19:54.054+0000"},{"id":4,"channel":3,"sender":6,"msg":"哦","stamp":"2018-05-04T06:19:51.051+0000"},{"id":3,"channel":3,"sender":1,"msg":"不是妹子不要","stamp":"2018-05-04T06:19:25.025+0000"},{"id":2,"channel":3,"sender":1,"msg":"。。。","stamp":"2018-05-04T06:19:20.020+0000"},{"id":1,"channel":3,"sender":6,"msg":"咱们现在是不是还空一个位置？","stamp":"2018-05-04T06:19:13.013+0000"}]

### 5. 添加用户

#### 接口功能

> 添加两个用户之间的私聊（好友）关系

#### URL

> [http://127.0.0.1:8080/http/double/add](http://127.0.0.1:8080/http/double/add)

#### HTTP请求方式

> GET

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|user   |true |Long | 用户1的user id |
|friend |true |Long | 用户2的user id |

#### 返回字段

返回新增的关系的channel的id

#### 接口示例

> 地址：[http://127.0.0.1:8080/http/double/add?user=1&friend=7](http://127.0.0.1:8080/http/double/add?user=1&friend=7)

    11


