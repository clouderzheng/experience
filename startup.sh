#!/bin/sh
tpid=`cat tpid | awk '{print $1}'`
tpid=`ps -aef | grep $tpid | awk '{print $2}' | grep $tpid`



if [ ${tpid} ]; then
echo server is running,cannot startup
else
rm -f tpid
for file in ./*.jar
do
	if test -f $file
	then
		nohup java  -Xms256m  -Xmx512m -Djava.security.egd=file:/dev/./urandom -jar $file --spring.config.location=./application.properties > /dev/null 2>&1 &
		echo $! > tpid
		echo $file has start successed
	fi
done
fi
