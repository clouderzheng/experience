《Web开发实战》
背景设置
background-image: url(../img/back.jpg) ;background-repeat: no-repeat;background-size:100% 100%; background-attachment: fixed; 
不重复 铺满

不支持JavaScript的浏览器  提供的替代工具
<noscript> javascript 不可用是的替代方案


<scripte>
</scripte>

<noscript>
</noscript>

<meta>放在html的head中，主要用于标识网站，基本包含网站的一些基本信息，如简介，作者等
<meta>有四种元素，name，http-equiv，content，和charset
<meta>标签通过name属性来表述页面文档的元信息
通过http-equiv属性设置http请求
通过charset设置字符编码


<label>标签与表单元素绑定事件，点击标签可以出发表单元素的事件
<input type="checkbox" id="keepSigned" name="keepSigned">
	<label for="keepSigned">keep me signed in 30 days</label>
	关键操作 for指向id，label的鼠标事件会转移到关联的输入控件上

基本html格式 	
	<!DOCTYPE HTML>  //声明这是 一个html模板
<html> //根标签 所有的标签都嵌套在这个标签下面
	<head>
		<meta charset="UTF-8"/>
		<title>标题</title>
	</head>
	
	<body>
	
	</body>
</html>

标题和段落是块级元素  链接和图片是行内元素

块级元素会相互堆叠在一起沿页面向下排列，每个元素分别占一行，而行内元素则会相互并列，只有在空间不足以并列的情况才会折到下一行显示

非文本内容是通过自闭合标签显示的。闭合标签与自闭合标签的区别在于，闭合标
签包含的是会显示的实际内容，而自闭合标签只是给浏览器提供一个对要显示内容
的引用。浏览器会在 HTML 页面加载的时候，额外向服务器发送请求，以取得自闭
合标签引用的内容。

属性负责为浏览器提供有关标签的额外信息。比如说，前面例子中的<img>标签有两
个属性。一个属性是 src（source，来源），属性值为 cisco.jpg。这个属性定义了图
片的来源是一个名为 cisco.jpg 的文件。另一个属性是 alt（alternative，替代内容），
定义的是在图片因故未能加载成功时在屏幕上显示的文本。


块级标签
? <h1>-<h6> ：6 级标签， <h1>表示最重要
? <p>：段落
? <ol>：有序列表
? <li>：列表项
? <blockquote>：独立引用
行内标签
? <a>：链接（anchor，锚）
? <img>：图片
? <em>：斜体
? <strong>：重要
? <abbr>：简写
? <cite>：引证
? <q>：文本内引用


有一点很重要，那就是 CSS 样式是通过<style>标签嵌入到页面里的。当浏览器遇到
开标签<style>时，就会由解释 HTML 代码切换为解释 CSS 代码。等遇到闭标签
</style>时，它会再切换回解释 HTML 代码。

所有用于选择特定元素的选择符又分三种。
? 上下文选择符。基于祖先或同胞元素选择一个元素。
? ID 和类选择符。基于 id 和 class 属性的值（你自己设定）选择元素。
? 属性选择符。基于属性的有无和特征选择元素。
万万牢记，上下文选择符以空格作为分隔符，而分组选择符则以逗号作为分隔符，
不要弄混

子选择符>
标签 1 > 标签 2
标签 2 必须是标签 1 的子元素，或者反过来说， 标签 1 必须是标签 2 的父元素。与常
规的上下文选择符不同，这个选择符中的标签 1 不能是标签 2 的父元素之外的其他
祖先元素

紧邻同胞选择符+
标签 1 + 标签 2
标签 2 必须紧跟在其同胞标签 1 的后面。

标签 1 ~ 标签 2
标签 2 必须跟（不一定紧跟）在其同胞标签 1 后面。
用 Shift+1 键左侧的键输入字符～（波浪号）

属性名选择符
标签名[属性名]
选择任何带有属性名的标签名。
比如，下面的 CSS
img[title] {border:2px solid blue;}


属性值选择符
标签名[属性名="属性值"]
在 HTML5 中， 属性值的引号可加可不加，在此为了清楚起见，我们加了。
选择任何带有值为属性值的属性名的标签名。
这个选择符可以让你控制到属性的值是什么。例如，这条规则
img[title="red flower"] {border:4px solid green;}

ID 也可以用在页内导航链接中。下面就是一个链接，其目标是同一页的另一个位置。
<a href="#bio">Biography</a>
看到 href 属性值开头的#了吗？它表示这个链接的目标在当前页面中，因而不会触发浏览器加
载页面（如果没有#，浏览器就会尝试加载 bio 目录下的默认页面了）。

ID 的用途是在页面标记中唯一地标识一个特定的元素。它能够为我们编写 CSS 规则
提供必要的上下文，排除无关的标记，而只选择该上下文中的标签。
相对来说，类是可以应用给任意多个页面中的任意多个 HTML 元素的公共标识符，
以便我们为这些元素应用相同的 CSS 样式。而且，使用类也让为不同标签名的元素
应用相同的样式成为可能。


伪类这个叫法源自它们与类相似，但实际上并没有类会附加到标记中的标签上。伪
类分两种。
? UI（User Interface，用户界面）伪类会在 HTML 元素处于某个状态时（比如鼠标
指针位于链接上），为该元素应用 CSS 样式。
? 结构化伪类会在标记中存在某种结构上的关系时（如某个元素是一组元素中的第
一个或最后一个），为相应元素应用 CSS 样式。

层叠规则
层叠规则一：找到应用给每个元素和属性的所有声明。
层叠规则二：按照顺序和权重排序。 p {color:green !important; font-size:12pt;}
层叠规则三：按特指度排序  p {font-size:12px;}
.largetext {font-size:16px;} 因为类名选择符比普通的标签选择符具有更高的特指度

计算特指度
1. 选择符中有一个 ID，就在 I 的位置上加 1；
2. 选择符中有一个类，就在 C 的位置上加 1；
3. 选择符中有一个元素（标签）名，就在 E 的位置上加 1；
4. 得到一个三位数。
好了，下面通过几个例子来理解特指度。
P 0-0-1 特指度=1
p.largetext 0-1-1 特指度=11
p#largetext 1-0-1 特指度=101
body p#largetext 1-0-2 特指度=102
body p#largetext ul.mylist 1-1-3 特指度=113
body p#largetext ul.mylist li 1-1-4 特指度=114
在此，每个选择符都比前一个选择符的特指度更高



表2-1 绝对值及示例
绝 对 值 单位缩写 示 例*
英寸 in height:6in
厘米 cm height:40cm
毫米 mm height:500mm
点 pt height:60pt
皮卡 pc height:90pc
像素 px height:72px


颜色值
1. 颜色名（如 red）
W3C 定义了 16 个颜色关键字： aqua（浅绿色）、 black（黑色）、 blue（蓝色）、 fuchsia
（紫红色）、 gray（灰色）、 green（绿色）、 lime（黄绿色）、 maroon（褐红色）、 navy
（深蓝色）、 olive（茶青色 ）、 purple（紫色）、 red（红色）、 silver（银色）、 teal（青色）、
white（白色）和 yellow（黄色）。要了解这些颜色名及其对应的 RGB 颜色值，请参
考： http://www.w3.org/TR/css3-color/#html4。


2. 十六进制颜色（#RRGGBB 或#RGB）
另外，如果三对值中的每一对是两个相同的数字，也可以使用简写形式：
#rgb
3. RGB 颜色值（R, G , B）
rgb(r, g, b)
比如， rgb(0,255,0)表示纯绿色。
4. RGB 百分比值（R%, G%, B%）
这是用百分比来表示每种颜色值的一种方法，格式如下：
r%, g%, b%
5. HSL (色相, 饱和度%, 亮度%)
HSL 格式如下：
HSL(0,0%,0%)
HSL 比我们见过的各种 RGB 方式更直观，因为使用它更容易写出和看懂颜色。
6. Alpha 通道
请注意， RGB 和 HSL 都支持 Alpha 通道，用于设置颜色的不透明度（换句话说，就
是能够透过多少背景）。相应的格式分别叫 RGBA 和 HSLA。

关于颜色的一些资料
? http://colrd.com：Colrd 是一个 Pinterest 风格的站点，其中有很多能启发人创造力的图片和
照片，以及相应的调色板。
? http://kuler.com：Adobe Kuler 的官方站点提供了数千种色样、调色板创建工具，以及其他
人正在选用的时尚颜色。

? 边框（border） 。可以设置边框的宽窄、样式和颜色。
? 内边距（padding） 。可以设置盒子内容区与边框的间距。
? 外边距（margin） 。可以设置盒子与相邻元素的间距。

3.1.1 盒子边框
边框（border）有 3 个相关属性。
? 宽度（border-width） 。可以使用 thin、 medium 和 thick 等文本值，也可以使用
除百分比和负值之外的任何绝对值。
? 样式（border-style）。有 none、 hidden、 dotted、 dashed、 solid、 double、 groove、
ridge、 inset 和 outset 等文本值。
? 颜色（border-color） 。可以使用任意颜色值，包括 RGB、 HSL、十六进制颜色
值和颜色关键字


叠加的只是垂直外边距，水平外边距不叠加。对于水平相邻的元素，它们
的水平间距是相邻外边距之和。这跟你最初想的一样。

例子 1
margin:10px 5px 15px 20px;
上外边距是 10px
右外边距是 5px
下外边距是 15px
左外边距是 20px


由于版本差异，用SpringBoot 1.4.X以上版本开发时找不到@Controller定义的URL，于是在启动类加注解@ComponentScan("com.controller")即可,括号里表示Controller所在包名。

浮动

浮动使得块类元素变成行内元素，在要与上一个块内元素同行的元素后面添加float，默认后一个元素铺满后面整个剩余行，要设置后一个元素宽度，
必须设置三个分区，后一个元素也要加上float属性

overflow:hidden 声明的真正用途是防止包含元素被超大内容撑大。应用
overflow:hidden 之后，包含元素依然保持其设定的宽度，而超大的子内容则会被容
器剪切掉。除此之外， overflow:hidden 还有另一个作用，即它能可靠地迫使父元素
包含其浮动的子元素。

要想强迫父元素包围其浮动的子元素有三种方式，
哪三种？
? 为父元素应用 overflow:hidden
? 浮动父元素
? 在父元素内容的末尾添加非浮动元素，可以直接在标记中加，也可以通过给父元
素添加 clearfix 类来加（当然，样式表中得需要相应的 clearfix 规则）

定位元素
第三段与它在文档流中的默认位置相比，向下移动了 25 像素，向右移动了
30 像素。相当于它把自己从原来的包含元素（body）中挣脱出来了，而且有一部
分还跑到了屏幕之外。要注意，除了这个元素自己相对于原始位置挪动了一下之
外，页面没有发生任何变化。换句话说，这个元素原来占据的空间没有动，其他
元素也没动。
使用相对定位的关键是什么呢？就是要考虑到元素原来的空间

绝对定位下，元素从文档流中被“连根拔起”，然后再相对于其他元素（在这里，
是默认的定位上下文 body）定位

可以看到元素之前占据的空间被“回收了”。这说明，绝对定位的元素
完全脱离了常规文档流，它现在是相对于顶级元素 body 在定位。而这自然而然就引
出了一个关于定位的重要概念：定位上下文

关于定位上下文，首先我们要知道绝对定位元素默认的定位上下文是 body 元素。如
图 3-25 所示，通过 top 和 left 设定的偏移值，决定了元素相对于 body 元素（标记
层次中的祖先容器），而不是相对于它在文档流中的位置偏移多远——这一点与相对
定位的元素不同。

从完全移出文档流的角度说，固定定位与绝对定位类似。
p#specialpara {position:fixed; top:30px; left:20px;}
但不同之处在于，固定定位元素的定位上下文是视口（浏览器窗口或手持设备的屏
幕），因此它不会随页面滚动而移动。

把块级元素变成行内元素（或者相反）的魔法如下。
/*默认为 block*/
p {display:inline;}
/*默认为 inline*/
a {display:block;}

display 属性还有一个值有必要提一下，就是 none。把元素的 display 设定为 none，
该元素及所有包含在其中的元素，都不会在页面中显示。它们原先占据的所有空间

也都会被“回收”，就好像相关的标记根本不存在一样。与此相对的是 visibility
属性，这个属性最常用的两个相对的值是 visible（默认值）和 hidden。把元素的
visibility 设定为 hidden，元素会隐藏，但它占据的页面空间仍然“虚位以待”。


背景渐变
渐变就是在一定长度内两种或多种颜色之间自然的过渡。
.gradient1 { //只有颜色 默认从上至下
background:linear-gradient(#e86a43, #fff);
}
/*例 2：从左到右*/
.gradient2 {
background:linear-gradient(left, #64d1dd, #fff);
}
/*例 3：左上到右下*/
.gradient3 {
background:linear-gradient(-45deg, #e86a43, #fff);
}

线性渐变
  .gradient1 {50%处有一个渐变点*/
   background:linear-gradient(#64d1dd, #fff 50%, #64d1dd);
  }
  .gradient2 {20%和 80%处有两个渐变点*/
   background:linear-gradient(#e86a43 20%, #fff 50%, #e86a43 80%);
  }
  .gradient3 {25%、 50%、 75%处有三个渐变点*/
  background:linear-gradient(#64d1dd, #fff 25%, #64d1dd 50%, #fff 75%,
          #64d1dd);
  }
  .gradient4 {为同一个渐变点设定两种颜色可以得到突变效果*/
   background:linear-gradient(#e86a43, #fff 25%, #64d1dd 25%, #64d1dd 75%,
   #fff 75%, #e86a43);
  }
 放射性渐变
 
 HTML 元素的阴影，同样是 CSS3 被广泛实现之前很难做出来的一个效果。当时，要给元素添加
阴影效果，必须用图片和 DIV 配合，还要耐心地调整，而现在则只要一行 CSS 声明即可。
最简单语法形式如下。
box-shadow:4px 4px 5px 8px #aaa inset;
box-shadow 属性的这几值分别代表：水平偏移量、垂直偏移量、模糊量、扩展量、颜色、阴
影位于边框内部（默认位于边框外部，即 outset）。

在 display 属性的值中， inline-block 具有一些特殊的混合行为。正如它的名字所暗
示的，它既有块级元素的特点，也有行内元素的行为。从块级元素角度说，可以为
它设定外边距和内边距，也可以通过它简便而有效地包围其他块级元素。从行内元
素角度看，它会收缩包裹自己的内容，而不是扩展填充父元素。换句话说，
inline-block 元素的宽度始终等于其内容宽度。这种元素还有一个特点，就是可以
包围浮动元素。不过，这种元素也有一个问题，即不能给它的外边距设定 auto 值——
而这恰恰又是在更大的容器内居中元素的最简单方法


校验插件(http://validform.club/ 最好的JQ校验插件