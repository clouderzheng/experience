window��ѯ�˿� ɱ������
netstat -aon|findstr 9114
>taskkill -f -pid 5572


1.ps ����: 
https://pan.baidu.com/s/1mjYbcJA
���룺pqdt

2.HTML5+CSS3�����ŵ���ͨ.iso ����:
https://pan.baidu.com/s/1cUHz3o
���룺gdyw

3.Javascript��Ƶ�̳� ����: https://pan.baidu.com/s/1i6eC5YP
���룺ku5k

4.Jquery��Ƶ�̳� ���ӣ�https://pan.baidu.com/s/17DbNSnR3q5OGSjdw9tvCEA 
���룺twcp

5.Bootstrap��Ƶ�̳� ����: https://pan.baidu.com/s/1jKb2UDS
���룺wr8c

6.Vue.js ����: 
https://pan.baidu.com/s/1slYqBa1
���룺75xd

7.Smartyģ��������Ƶ�̳� ����: https://pan.baidu.com/s/1smewom5
���룺v8vp

8.Nodejs ����: https://pan.baidu.com/s/1sm509GD
���룺fux1

9.Mysql��Ƶ�̳� ����: https://pan.baidu.com/s/1kVTdjcr
���룺e37d

10.PHP��Ƶ�̳� ����: https://pan.baidu.com/s/1kWE0qZP
���룺xc4q

11.oracle��Ƶ�̳� ����: https://pan.baidu.com/s/1i6jwpal
���룺hk6p

12.nginx��Ƶ�̳� ����: https://pan.baidu.com/s/1nxccLg1
���룺x2q8

13.ajax ����:
 https://pan.baidu.com/s/1dHctdXv
���룺jfwf

14.mongodb��Ƶ�̳� ����: https://pan.baidu.com/s/1c3EE7U4
���룺7v8b

15.Angular.js����: https://pan.baidu.com/s/1jJhYrEu
���룺ddci

16.React����: 
https://pan.baidu.com/s/1nwnrQxb
���룺942g

17.dedeCMS֯����Ƶ ����: https://pan.baidu.com/s/1bpQBCbP
���룺ikns

18.ThinkPHP��Ƶ�̳� ����: https://pan.baidu.com/s/1ggiKvYV
���룺7p5h

19.�������ܽ� ����: https://pan.baidu.com/s/1eTSNB5C
���룺5rx7

20.��è�̳ǹ��ﳵʵս ����: https://pan.baidu.com/s/1smVjb7v
���룺cu4c

21.Javaѧ�����ӣ�https://pan.baidu.com/s/1DtnDNv1p9ENZETLqIuKytw
 ���룺82lk

22.Python���ӣ�https://pan.baidu.com/s/1scBXSLdiTs9SBixdkykflw 
���룺ck51

23.nodejs΢�ſ������ӣ�https://pan.baidu.com/s/15tYBZ2yVz9aPO57LKqt7Mg 
���룺jrwb

jquery�ĵ�

$(document).ready(function(){}); ==  $(function(){})

Ч����window.onload = function(){}���� ǰ�߿���һ��ҳ��д��� ���ֱ�ִ�У�����ֻ��һ���������һ��Ϊ׼����JavaScript����ִ�У�

��#id��ȡ����jquery����  ��ducoment.getElementById()��ȡ����dom����

jquery������dom����֮��Ļ�ת

jqeury����תΪdom����
1��jquery������һ����������Ķ��� ������ͨ����index����������ʽ��ȡdom����
var $jqeury = $("#name"); //jquery����
var dom = $jqeury[0]; //dom����
alert(dom.checked)
2������jquery��get(index)������ȡ
var $jqeury = $("#name")
var dom  = $jqeury.get(0);
dom����תΪjquery����
ֻ��Ҫ��$()��dom�����װ����
var dom = document.getElementById("name")//dom����
var $jqeury = $(dom)  //jquery����

ƽʱʹ�õ�jquery������ͨ��$()������������ģ�$()��������һ��jquery��������칤��

�ո�ע������
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
 
 
 DOM�����ڵ�
 ɾ���ڵ�
 remove();  //ɾ���ڵ� ����ɾ���ڵ������  
 ���ÿ��Լ�������ں��棬����ֻ�����һ�Σ���֪��Ϊɶ�� ����ʹ��clone()����������  
 ��¡���󲻱����¼�  �����¼�  ʹ��clone(true)
 detach()   //��remove���� ������¼� bind("click",function(){})
 empty();   //����ڵ㣬ɾ���ڵ�����
 
 
 ������ѡ ��ѡ  radio  checkbox��ֵ
 <select id="single">
        <option>����</option>
        <option>����</option>
        <option>��ë��</option>
        <option>����</option>
    </select>

    <select multiple="multiple" id="multiple">
        <option>�㽶</option>
        <option>����</option>
        <option>ƻ��</option>
        <option>⨺���</option>
        <option>����</option>
    </select>

    <input type="radio" name="genget" value="1">��<br/>
    <input type="radio" name="genget" value="2">Ů<br/>

    <input type="checkbox" name="interest" value="����">����<br/>
    <input type="checkbox" name="interest" value="ɢ��">ɢ��<br/>
    <input type="checkbox" name="interest" value="����">����<br/>
    <input type="checkbox" name="interest" value="����">����<br/>
	
	
	$("#single").val("��ë��");
    $("#multiple").val(["ƻ��","⨺���"]);
    $(":radio").val(["2"]);
    $(":checkbox").val(["����","ɢ��"]);