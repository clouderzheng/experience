[root@iz2ze61hopefmmx93i3uvwz ~]# vi /etc/ssh/sshd_config 
/root
yes ---> no
[root@iz2ze61hopefmmx93i3uvwz ~]# service sshd restart
Redirecting to /bin/systemctl restart sshd.service
[root@iz2ze61hopefmmx93i3uvwz ~]# useradd night
[root@iz2ze61hopefmmx93i3uvwz ~]# passwd night
passwd 199466

60.205.221.223

root  Yun13350865639



sz安装 

1）编译安装
root 账号登陆后，依次执行以下命令：
cd /tmp
wget http://www.ohse.de/uwe/releases/lrzsz-0.12.20.tar.gz
tar zxvf lrzsz-0.12.20.tar.gz && cd lrzsz-0.12.20
./configure && make && make install
上面安装过程默认把lsz和lrz安装到了/usr/local/bin/目录下，现在我们并不能直接使用，下面创建软链接，并命名为rz/sz：
cd /usr/bin
ln -s /usr/local/bin/lrz rz
ln -s /usr/local/bin/lsz sz

授权   chmod 777  shutdown.sh 