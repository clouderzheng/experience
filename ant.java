一．             安装与配置

下载地址：http://ant.apache.org/，在本文中下载的是1.7.0版本。解压到某个目录（例如E:"apache-ant-1.7.0），即可使用。

添加系统环境变量：ANT_HOME，该变量指向Ant解压后的根目录，在此为E:"apache-ant-1.7.0。

安装与配置完毕后，读者可以测试一下Ant是否可用，首先进入Ant的bin目录，运行命令ant –version，若安装和配置成功，则会显示Ant版本信息，如下图所示：    

由上可以看出，读者运行Ant的命令时，需要进入到Ant的bin目录，如何才能让系统自动 找到Ant呢？这时需要读者在系统环境变量path中添加Ant的bin目录。设置完成后，我们就可以在任何目录（例如C:"Documents and Settings"AmigoXie目录）输入Ant的命令，来获得命令的运行结果。

二．             Ant的关键元素

Ant的构件文件是基于XML编写的，默认名称为build.xml。为了更清楚的了解Ant，在这里编写一个简单的Ant程序，用来展现Ant的功能，让读者对Ant有一个初步的了解。首先在E盘下建立一个build.xml文件，内容如下：

<?xml version="1.0"?> <project name="helloWorld">        <target name="sayHelloWorld">               <echo message="Hello,Amigo"/>        </target> </project>

读者可以进入E盘，然后运行ant sayHelloWorld，可以看到如下的运行结果：     

其中sayHelloWorld为需要执行的任务的名称。如果文件名不为build.xml，而为hello.xml时，读者运行同样的命令时，命令窗口会出现如下错误：

Buildfile: build.xml does not exist!

Build failed

由上面的命令的错误提示可以看出，ant命令默认寻找build.xml文件。若文件名为 hello.xml时，读者还需要对命令做少许改变，改为：ant –f hello.xml sayHelloWorld、ant –buildfile hello.xml sayHelloWorld或ant –file hello.xml sayHelloWorld。

接下来开始向读者讲解本节的重点：Ant的关键元素project、target、property和task。

1.       project元素

project元素是Ant构件文件的根元素，Ant构件文件至少应该包含一个project元素，否则会发生错误。在每个project元素下，可包含多个target元素。接下来向读者展示一下project元素的各属性。

1）name属性

用于指定project元素的名称。

2）default属性

用于指定project默认执行时所执行的target的名称。

3）basedir属性

用于指定基路径的位置。该属性没有指定时，使用Ant的构件文件的附目录作为基准目录。

下面给读者一个简单的例子来展示project的各元素的使用。修改E:"build.xml文件，修改后的内容如下：

<?xml version="1.0"?> <project name="projectStudy" default="sayBaseDir" basedir="E:"apache-ant-1.7.0">        <target name="sayBaseDir">               <echo message="The base dir is: ${basedir}"/>        </target> </project>

从上面的内容我们可以看出，在这里定义了default属性的值为sayBaseDir，即 当运行ant命令时，若未指明执行的target时，默认执行的target的sayBaseDir，同时还定义了basedir属性的值为 E:"apache-ant-1.7.0，进入E盘后运行ant命令，可看到运行的结果，如下图所示：    

因为设定了basedir的值，所以basedir属性的值变成了读者设置的值。读者可以自行将project元素的basedir属性去掉后运行ant看看运行结果，此时basedir的值变成了E:"，即为Ant构件文件的父目录。

有的时候，读者可能有这种需求，即想得到某个project下所有的target的名称，读者可以通过在ant命令里加上-proecthelp来达到该目的。例如针对上述的例子我们运行ant –projecthelp，输出结果如下：

Buildfile: build.xml

Main targets:

Other targets:

sayBaseDir

Default target: sayBaseDir

2.       target元素

它为Ant的基本执行单元，它可以包含一个或多个具体的任务。多个target可以存在相互依赖关系。它有如下属性：

1）name属性

指定target元素的名称，这个属性在一个project元素中是唯一的。我们可以通过指定target元素的名称来指定某个target。

2）depends属性

用于描述target之间的依赖关系，若与多个target存在依赖关系时，需要以“,”间隔。Ant会依照depends属性中target出现的顺序依次执行每个target。被依赖的target会先执行。

3）if属性

用于验证指定的属性是否存在，若不存在，所在target将不会被执行。

4）unless属性

该属性的功能与if属性的功能正好相反，它也用于验证指定的属性是否存在，若不存在，所在target将会被执行。

5）description属性

该属性是关于target功能的简短描述和说明。

下面带领读者来看一个各属性综合使用的例子。修改E:"build.xml文件，修改后的内容如下：

<?xml version="1.0"?> <project name="targetStudy">        <target name="targetA" if="ant.java.version">               <echo message="Java Version: ${ant.java.version}"/>        </target>        <target name="targetB" depends="targetA" unless="amigo">               <description>                             a depend example!               </description>               <echo message="The base dir is: ${basedir}"/>        </target> </project>

进入E盘后运行ant targetB，可看到如下图所示的运行结果：    

读者分析结果后可以看到，我们运行的是名为targetB的target，因该target 依赖于targetA，所以targetA将首先被执行，同时因为系统安装了java环境，所以ant.java.version属性存在，执行了 targetA这个target，输出信息：[echo] Java Version: 1.5，targetA执行完毕后，接着执行targetB，因为amigo不存在，而unless属性是在不存在时进入所在的target的，由此可知 targetB得以执行，输出信息：The base dir is: E:"。

3.       property元素

该元素可看作参量或者参数的定义，project的属性可以通过property元素来设 定，也可在Ant之外设定。若要在外部引入某文件，例如build.properties文件，可以通过如下内容将其引入：<property file=” build.properties”/>

property元素可用作task的属性值。在task中是通过将属性名放在“${”和“}”之间，并放在task属性值的位置来实现的。

Ant提供了一些内置的属性，它能得到的系统属性的列表与Java文档中System.getPropertis()方法得到的属性一致，这些系统属性可参考sun网站的说明。

同时，Ant还提供了一些它自己的内置属性，如下：

basedir：project基目录的绝对路径，该属性在讲解project元素时有详细说明，不再赘述；

ant.file：buildfile的绝对路径，如上面的各例子中，ant.file的值为E:"build.xml；

ant.version：Ant的版本，在本文中，值为1.7.0；

ant.project.name：当前指定的project的名字，即前文说到的project的name属性的值；

ant.java.version：Ant检测到的JDK的版本，在上例运行结果中可看到为1.5。

下面让读者来看一个property元素使用的简单例子。修改E:"build.xml文件，内容如下：

<?xml version="1.0"?> <project name="propertyStudy" default="example"> <property name="name" value="amigo"/> <property name="age" value="25"/> <target name="example">         <echo message="name: ${name}, age: ${age}"/> </target> </project>

该例的运行结果如下图所示：    

由此读者可以看出，通过如下两个语句：

<property name="name" value="amigo"/>

<property name="age" value="25"/>

我们设置了名为name和age的两个属性，这两个属性设置后，读者在下文中可以通过${name}和${age}分别取得这两个属性的值。

三．             Ant的常用任务

在Ant工具中每一个任务封装了具体要执行的功能，是Ant工具的基本执行单位。在本小节中，主要引导读者来看下Ant的常用任务及其使用举例。

1.       copy任务

该任务主要用来对文件和目录的复制功能。举例如下：

Eg1.复制单个文件：<copy file="file.txt" tofile="copy.txt"/>

Eg2.对文件目录进行复制：

   <copy todir="../newdir/dest_dir">

            <fileset dir="src_dir"/>

</copy>

Eg3. 将文件复制到另外的目录：

<copy file="file.txt" todir="../other/dir"/>

2.       delete任务

对文件或目录进行删除，举例如下：

Eg1. 删除某个文件：<delete file="photo/amigo.jpg"/>

Eg2. 删除某个目录：<delete dir="photo"/>

Eg3. 删除所有的备份目录或空目录：

        <delete includeEmptyDirs="true">

               <fileset dir="." includes="**/*.bak"/>

        </delete>

3.       mkdir任务

创建目录。eg：<mkdir dir="build"/>

4.       move任务

移动文件或目录，举例如下：

Eg1. 移动单个文件：<move file="fromfile" tofile=”tofile”/>

Eg2. 移动单个文件到另一个目录：<move file="fromfile" todir=”movedir”/>

Eg3. 移动某个目录到另一个目录：

        <move todir="newdir">

               <fileset dir="olddir"/>

        </move>

5.       echo任务

该任务的作用是根据日志或监控器的级别输出信息。它包括message、file、append和level四个属性，举例如下：

<echo message="Hello,Amigo" file="logs/system.log" append="true">

四．             利用Ant构建和部署Java工程

Ant可以代替使用javac、java和jar等命令来执行java操作，从而达到轻松的构建和部署Java工程的目的。下面来看几个知识点。

1.       利用Ant的javac任务来编译java程序

Ant的javac任务用于实现编译Java程序的功能。下面来看一个简单的例子：

首先我们建立名为antstudy的Java工程，建立src目录为源代码目录，在src目录下建立HelloWorld.java这个类文件。该类文件的内容如下：

public class HelloWorld  {     public static void main(String[] args)  {        System.out.println("Hello,Amigo");     } }

   同时在antstudy工程的根目录下建立build.xml文件，在该文件中编译src目录下的java文件，并将编译后的class文件放入build/classes目录中，在编译前，需清除classes目录，该文件的内容如下：

<?xml version="1.0"?> <project name="javacTest"default="compile" basedir=".">     <target name="clean">        <delete dir="build"/>     </target>

    <target name="compile" depends="clean">        <mkdir dir="build/classes"/>     <javac srcdir="src" destdir="build/classes"/>     </target> </project>

    运行该build.xml文件，可在工程中看到新增了build/classes目录，并在该目录中生成了编译后的HelloWorld.class文件。

2.       使用Ant的java任务运行Java程序

Ant中可以使用java任务实现运行Java程序的功能。下面在1的例子中进行如下的修改，修改后的build.xml文件的内容如下：

<?xml version="1.0"?> <project name="javaTest" default="jar" basedir=".">     <target name="clean">        <delete dir="build"/>     </target>

    <target name="compile" depends="clean">        <mkdir dir="build/classes"/>       <javac srcdir="src" destdir="build/classes"/>     </target>

    <target name="run" depends="compile">        <java classname="HelloWorld">            <classpath>               <pathelement path="build/classes"/>            </classpath>        </java>     </target> </project>

    运行该build.xml文件，可在控制台看到HelloWorld的main方法的输出。

3.       使用Ant的jar任务生成jar文件

读者可以在上例的基础上更进一步，来生成jar包，可在run这个target下再加上如下target：

<target name="jar" depends="run"> <jar destfile="helloworld.jar" basedir="build/classes">            <manifest>               <attribute name="Main-class" value="HelloWorld"/>            </manifest>        </jar> </target>

此时将ant的project的default属性设置为jar，同时运行该build.xml文件，运行完毕后，可看到在工程目录下生成了一个jar包HelloWorld.jar。

4.       使用Ant的war任务打包J2EE Web项目

建立一个J2EE Web工程，其目录结构如下图所示：

其中src为源代码目录，WebRoot为各jsp存放目录，lib为工程的包目录。在 antwebproject工程目录下建立了build.xml文件，该文件为该工程的Ant构件文件。读者可以src目录下放入在前续例子中开发的 HelloWorld.java文件，并在WebRoot下建立index.jsp文件，其内容很简单，就是输出Hello信息，代码如下所示：

<% @ page language="java" contentType="text/html; charset="UTF-8" pageEncoding="UTF-8"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> <html>     <head>        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">        <title>ant打包测试</title>     </head>     <body>        Hello,Ant     </body> </html>

   接下来编写build.xml文件，其内容如下：

<?xml version="1.0"?> <project name="antwebproject"  default="war"basedir="."> <property name="classes" value="build/classes"/>     <property name="build"value="build"/>     <property name="lib"value="WebRoot/WEB-INF/lib"/>     <!-- 删除build路径-->     <target name="clean">        <delete dir="build"/>     </target>

    <!-- 建立build/classes路径，并编译class文件到build/classes路径下-->     <target name="compile" depends="clean">        <mkdir dir="${classes}"/>

       <javac srcdir="src" destdir="${classes}"/>     </target>

    <!-- 打war包-->     <target name="war" depends="compile"> <war destfile="${build}/antwebproject.war" webxml="WebRoot/WEB-INF/web.xml">            <!-- 拷贝WebRoot下除了WEB-INF和META-INF的两个文件夹-->     <fileset dir="WebRoot" includes="**/*.jsp"/>

           <!-- 拷贝lib目录下的jar包-->            <lib dir="${lib}"/>            <!-- 拷贝build/classes下的class文件-->            <classesdir="${classes}"/>        </war>     </target> </project>

    各target的作用在内容中已经进行说明，在此不再赘述。运行该build文件，更新目录后，可看到在build目录下生成了antwebproject.war文件，解开后可看到其目录结构如下：

--META-INF

     --MANIFEST.MF

--index.jsp

--WEB-INF

     --lib

            --log4j-1.2.9.jar

     --classes

            --HelloWorld.class

     --web.xml

     读者可以将该war包拷贝到Tomcat的目录下看一下运行结果。

五．             总结

在本文中，笔者由浅至深详细描述了Ant的安装与配置、关键元素和常用任务。并通过实例讲述 了Ant在我们Java项目中的应用，讲述了编译、运行java程序，以及打jar包、war包等知识，引领读者进入Ant的奇妙世界。在本文中可以看 到，Ant在自动构建和部署Java程序方面方便易用，而且非常灵活，不失为我们Java开发者的绝佳帮手

 

 

学习目标：basedir
<?xml version="1.0"?>
<project name="projectStudy" default="sayBaseDir" basedir="D:\myec">
       <target name="sayBaseDir" description="打印提示信息">
              <echo message="The base dir is: ${basedir}"/>
       </target>
</project>
  
  
学习目标：创建目录
<?xml version="1.0"?>
<project name="propertyStudy" default="mkdir" description="创建目录">
    <target name="mkdir">
        <mkdir dir="mkdirTest"/>
    </target>
</project> 
 
 
 
学习目标：property变量
<?xml version="1.0"?>
<project name="propertyStudy" default="example">
    <property name="name" value="amigo"/>
    <property name="age" value="25"/>
     
    <target name="example">
        <echo message="name: ${name}, age: ${age}"/>
    </target>
</project>
 
 
学习目标：拷贝单个文件 与 文件夹
<?xml version="1.0"?>
<project name="propertyStudy" default="copydir">
    <target name="copyfile" description="拷贝文件">
        <copy file="antStudy.txt" tofile="copy.txt"/>
    </target>
     
    <target name="copydir" description="拷贝目录">
        <copy todir="../AntProject/src_copy">
              <fileset dir="src"/>
         </copy>
    </target>
</project>
 
 
学习目标：删除单个文件 与 文件夹 / 删除备份目录及空目录
<?xml version="1.0"?>
<project name="propertyStudy" default="deldir">
    <target name="delfile" description="删除文件">
        <delete file="src_copy/com/cyjch/test/AntTest.java" />
    </target>
 
    <target name="deldir" description="删除目录">
        <delete dir="../AntProject/src_copy" />
    </target>
 
    <target name="delBakAndEmpty" description="删除空目录及备份目录">
        <delete includeEmptyDirs="true">
            <fileset dir="." includes="**/*.bak" />
        </delete>
    </target>
</project>
 
 
学习目标：移动文件、目录
<?xml version="1.0"?>
<project name="propertyStudy" default="moveDirToDir">
    <target name="moveFile" description="移动文件">
        <move file="mkdirTest/cantStudy.txt" tofile="cantStudy.txt"/>
    </target>
 
    <target name="moveFileToDir" description="移动目录">
        <move file="cantStudy.txt" todir="mkdirTest"/>
    </target>
 
    <target name="moveDirToDir" description="移动目录到目录，也可做为目录更名">
        <move todir="mkdirTestNew">
            <fileset dir="mkdirTest"/>
        </move>
    </target>
</project>
 
 
 
学习目标：编译
<?xml version="1.0"?>
<project name="javacTest" default="compile" basedir=".">
    <target name="clean" description="删除编译后产生的目录及文件">
        <delete dir="build" />
    </target>
 
    <target name="compile" depends="clean" description="编译源文件">
        <mkdir dir="build/classes" />
        <javac srcdir="src" destdir="build/classes" />
    </target>
</project>
 
 
 
学习目标：编译并运行JAVA程序
<?xml version="1.0"?>
<project name="javaTest" default="run" basedir=".">
    <target name="clean" description="清除目录">
        <delete dir="build" />
    </target>
 
    <target name="compile" depends="clean" description="编译">
        <mkdir dir="build/classes" />
        <javac srcdir="src" destdir="build/classes" />
    </target>
 
    <target name="run" depends="compile" description="运行">
        <java classname="AntTest">
            <classpath>
                <pathelement path="build/classes" />
            </classpath>
        </java>
    </target>
</project>
 
 
 
学习目标：打JAR包
<?xml version="1.0"?>
<project name="javaTest" default="jar" basedir=".">
    <target name="jar" description="打JAR包">
        <jar destfile="helloworld.jar" basedir="build/classes">
            <manifest>
                <attribute name="Main-class" value="HelloWorld" />
            </manifest>
        </jar>
    </target>
</project>
 
 
学习目标：打WAR包
 
 
 
 
学习目标：mkdir srcdir destdir delete war jar
<?xml version="1.0"?>
<!--默认为打包操作-->
<project name="structured" default="archive">
    <description>编译并打包一个应用程序</description>
    <!--在工程目录下创建输出目录：build/classes 和 dist-->
    <target name="init" description="创建目录">
        <mkdir dir="build/classes" />
        <mkdir dir="dist" />
    </target>
 
    <!--编译输出目录：srcdir-源目录和destdir-目标目录-->
    <target name="compile" depends="init" description="编译">
        <javac srcdir="src" destdir="build/classes" />
    </target>
 
    <!--打包 , depends依赖哪些target-->
    <target name="archive" depends="compile" description="打包">
        <war destfile="dist/antwebproject.war" basedir="build/classes" />
        <jar destfile="dist/project.jar" basedir="build/classes" />
    </target>
 
    <!--清理删除-->
    <target name="clean" depends="init" description="清理">
        <delete dir="build" />
        <delete dir="dist" />
    </target>
</project>
 
 
学习目标： webproject打War包
<?xml version="1.0"?>
<project name="antwebproject" default="war" basedir=".">
    <!--定义常量，任务可以引用-->
    <property name="classes" value="build/classes" />
    <property name="build" value="build" />
    <property name="lib" value="WebRoot/WEB-INF/lib" />
 
         
    <!-- 删除build路径-->
    <target name="clean">
        <delete dir="build" />
    </target>
 
 
    <!-- 建立build/classes路径，并编译class文件到build/classes路径下-->
    <target name="compile" depends="clean">
        <mkdir dir="${classes}" />
        <javac srcdir="src" destdir="${classes}" />
    </target>
 
 
    <!-- 打war包-->
    <target name="war" depends="compile">
        <war destfile="${build}/AntProject.war" webxml="WebRoot/WEB-INF/web.xml">
            <!-- 拷贝WebRoot下除了WEB-INF和META-INF的两个文件夹 , **意为:匹配0或者更多的目录-->
            <fileset dir="WebRoot" includes="**/*.jsp" />
 
            <!-- 拷贝lib目录下的jar包-->
            <lib dir="${lib}" />
 
            <!-- 拷贝build/classes下的class文件-->
            <classes dir="${classes}" />
 
        </war>
    </target>
 
</project>