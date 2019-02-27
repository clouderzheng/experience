注册中心
sever端默认注册中心指向自己  
eureka.client.serviceUrl.defaultZone=http://127.0.0.1:9112/eureka/
sever端的服务不注入发现  否则找不到注册中心
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

注册服务
指向注册中心
eureka.client.serviceUrl.defaultZone=http://127.0.0.1:9112/eureka/
与server端相反，必须使自己可以被发现  默认是发现 不做配置