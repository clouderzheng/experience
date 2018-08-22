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


