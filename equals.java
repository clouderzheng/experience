package com.lk.C;

public class Test7 {                                                       
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.print("基本类型a==b:");
        System.out.println(a == b);
        System.out.println("-----");
        
        String s1 = "abc";
        String s2 = "abc";
        System.out.print("String类型是s1==s2:");
        System.out.println(s1 == s2);
        System.out.println("-----");
        
        String s3 = new String("abc");
        String s4 = new String("abc");//可以看出==比较的是栈的地址是否相同
        System.out.print("String类型用new String()是s1==s2:");
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
        System.out.println("-----");
        
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.print("包装类型是i1==i2:");
        System.out.println(i1 == i2);
        System.out.println("-----");
        
        Integer i3 = 128;
        Integer i4 = 128;//此时输出false是因为Integer在-128-127之间会缓存，超出这个范围就不会缓存了
        System.out.print("包装类型是i3==i4:");
        System.out.println(i3 == i4);
        System.out.println("-----");
        
        Integer i5 = new Integer("1");
        Integer i6 = new Integer("1");
        System.out.print("包装类型用new Integer()是i5==i6:");
        System.out.println(i5 == i6);//用new Integer()多少都不会缓存
        System.out.println("-----");
        
        A a1 = new A(1);
        A a2 = new A(1);
        A a3 = a2;
        System.out.print("普通引用类型a1 == a2：");
        System.out.println(a1 == a2);
        System.out.println(a2 == a3);//对象赋给新对象连地址都是相同的
        System.out.println("-----");
    }
}

class A{
    int i;
    public A(int i){
        this.i = i;
    }
}


基本类型a==b:true
-----
String类型是s1==s2:true
-----
String类型用new String()是s1==s2:false
false
-----
包装类型是i1==i2:true
-----
包装类型是i3==i4:false
-----
包装类型用new Integer()是i5==i6:false
-----
普通引用类型a1 == a2：false
true
-----


-----------------------------------------------------------------------------------------------------------------
package com.lk.C;

public class Test8 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("基本类型没有equals方法");
        System.out.println("-----");
        
        String s1 = "abc";
        String s2 = "abc";
        System.out.print("String类型的equals方法:");
        System.out.println(s1.equals(s2));
        System.out.println("-----");
        
        String s3 = new String("abc");
        String s4 = new String("abc");//可以看出比较equals方法比较的是堆里的值是否相同
        System.out.print("String类型的new String()的equals方法：");
        System.out.println(s3.equals(s4));
        System.out.println("-----");
        
        System.out.print("String用==赋值和用new String()赋值的比较：");
        System.out.println(s1.equals(s3));
        System.out.println("-----");
        
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.print("包装类的equals方法：");
        System.out.println(i1.equals(i2));
        System.out.println("-----");
        
        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        System.out.print("包装类的new Integer()用equals方法：");
        System.out.println(i3.equals(i4));
        System.out.println("-----");
        
        System.out.print("Integer用==赋值和用new Integer()赋值的比较：");
        System.out.println(i1.equals(i3));
        System.out.println("-----");
    }

}
复制代码
复制代码
基本类型没有equals方法
-----
String类型的equals方法:true
-----
String类型的new String()的equals方法：true
-----
String用==赋值和用new String()赋值的比较：true
-----
包装类的equals方法：true
-----
包装类的new Integer()用equals方法：true
-----
Integer用==赋值和用new Integer()赋值的比较：true
-----
--------------------------------------------------------------------------------------------------------------




package com.lk.C;

public class Test9 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student s1 = new Student("阿坤",21);
        Student s2 = new Student("阿坤",21);
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = s1;
        System.out.print("普通类对象的==非默认构造：");
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println("-----");
        
        System.out.print("普通类对象的equals非默认构造：");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s5));
        System.out.println("-----");
        
        System.out.print("普通类对象的==默认构造：");
        System.out.println(s3 == s4);
        System.out.println("-----");
        
        System.out.print("普通类对象的equals默认构造：");
        System.out.println(s3.equals(s4));
        System.out.println("-----");
        
        System.out.print("对普通对象的属性进行比较equals：");
        System.out.println(s1.name.equals(s2.name));
        System.out.print("对普通对象的属性进行比较==：");
        System.out.println(s1.name == s2.name);
    }

}
class Student{
    public String name;
    public int age;
    public Student(){
        
    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void test(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

普通类对象的==非默认构造：false
true
-----
普通类对象的equals非默认构造：false
true
-----
普通类对象的==默认构造：false
-----
普通类对象的equals默认构造：false
-----
对普通对象的属性进行比较equals：true
对普通对象的属性进行比较==：true


