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

