通过包管理安装，比如Window平台的Chocolatey、Scoop，Mac平台的MacPortsl、Homebrew等等。
手动安装。
关于包管理器安装可以查看官方文档 ，这里主要介绍手动安装，在https://gradle.org/releases/ 中下载你想要Gradle版本的binary-only。

和配置Java环境类似，在系统变量中添加GRADLE_HOME：

然后再将%GRADLE_HOME%\bin添加到path系统变量中就可以了，运行gradle -v命令来进行验证

配置完Gradle环境后，按照惯例要实现Gradle的Hello World，这里以Windows平台为例。
build.gradle为Gradle默认的构建脚本文件，运行Gradle 命令时，会从当前目录下寻找 build.gradle 文件来执行构建。
我们先新建一个目录，比如D:\Android\gradle_demo，在这个目录中新建一个 build.gradle 文件，输入以下内容：

task hello {
    doLast {
        println 'Hello world!'
    }
}
然后在该文件所在目录下运行gradle -q hello构建脚本， 就会打印出“Hello world!”。

项目构建比较复杂，为了使用各种开发语言的开发者都能够快速的构建项目，专家们开发出了Gradle这个基于Groovy的DSL，DSL(Domain Specifc Language)意为领域特定语言，只用于某个特定的领域。我们只要按照Groovy的DSL语法来写，就可以轻松构建项目。
task（任务）和action(动作)是Gradle的重要元素。上面的代码中，task代表一个独立的原子性操作，比如复制一个文件，编译一次Java代码，这里我们简单的定义一个名为hello的任务。doLast 代表task执行的最后一个action，通俗来讲就是task执行完毕后会回调doLast中的代码，在上面这个例子中就会打印 ‘Hello world!’



上面的例子还可以写的更简洁一些，操作符<< 是doLast方法的快捷版本，它们做了相同的事情，如下所示。

task hello  {
    println 'Hello world!'
}

3.3 动态定义任务
动态定义任务指的是在运行时来定义任务的名称，如下所示。

3.times {number ->
    task "task$number" << {
        println "task $number"
    }
}
这里用到了Groovy语法，关于Groovy语法会在本系列后续的文章进行介绍。times是Groovy在java.lang.Number中拓展的方法，是一个定时器。3.times中循环创建了三个新任务，隐式变量number的值为0，1，2，任务的名称由task加上number的值组成，达到了动态定义任务的目的。
运行gradle -q task0构建脚本，打印结果如下：
task 0


坑点 ： 
1、不要加<< 符号
2、脚本是解释执行的，类似c语言结构，要调用的任务必须提前申明