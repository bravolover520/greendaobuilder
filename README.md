##使用说明

=====

###使用
1、创建java-gen文件夹（存放自动生成的dao,session,bean）;配置build.gradle.

2、greendaogenerator module中 run main() 执行自动生成.

3、继承DbService实现MsgService;并且在DbHelper中实例化对外开放的实例.

4、在Application中.init()数据库.

5、若要更新数据库更改UpdateDevOpenHelper类的onUpdate().

6、调用关键方法

```java
private IDbService service;
``` 

```java
Msg msg = new Msg();
msg.setText("消息体");
msg.setDate(new Date());
msg.setStatus((byte)1);

service = DbHelper.getInstance().getMsgService();
service.save(msg);
```

###帮助
- [官网说明](http://greenrobot.org/greendao/documentation/)
- [项目源码](https://github.com/greenrobot/greenDAO)
- [搭建引导](http://www.open-open.com/lib/view/open1438065400878.html)
- [Database Encryption 从2.2版本之后支持数据库加密](http://greenrobot.org/greendao/documentation/database-encryption/)
