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



sz��װ 

1�����밲װ
root �˺ŵ�½������ִ���������
cd /tmp
wget http://www.ohse.de/uwe/releases/lrzsz-0.12.20.tar.gz
tar zxvf lrzsz-0.12.20.tar.gz && cd lrzsz-0.12.20
./configure && make && make install
���氲װ����Ĭ�ϰ�lsz��lrz��װ����/usr/local/bin/Ŀ¼�£��������ǲ�����ֱ��ʹ�ã����洴�������ӣ�������Ϊrz/sz��
cd /usr/bin
ln -s /usr/local/bin/lrz rz
ln -s /usr/local/bin/lsz sz

��Ȩ   chmod 777  shutdown.sh 