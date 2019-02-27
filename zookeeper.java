wget http://www.apache.org/dist/zookeeper/zookeeper-3.4.13/



安装jdk

 tar -zxvf jdk-8u171-linux-x64.tar.gz -C /usr/local/jdk1.8/  解压文件
设置环境变量


[root@localhost software]# vim /etc/profile

执行profile文件

[root@localhost software]# source /etc/profile

检查新安装的jdk

[root@localhost software]# java -version
显示：

java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)

/usr/local/jdk1.8/jdk1.8.0_171