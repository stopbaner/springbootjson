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


