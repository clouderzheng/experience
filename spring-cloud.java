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



springcloud消费者获取的是一个只读的服务清单缓存
希望修改缓存清单的更新时间，可以通过eureka.client.register-fetch-interval-seconds=30修改

通信协议
默认情况下，eureka使用jersey 个xstream 配合json作为server与client之间的通信协议

springcloud eureka实现的服务治理机制强调了CAP 里面的AP  即可用性与可靠性，它与zookeper这类强调CP（一致性、可靠性）的服务治理
最大的区别是，eureka为了实现更高的服务可用性，牺牲了一定的一致性。在极端情况下他宁愿接受故障实例也不丢掉“健康”实例.比如：当服务注册中心的网络
发生故障断开时，由于所有的服务实例无法维持持续心跳，在强调AP的服务治理中将会把所有服务实例都剔除掉，而eureka会因为超过85的实例丢失心跳
而触发保护机制，注册中心将会保留此时的所有节点，以实现服务间依然可以互相调用的场景，即使其中有部分故障节点，但是这样做可以继续保障大多数的服务
正常消费。


hystrix实现由两种 
一种是“舱壁模式”线程池隔离的，为每一个依赖服务创建一个独立的线程池，这样就算某个依赖服务出现延迟过高的情况，也只是对该依赖服务的调用产生影响，不会
拖累其他依赖服务
第二种是使用信号量来控制单个依赖服务的并发度，信号量的开销远比线程池开销小，但是不能设置超时和实现异步访问

hystrix作用
请求缓存
断路由
请求合并 ：
优点：减少请求的数量以缓解依赖服务线程池的资源
缺点：使用请求合并带来额外开销
应用场景： 
1、单个请求命令本身延迟很高
2、延迟窗内的并发量很高

使用feign 开启断路由  hystrix  记得 开启 feign.hystrix.enabled = true 默认是false  不开启
feign 通过日志配置 可以打印每个请求的请求路径 参数 以及响应

网关：
降低维护路由规则与服务实例列表的难度
过滤与调度外部客户端的访问，实现请求的路由，负载均衡，校验过滤等，与服务治理框架结合，请求转发时的熔断机制，服务的聚合。