# springboot项目初用


## 可以按照下列三种方式启动此项目：  
>
1 在IDE中选中项目Run As->Spring Boot app，或者选中MySpringbootDemoApplication，Run As->Run Application，项目就会在内嵌的tomcat中启动。  
2 由于我们使用了 spring-boot-starter-parent POM，所以可以使用 mvn spring-boot:run来启动项目（根路径）。  
3 生成fat jar包，以java xx.jar形式来启动。(根路径)  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;生成fat jar包：mvn package
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会生成一个fat jar包，target/my-springboot-demo-1.0.jar。里面包含了程序所需所有资源。  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;启动项目：java -jar target/my-springboot-demo-1.0.jar  

	
最后访问：http://127.0.0.1:8081/springboot-demo/hello/say

1增加了spring.profiles.active属性，用以应对不同环境(生产、测试)使用不同配置文件;注意优先级
2增加@EventListener特性，集成spring事件注册、发送功能