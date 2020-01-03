pip install uwsgi


建立软连接
 find / -name uwsgi
 ln -s  xxx   /usr/bin/uwsgi
 
 [uwsgi]
socket = 127.0.0.1:6001 
;将Flask应用运行在这个端口
master = true  
wsgi-file = app.py 
;后端文件名称
callable = app
;设置在收到请求时，uWSGI加载的模块中哪个变量将被调用，默认是名字为“application”的变量。即是： app = Flask(__name__) 
processes = 4   
threads = 2
daemonize = server.log 
;日志保存文件名称 【位置默认在app.ini 目录下】

启动命令
uwsgi app.ini 
关闭命令
pkill -f -9 uwsgi


http://localhost:9112/auth/login