1. 前往https://maven.apache.org/download.cgi下载最新版的Maven程序：、
2. 将文件解压到D:\Program Files\Apache\maven目录下:
3. 新建环境变量MAVEN_HOME，赋值D:\Program Files\Apache\maven
4. 编辑环境变量Path，追加%MAVEN_HOME%\bin\;
5. 至此，maven已经完成了安装，我们可以通过DOS命令检查一下我们是否安装成功：
三、配置Maven本地仓库

1. 在D:\Program Files\Apache\目录下新建maven-repository文件夹，该目录用作maven的本地库。

2. 打开D:\Program Files\Apache\maven\conf\settings.xml文件，查找下面这行代码：

<localRepository>/path/to/local/repo</localRepository>
localRepository节点默认是被注释掉的，需要把它移到注释之外，然后将localRepository节点的值改为我们在3.1中创建的目录D:\Program Files\Apache\maven-repository。

3. localRepository节点用于配置本地仓库，本地仓库其实起到了一个缓存的作用，它的默认地址是 C:\Users\用户名.m2。

当我们从maven中获取jar包的时候，maven首先会在本地仓库中查找，如果本地仓库有则返回；如果没有则从远程仓库中获取包，并在本地库中保存。

此外，我们在maven项目中运行mvn install，项目将会自动打包并安装到本地仓库中。

4. 运行一下DOS命令

mvn help:system

四、配置Eclipse的Maven环境

1. Eclipse Oxygen，打开Window->Preferences->Maven->Installations，右侧点击Add。

