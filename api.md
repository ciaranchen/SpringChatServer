## 用户相关API

### 1. 用户验证

#### 接口功能

> 从用户名密码获得user_id

#### URL

> [/http/user/login](127.0.0.1:8080/http/user/login)

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

> [http://127.0.0.1:8080/http/user/relationship](127.0.0.1:8080/http/user/relationship)

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






## 私聊相关API

### 1. 发送消息

#### 接口功能

> 用户发送消息

#### WebSocket地址

> [](127.0.0.1:8080/index.php)

#### 支持格式

> STOMP

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|From    |ture |long  | 消息发送者的user_id |
|To      |true |long  | 消息接收者的user_id |
|Content |ture |string| 发送的消息 |

#### JS示例

> 地址：[http://127.0.0.1:8080/index.php?name=可口可乐&type=1](http://127.0.0.1:8080/index.php?name=可口可乐&type=1)

    {
        "state": 0,
        "company": "可口可乐",
        "category": "饮料"
    }

### 2. 接受私聊消息

#### 接口功能

> 用户接受私聊消息

#### WebSocket地址

> [](127.0.0.1:8080/index.php)

#### 支持格式

> STOMP

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|From    |ture |long  | 消息发送者的user_id |
|To      |true |long  | 消息接收者的user_id |
|Content |ture |string| 发送的消息 |

#### JS示例

> 地址：[http://127.0.0.1:8080/index.php?name=可口可乐&type=1](http://127.0.0.1:8080/index.php?name=可口可乐&type=1)

    {
        "state": 0,
        "company": "可口可乐",
        "category": "饮料"
    }



## 群聊相关API



