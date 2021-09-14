# Lesson 04 - 输入和输出

眼睛是人的一种输入器官，图像在无时无刻地从这里涌入；嘴巴是人的一种输出器官，有意义的语言滔滔不绝地从这里流出。有了这些即时的输入和输出，大脑才能准确判断你所处的时机并作出相应的应答机制。

程序也是如此，它也需要输入和输出。一个简单的马里奥程序，需要时刻判断你方向键是否被按下，同时时刻让你看到地图上方块和怪物的状况。在你以后的编程中，你需要通过输入方便快捷地尝试不同的参数，需要通过输出检查你的运算结构是否正确。

由此可见输入和输出必不可少，那么这节课，我们就来学习一下Java中几种输入和输出的方法吧！



## 1 输入

在Java中，一般有两种输入的方法：

- 使用工具类`java.util.Scanner`
- 使用入参argument输入。



### java.util.Scanner

这是一个重要的工具类，顾名思义，一个扫描仪。现在大家只需要知道这个工具的用法就好：

首先你需要获取一个“扫描仪”，我们这里给它取名叫`sc`：

```java
Scanner sc = new Scanner(System.in);
```

现在我们可以先从字面上理解，新建（new）了一个Scanner，并且名字叫`sc`（变量名）。`System.in`即系统输入，意思就是说这个叫做`sc`的Scanner是从系统输入（控制台）获取你输入的数的。

接下来我们就要了解一下怎么用它了：

```java
int x = sc.nextInt();
```

注意这句语句里出现的`Int`，这正是表示这里希望**从系统输入获得一个int类型的变量**。当程序执行到这样一句话时，它会停住直到你给它一个整数并按下Enter（表示输入结束）。这样一来，你刚刚输入的整数会作为`.nextInt()`的运算结果，被赋值给了等号左边的int类型的变量x。

如果你输入的不是一个Int类型的数，程序会报错的哟！

类似地，我们还可以用相似的方法读入其他数据类型的数：

```java
double y = sc.nextDouble();
float z = sc.nextFloat();
String s = sc.next();
String s2 = sc.nextLine();
```

这些都会读到空格为止，如果此时你的输入还有多余的内容，剩下的内容可以继续被之后的其他next方法读取到。

注意读入字符串String时，我们有两种不同的方法：

`.next()`会读到空格为止，而`.nextLine()`会直接读完一整行，也就是读到换行为止

比如你输入`What's up?`，`.next()`的读到的结果为`What's`，而`.nextLine()`的读到的结果为`What's up?`



最后，差点忘了告诉各位，为了告诉计算机你要用的Scanner是哪里蹦出来的Scanner，你需要像这样在一切程序的开头**import一下这个Scanner的包**。

```java
import java.util.Scanner;
```

这表示你要用的工具类Scanner是来自java.util这个东西里的。你做了一个“导入”操作，表示要导入这个工具类，这样才能使用Scanner哦！千万别忘记~



我们来看这个例子，`Addition1.java`想要将运行时输入的两个数进行相加并输出结果。

```java
import java.util.Scanner;

public class Addition1 {
    public static void main(String[] args) {
        
        // create a Scanner called sc
        Scanner sc = new Scanner(System.in);
        
        // get the two integers by the Scanner--"sc"
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // add them together
        int c = a + b;
        
        // show the result
        System.out.println(c);
        
        // usually we close it after all input operations
        sc.close();
    }
}
```



### argument

除了能在程序运行时获取用户自定义的输入，我们还可以在运行前指定要输入的参数。比如`Addition2.java`想要将运行前设置的入参的两个数进行相加并输出结果。

可是如何指定好要输入的参数呢？我们一般运行Java程序是这样在命令行中输入指令的：

```bash
javac Addition2.java # compile to .class

java Addition2    	# run the .class file
```

想要指定需要运行的参数，只需要在第二句话中之后加上要输入的参数就好了：

```bash
java Addition2 1 2   # run with two parameter 1 and 2
```

上面的命令行指令就表示指定1和2作为Addition程序的入参，这个入参是可以有无限个的哟~记得用空格隔开每一个参数！



好了，那么下一个问题就来了，这里的入参，程序该怎么接收呢？

上节课说的`public static void main(String[] args)`不知道大家还记不记得，这里的`args`就是会最终接收到入参的那个变量。它是一个数组，不过现在我们只需要知道，你可以用`args[0]`，`args[1]`，……，`args[n]`，……依次获取到刚刚入参的第**n+1**个参数，并且要注意的是，这里的每一个参数，读入后都成为了一个字符串。比如上面的例子，虽然1和2都是一个整数，但是分别传入了`args[0]`和`args[1]`后，它们就变成了字符串`"1"`和`"2"`。

字符串相加和int值相加可不一样，大家可以试试下面的代码：

```java
String s1 = "1";
String s2 = "2";
System.out.println(s1+s2);
```

输出为：

```java
12
```

所以字符串相加其实是进行了字符串的拼接操作。

既然不能用字符串相加，我们能不能想办法把它转换回整型int类型呢？

答案是可以的！Java又为你提供了方便的方法：`Integer.parseInt(x)`

这个方法可以将你输入的字符串变量（这里是x）转换为int类型的整型数据作为运算结果。

除此之外我们还有`Double.parseDouble(x)`将你输入的字符串变量（这里是x）转换为double类型的浮点型数据作为运算结果。



剩下的任务就是**相加再打印输出结果**咯，我们直接来看示例代码吧：

```java
public class Addition2 {
    public static void main(String[] args) {
        
        // get the arguments and turn them into the correct data type
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        
        // add them together
        int c = a + b;
        
        // show the result
        System.out.println(c);
    }
}
```



那么以上就是常用的输入的两种方式了，其中**Scanner是更常用的**，希望各位多加练习哦~



## 2 输出

### System.out.println()

相信大家肯定已经对第一种输出方式并不陌生了：

```java
System.out.println("Nice to meet you!");
System.out.println(c);
```

在这个括号我们可以写变量的名字，这可以打印出这个变量内部存储的值，也可以直接写直接量，这会直接打印出这个直接量。另外，我们要注意这里print之后的`ln`，这个可以理解为就是`line`，也就是**行**的意思，表示打印完后会换行，下次打印会从下一行开始打印。

另外为了方便的打印一些解释，我们可以利用上一个part说到过的**加号**，当字符串和变量相加时，也会变成一个拼接的操作，把对应变量的值拼接到相应字符串之前或之后：

```java
System.out.println("Calculate " + a + "+" + b)
System.out.println("The result is " + c);
```

当a的值为1，b的值为2，c的值为3时，输出为：

```
Calculate 1+2
The result is 3

```



### System.out.print()

这个方法和`println`的区别就是少了一个`ln`，所以显然这个就是打印括号内的内容之后不会换行~其他用法都大致相似。



### System.out.printf()

这个方法仔细讲起来可以用很大篇幅去描述，但我在这里仅会讲一些基本的用法，各种花里胡哨的操作大家可以靠百度学习。

首先大家肯定会好奇这里的`f`是什么，这个`f`代表的单词是`format`，格式。这个方法的中文翻译（非官方）就是——格式化输出。

那接下来让我们看看他怎么个格式化法，我们先看看这个语句：

```java
int hour = 5;
int grade = 3;
System.out.printf("I slept %d hours a day on average when I was a Grade %d student in SUSTech.", hour, grade);
```

输出：

```
I slept 5 hours a day on average when I was a Grade 3 student in SUSTech.
```

在上面的字符串直接量中的`%d`叫做**格式符**，它们可以被替换为特定的**整型**变量值。字符串中出现的`%d`会依次被替换为这个字符串之后的变量，比如第一个`%d hours`的`%d`就会被字符串后的第一个变量`hour`代替，第二个`%d student`的`%d`则会被第二个变量`grade`代替。如果是其他类型的变量，则需要其他的格式符：

- float, double: %f

- char: %c
- byte, short, int, long: %d
- String: %s

你会发现这用上面的+操作符也行啊，确实是这样，在这种时候，你可以按照自己的喜好去使用任意的方法，但是切记**你都得会**，不然考试你会GG。

不过这东东的功能可不止于此：

1. **四舍五入**，用于浮点数float和double，`.nf`，n为多少就保留几位小数：

   ```java
   double PI = 3.14159;
   System.out.printf("%.2f", PI)
   ```

   输出：

   ```
   3.14
   ```

2. **填充空格**，适合制表：

   ```java
   double PI = 3.14159;
   int date = 14;
   System.out.printf("%6.2f%4d", PI, date)
   ```

   输出：

   ```
     3.14  14
   ```

   这里PI先按照`.2f`的要求保留两位小数，即3.14；然后6表示占六个格子，可是3.14只占4格啊，这个时候会在3.14的左边补两个空格就变成了两个空格之后3.14。后面的`date`同理。至于制表的用法，等大家做了乘法表的那个题我们再提吧。



## 3 转义字符

当我正准备快快乐乐结束这一个lesson的时候，我突然想起来，转义字符还没讲，我裂开来。明天再写

