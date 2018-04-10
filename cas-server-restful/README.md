
##运行cas-server
build.cmd run

##项目说明
REST这种方式是解决验证数据不在CAS服务端，而是在本地端

##添加restful支持
```xml
<dependency>
   <groupId>org.apereo.cas</groupId>
      <artifactId>cas-server-support-rest-authentication</artifactId>
     <version>${cas.version}</version>
</dependency>
```

##application.properties 配置

```code
#请求远程调用接口,相当于远程获取数据源
#http://127.0.0.1:8081/cas-rest/user/login
cas.authn.rest.uri=http://127.0.01:8081/cas-rest/user/login
#加密策略
cas.authn.rest.passwordEncoder.type=DEFAULT
cas.authn.rest.passwordEncoder.characterEncoding=UTF-8
#加密算法
cas.authn.rest.passwordEncoder.encodingAlgorithm=MD5
```

