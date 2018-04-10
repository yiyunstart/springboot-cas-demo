## 序言
最小cas-server配置，目的在与将cas服务运行起来。

## 运行
```bash
    build.cmd run
```

   <p>访问地址  http://localhost:9000/ </p>
   
## 配置说明

### pplication.properties
```properties
   #表示的是直接通过ip就可以访问到项目，不需要加项目名称
   server.context-path=/
   #项目的端口号
   server.port=9000
   
   #关闭https 证书，cas默认需要开启https证书，为方便学习测试。关闭他
   server.ssl.enabled=false
   #设置不使用ssl
   cas.tgc.secure=false
   cas.warningCookie.secure=false
   
   #
   # 静态登录的 用户名::密码
   #
   cas.authn.accept.users=qtf::123456
```
### HTTPSandIMAPS-10000001.json
<p>文件位置 src/main/resources/services/HTTPSandIMAPS-10000001.json</p>

serviceId 过滤规则添加http
```json
{
  "@class" : "org.apereo.cas.services.RegexRegisteredService",
  "serviceId" : "^(https|imaps|http)://.*",
  "name" : "HTTPS and IMAPS",
  "id" : 10000001,
  "description" : "This service definition authorizes all application urls that support HTTPS and IMAPS protocols.",
  "evaluationOrder" : 10000
}

```