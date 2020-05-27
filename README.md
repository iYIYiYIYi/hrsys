hrsys
---
### 使用框架：Spring Boot 、Mybatis 、Thymeleaf

后端采用Spring Boot依照 MVC 设计思想实现了数据库、业务逻辑与视图的解耦。

后端部分在Controller包内实现了对Web请求的响应以及视图处理，Service层封装了查找、添加、修改员工信息的业务处理逻辑，dao包内封装了数据库处理的相关Repository。

前端部分使用了Thymeleaf模板引擎简化开发，同时使用了JQuery作为页面跳转以及页面传参的工具。网页域名整体符合REST规范。

另外，在课设要求的增删改查的基础之上，添加了导出员工Excel表单以及定时数据库备份功能，简化了数据库的备份维护工作。

--- 

#### 登陆界面：

![](img-readme/login.png)

#### 管理员界面：

![](img-readme/dashboard.png)

#### 用户界面：

![](img-readme/index.png)