克隆模式
实现Cloneable接口 ，实现clone方法

单列模式 双重锁定 双重判断
if(instance == null){  //多线程在这里阻塞  同时没有同时进入 需要在创建之气再次判断
	lock(current){
		if(instance == null){
			instance = new instance();
		}
	}
}


享元模式 
String name  = "nihgt"
String lastName = "night"
name.equal(lastName) == true