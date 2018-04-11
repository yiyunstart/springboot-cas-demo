## 序言
本项目为研究cas使用，结合截止日期2018-04-10最新cas版本5.2.3为基础。做各个功能配置实验，尝试组合出适合复杂生成环境的最佳实例。
在学习过程中为部分属性加上中文注释说明，方便日后复习和使用。


## cas 官方开源代码地址
https://github.com/apereo
## cas 官方各个配置项说明
https://apereo.github.io/cas/5.2.x/installation/Configuration-Properties.html
## cas重写模板
https://github.com/apereo/cas-overlay-template


#### cas-client-sucetiry 
   单点登录客户端，用于测试server，端口9001
   <p> http://localhost:9001/ </p>

#### cas-client-sucetiry2
  单点登录客户端2，用于测试server,端口9002
   <p>  http://localhost:9002/ </p>
   
#### cas-server-base
  学习研究用：基础cas-server配置，使用内存账号，官方登录界面，只做了最基础的配置，未做过多修改
  
   <p>  http://localhost:9000/ </p>
   
#### cas-server-login
  学习研究用：扩展cas-server配置，修改登录界面。
  
   <p>  http://localhost:9000/ </p>
   
#### cas-server-form
  学习研究用：扩展cas-server配置，扩展登录输入表单项。
  
   <p>  http://localhost:9000/ </p>
   
#### cas-server-restful
  学习研究用：扩展cas-server配置，调用http 接口完成账号密码认证
  
   <p>  http://localhost:9000/ </p>
#### cas-server-restful-intf
  学习研究用：提供完成账号密码认证的http接口
  
   <p>  http://localhost:9000/ </p>
   
#### cas-server
复合版：集成以上部分功能，从众多cas配置项、插件中整理出的一个集成到生产环境的配置版本。

## 运行cas-server
build.cmd run