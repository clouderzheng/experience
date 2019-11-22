1、解压
2、配置环境变量 PATH=.......;C:\Program Files\MySQL\MySQL Server 5.6\bin
3、配置完环境变量之后先别忙着启动mysql，我们还需要修改一下配置文件（如果没有配置，之后启动的时候就会出现图中的错误哦！:错误2 系统找不到文件），mysql-5.6.1X默认的配置文件是在C:\Program Files\MySQL\MySQL Server 5.6\my-default.ini，或者自己建立一个my.ini文件，

在其中修改或添加配置（如图）： 

[mysqld] 

basedir=C:\Program Files\MySQL\MySQL Server 5.6（mysql所在目录） 

datadir=C:\Program Files\MySQL\MySQL Server 5.6\data （mysql所在目录\data）
4、以管理员身份运行cmd（一定要用管理员身份运行，不然权限不够），

输入：cd C:\Program Files\MySQL\MySQL Server 5.6\bin 进入mysql的bin文件夹(不管有没有配置过环境变量，也要进入bin文件夹，否则之后启动服务仍然会报错误2)

输入mysqld -install(如果不用管理员身份运行，将会因为权限不够而出现错误：Install/Remove of the Service Denied!) 

5、（1）如果之前装过mysql的，把mysql的server卸载掉，连带MySQL Server 5.7\data文件一起清干净

（2）重新装好后，输入net start mysql还是无法启动服务，这个时候，输入以下指令

          mysqld --remove 删除mysql服务

          mysqld --install 安装服务

          mysqld --initialize  初始化

         net  start mysql

     然后发现服务已经启动

  (3)输入mysql -u root -p 启动mysql ，然后会要求你输入密码，注意由于是初始化的，所以系统自动配置一个初始化密码，这个密码在哪里找到呢？在MySQL Server 5.7.2\data这个路径下有一个计算机名字加err的文件，这个文件是错误日志，打开它，找到一个temporary password的记录条，冒号后面的就是初始化密码了（包括分号坑！！！！！！）。

  （4）输入初始化密码以后，修改密码，输入指令 alter user  'root'@'localhost' identified by '密码'；就能修改成功了。
  
  
修改数据库密码方式 
方法1： 用SET PASSWORD命令   

首先登录MySQL。  

格式：mysql> set password for 用户名@localhost = password('新密码');  

例子：mysql> set password for root@localhost = password('123');  


方法3：用UPDATE直接编辑user表   

首先登录MySQL。  

mysql> use mysql;  

mysql> update user set password=password('123') where user='root' and host='localhost';  

mysql> flush privileges;  
此时有个问题  登录时提示密码错误，安装的时候并没有更改密码，后来通过免密码登录的方式更改密码，输入update mysql.user  set password=password('root') where user='root'时提示ERROR 1054 (42S22): Unknown column 'password' in 'field list'，原来是mysql数据库下已经没有password这个字段了，password字段改成了
authentication_string
所以更改语句替换为update mysql.user set authentication_string=password('111') where user='root' ;即可
 
 
 
 方法4：在忘记root密码的时候，可以这样   

以windows为例：   

1. 关闭正在运行的MySQL服务。  

2. 打开DOS窗口，转到mysql\bin目录。  

3. 输入mysqld --skip-grant-tables 回车。--skip-grant-tables 的意思是启动MySQL服务的时候跳过权限表认证。  

--------------------------------------------------------------------------------------------------------

此时有个问题  此方案未测试
登录mysql数据库的时候出现 :

ERROR 1045 (28000): Access denied for user 'ODBC'@'localhost'(using password: NO)

ERROR 1045 (28000): Access denied for user 'ODBC'@'localhost'(using password: YES)

windows下，以上两个错误的解决方法,以及出现 “发生系统错误 5。拒绝访问”

处理方法;  (ps:本人亲自测试)

1.     在安装mysql的文件目录中找到配置文件my.ini  ，然后右击用记事本打开,



2.     打开后，搜索mysqld关键字

找到后，在mysqld下面添加skip-grant-tables，保存退出。

PS：若提示不让保存时，可以将该文件剪切到桌面，更改保存后再复制到mySQL目录下



3.        保存后重启mySQL,

先要检查mysql服务有没有启动.

启动mysql服务,


--------------------------------------------------------------------------------------------------------
4. 再开一个DOS窗口（因为刚才那个DOS窗口已经不能动了），转到mysql\bin目录。  

5. 输入mysql回车，如果成功，将出现MySQL提示符 >。  

6. 连接权限数据库： use mysql; 。  

6. 改密码：update user set password=password("123") where user="root";（别忘了最后加分号） 。  

7. 刷新权限（必须步骤）：flush privileges;　。  

8. 退出 quit。  













Mysql 锁
mysql的锁类型
1、共享锁与排她锁是innodb引擎实现的标准行级锁
共享锁是为了让当前事物去读一行数据
排它锁是为了让当前事物去修改或者删除一行数据
设置共享锁。 select * from table where id - 1 lock in share mode;
设置排它锁。select * from table where id =1 for update
2、意向锁
意向锁存在的意义在于，使得行锁与表锁能够共存、
意向锁是表级别的锁，用来说明事务稍后会对表中的数据行加哪种类型的锁 共享锁或者独占锁
当一个事务对表加了意向排它锁时，另一个事务在加锁前就会通过该表的意向排它锁知道前面已经有事务对该表进行独占操作，从而等待
3、记录锁
记录锁时索引记录上的锁 例如： select id from table where id =10 for update 会阻止其他事务对id=10的数据行进行插入，更新，删除等操作
记录锁总是锁定索引记录。如果一个表没有定义索引，那么就会去锁定隐式的聚集索引
聚集索引。mysql。innodb默认主键使用聚簇索引，索引直接指向数据块。 非聚簇索引叶子节点指向聚簇索引，再通过聚簇索引查找数据块
覆盖索引，也叫联合索引，此时不走聚簇索引，索引与数据块在一块






mysql ate和datetime、timestamp 的区别
date保存精度到天，格式为：YYYY-MM-DD，如2016-11-07
datetime和timestamp精度保存到秒，格式为：YYYY-MM-DD HH:MM:SS,如：2016-11-07 10:58:27
因此如果只需保存到天的字段（如生日）用date就可以了。
datetime 和timestamp
两者都是时间类型字段，格式都一致。两者主要有以下几点区别：
datatime设置的是什么时间就是什么时间；timestamp则是把客户端插入的时间从当前时区转化为UTC（世界标准时间）进行存储。查询时，将其又转化为客户端当前时区进行返回。  

占用存储空间不同。timestamp储存占用4个字节，datetime储存占用8个字节。

可表示的时间范围不同。timestamp可表示范围:1970-01-01 00:00:00~2038-01-09 03:14:07，datetime支持的范围更宽1000-01-01 00:00:00 ~ 9999-12-31 23:59:59

索引速度不同。timestamp更轻量，索引相对datetime更快。

另外说一句，Mybatis会自动把Date类型的参数转换成Timestamp类型的参数（如果不指定jdbcType类型）。

