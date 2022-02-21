### springboot对于json的使用

---

1. json大小写设置--JsonProperty

2. json空值转换设置

3. json全局设置

4. json忽略设置--@JsonIgnore

5. json替代器设置

6. json设置属性为空时界面不显示--@JsonInclude设置或者全局配置类设置

7. json中date格式的转换--@JsonFormat注解设置



### 全局异常处理

---
1. controller层可以使用@ResControllerAdvice+@ExceptionHandler的方式实现对于controller层异常的捕获

2. 自定义实现类实现BasicErrorController，可以处理filter中的异常


### springboot注解方式配置filter、listener与servlet

---
1. Servlet 三大组件 Servlet、Filter、Listener 在传统项目中需要在 web.xml 中进行相应的配置。Servlet 3.0 开始在 javax.servlet.annotation 包下提供 3 个对应的 @WebServlet、@WebFilter、@WebListener 注解来简化操作。

2. @WebServlet、@WebFilter、@WebListener 写在对应的 Servlet、Filter、Listener 类上作为标识，从而不需要在 web.xml 中进行配置了。

3. Spring Boot 应用中这三个注解默认是不被扫描的，需要在项目启动类上添加 @ServletComponentScan 注解, 表示对 Servlet 组件扫描。


### springboot对于easyExcel的使用

---
相比于poi，easyExcel几乎不会出现oom的情况，因为poi先读一部分数据到缓存，easyExcel一行一行的读
1. 文件格式
- HSSF，对应MicroSoft Excel文件格式,2003版，最多65535行
- XSSF，对应MicroSoft Excel OOXML文件格式，2007版
- HWPF，对应MicroSoft Word文件格式
- HSLF，对应MicroSoft PowerPoint文件格式
- HDGF，对应MicroSoft Visio文件格式

2. Excel对象，工作簿，工作表，行，列


### 接口幂等

---
select与delete操作存在天然幂等性
- 唯一索引或唯一组合索引来防止新增已存在的数据
- token机制，token加redis或者token加jvm内存实现。删除token成功代表校验通过，使用select加delete校验token存在并发问题
-- 数据提交前向服务申请token，token放到redis或者jvm内存中，设置token有效时间
-- 提交到后台校验token，同时删除token，生成新的token，返回token

- 悲观锁，select from table_name where id ='' for update; id为主键或者唯一索引
- 乐观锁，更新数据的时候锁表，通过版本号实现，update table_name set name='',version=version+1 where version='';
-- 乐观锁可以通过版本号实现，update table_xxx set name=#name#,version=version+1 where version=#version#
-- 乐观锁通过条件限制实现，update tablexxx set name=#name#,version=version+1 where id=#id# and version=#version# update tablexxx set avaiamount=avaiamount-#subAmount# where id=#id# and avai_amount-#subAmount# >= 0

- 分布式锁，通过redis或者zookeeper实现
- select+update,先查询再修改，适用于并发不高的情况


### 循环依赖

---
1.循环依赖的解决条件
- 出现循环依赖的Bean必须要是单例
- 依赖注入的方式不能全是构造器注入的方式（很多博客上说，只能解决setter方法的循环依赖，这是错误的）
>@Component
public class A {
// A中注入了B
@Autowired
private B b;
}
>@Component
public class B {
// B中也注入了A
@Autowired
private A a;
}

>// 自己依赖自己
@Component
public class A {
// A中注入了A
@Autowired
private A a;
}


### juc

---
java.util.concurrent包下解决高并发问题的类

1. wait与sleep的区别
- wait来自object类，sleep来自线程类
- wait释放锁，sleep不会释放锁
- wait需要在同步代码块中，sleep可以在任何地方
- wait不需要捕获异常，sleep需要

2. runnable与callable的区别
   -runnable没有返回值，callable有返回值





