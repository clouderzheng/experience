window查询端口 杀死进程
netstat -aon|findstr 9114
>taskkill -f -pid 5572


1.ps 链接: 
https://pan.baidu.com/s/1mjYbcJA
密码：pqdt

2.HTML5+CSS3从入门到精通.iso 链接:
https://pan.baidu.com/s/1cUHz3o
密码：gdyw

3.Javascript视频教程 链接: https://pan.baidu.com/s/1i6eC5YP
密码：ku5k

4.Jquery视频教程 链接：https://pan.baidu.com/s/17DbNSnR3q5OGSjdw9tvCEA 
密码：twcp

5.Bootstrap视频教程 链接: https://pan.baidu.com/s/1jKb2UDS
密码：wr8c

6.Vue.js 链接: 
https://pan.baidu.com/s/1slYqBa1
密码：75xd

7.Smarty模板引擎视频教程 链接: https://pan.baidu.com/s/1smewom5
密码：v8vp

8.Nodejs 链接: https://pan.baidu.com/s/1sm509GD
密码：fux1

9.Mysql视频教程 链接: https://pan.baidu.com/s/1kVTdjcr
密码：e37d

10.PHP视频教程 链接: https://pan.baidu.com/s/1kWE0qZP
密码：xc4q

11.oracle视频教程 链接: https://pan.baidu.com/s/1i6jwpal
密码：hk6p

12.nginx视频教程 链接: https://pan.baidu.com/s/1nxccLg1
密码：x2q8

13.ajax 链接:
 https://pan.baidu.com/s/1dHctdXv
密码：jfwf

14.mongodb视频教程 链接: https://pan.baidu.com/s/1c3EE7U4
密码：7v8b

15.Angular.js链接: https://pan.baidu.com/s/1jJhYrEu
密码：ddci

16.React链接: 
https://pan.baidu.com/s/1nwnrQxb
密码：942g

17.dedeCMS织梦视频 链接: https://pan.baidu.com/s/1bpQBCbP
密码：ikns

18.ThinkPHP视频教程 链接: https://pan.baidu.com/s/1ggiKvYV
密码：7p5h

19.案例和总结 链接: https://pan.baidu.com/s/1eTSNB5C
密码：5rx7

20.天猫商城购物车实战 链接: https://pan.baidu.com/s/1smVjb7v
密码：cu4c

21.Java学科链接：https://pan.baidu.com/s/1DtnDNv1p9ENZETLqIuKytw
 密码：82lk

22.Python链接：https://pan.baidu.com/s/1scBXSLdiTs9SBixdkykflw 
密码：ck51

23.nodejs微信开发链接：https://pan.baidu.com/s/15tYBZ2yVz9aPO57LKqt7Mg 
密码：jrwb

jquery心得

$(document).ready(function(){}); ==  $(function(){})

效果与window.onload = function(){}类似 前者可以一个页面写多个 ，分别执行，后者只能一个，以最后一个为准，（JavaScript解释执行）

用#id获取的是jquery对象  用ducoment.getElementById()获取的是dom对象

jquery对象与dom对象之间的互转

jqeury对象转为dom对象
1、jquery对象是一个类似数组的对象 ，可以通过【index】方法的形式获取dom对象
var $jqeury = $("#name"); //jquery对象
var dom = $jqeury[0]; //dom对象
alert(dom.checked)
2、根据jquery的get(index)方法获取
var $jqeury = $("#name")
var dom  = $jqeury.get(0);
dom对象转为jquery对象
只需要用$()把dom对象包装起来
var dom = document.getElementById("name")//dom对象
var $jqeury = $(dom)  //jquery对象

平时使用的jquery对象都是通过$()函数制造出来的，$()函数就是一个jquery对象的制造工厂

空格注意事项
	<div class="test">
	   <div style="display: none" >aa</div>
	   <div style="display: none" >bb</div>
	   <div style="display: none" >cc</div>
	 <div class="test" style="display: none" >t1</div>
	</div>

   <div class="test" style="display: none" >t2</div>
   <div class="test" style="display: none" >t3</div>
	   
 function testSpace() {
     var $nopace = $(".test:hidden");
     alert($nopace.length)//3
     var $pace = $(".test :hidden");
     alert($pace.length)//4
 }
 
 
 DOM操作节点
 删除节点
 remove();  //删除节点 返回删除节点的引用  
 引用可以继续添加在后面，但是只能添加一次（不知道为啥） 可以使用clone()方法多次添加  
 克隆对象不保存事件  保存事件  使用clone(true)
 detach()   //与remove类似 保存绑定事件 bind("click",function(){})
 empty();   //保存节点，删除节点内容
 
 
 下拉单选 多选  radio  checkbox赋值
 <select id="single">
        <option>足球</option>
        <option>篮球</option>
        <option>羽毛球</option>
        <option>排球</option>
    </select>

    <select multiple="multiple" id="multiple">
        <option>香蕉</option>
        <option>梨子</option>
        <option>苹果</option>
        <option>猕猴桃</option>
        <option>刺梨</option>
    </select>

    <input type="radio" name="genget" value="1">男<br/>
    <input type="radio" name="genget" value="2">女<br/>

    <input type="checkbox" name="interest" value="旅游">旅游<br/>
    <input type="checkbox" name="interest" value="散步">散步<br/>
    <input type="checkbox" name="interest" value="音乐">音乐<br/>
    <input type="checkbox" name="interest" value="上网">上网<br/>
	
	
	$("#single").val("羽毛球");
    $("#multiple").val(["苹果","猕猴桃"]);
    $(":radio").val(["2"]);
    $(":checkbox").val(["音乐","散步"]);