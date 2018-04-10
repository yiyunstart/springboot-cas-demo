
##运行cas-server
build.cmd run

##项目说明
不同的子项目下面，可能登录的风格和样式不一样，所以我们需要配置这个service目录，设定每一个子网站对应的请求样式，如果不设定，可以指定默认样式
##主要目录

配置文件在src/main/resources 目录下
* services	需要配置自定义登录的网站模版
* static	静态文件目录，用于存放js，css代码的
* templates	模板代码 casLoginView.html 这个名称不可瞎改
* client.properties 用于存放cas-client-sucerity网站的模版配置信息，正式版本建议用域名做文件名
* client2.properties 	用于存放cas-client-sucerity2网站的模版配置信息，正式版本建议用域名做文件名
## service目录配置
### HTTPSandIMAPS-10000001.json
这个json配置文件是系统默认的，我们可以直接修改这个，来设定系统默认的登录模板。
配置文件的命名必须是文件名称+id.json的这种方式，不然找不到配置文件。
<pre><code>
{
    "@class": "org.apereo.cas.services.RegexRegisteredService",
    "serviceId": "^(http|https|imaps)://.*",
    "name": "HTTPS and IMAPS",
    "id": 10000001,
    "description": "This service definition authorizes all application urls that support HTTPS and IMAPS protocols.",
    "evaluationOrder": 10000,
    "attributeReleasePolicy": {
        "@class": "org.apereo.cas.services.ReturnAllAttributeReleasePolicy"
    },
    "theme": ""
}</code></pre>

* @class	模版注册的类
* serviceId	表示哪一个网站使用这个模板
* name	给这个模板命名
* id	模板的id，建议json文件命名为 name_id 这样好区分，而且官网推荐
* description	注释，就说明这个模板，或则这个网站
* evaluationOrder	就是主题的顺序，这么多主题匹配，肯定是这个id越小，越先匹配
* theme	主题名称，主题名称建议和网站名称一致
* attributeReleasePolicy	cas参数返回策略

###client-1000.json
<pre><code>
{
  "@class" : "org.apereo.cas.services.RegexRegisteredService",
  "serviceId" : "^(https|imaps|http)://.*(9001).*",
  "name" : "client",
  "id" : 1000,
  "description" : "网站client过来的登录请求，跳转到client主题",
  "evaluationOrder" : 10,
  "theme": "client"
}
</code></pre>
这个是 cas-client-sucerity网站的配置， 为方便测试，简单匹配端口号的方式，匹配已 https、http 、imaps开头的，并且包含端口9001的

###client2-1001.json
<pre><code>
{
  "@class" : "org.apereo.cas.services.RegexRegisteredService",
  "serviceId" : "^(https|imaps|http)://.*(9002).*",
  "name" : "client2",
  "id" : 1001,
  "description" : "网站client2过来的登录请求，跳转到client2主题",
  "evaluationOrder" : 11,
  "theme": "client2"
}
</code></pre>
这个是 cas-client-sucerity2网站的配置， 为方便测试，简单匹配端口号的方式，匹配已 https、http 、imaps开头的，并且包含端口9002的

##启用识别
配置application.properties,设置cas需要从json文件做初始化操作，不然配置的json没有生效
<pre><code>
#开启识别json文件，默认false
cas.serviceRegistry.initFromJson=true

#自动扫描服务配置，默认开启
#cas.serviceRegistry.watcherEnabled=true
#120秒扫描一遍
#cas.serviceRegistry.repeatInterval=120000
#延迟15秒开启
#cas.serviceRegistry.startDelay=15000

#默认json/yml资源加载路径为resources/services
#cas.serviceRegistry.config.location=classpath:/services
</code></pre>

##static文件夹
配置主題静态资源文件，可以是css、js、images


