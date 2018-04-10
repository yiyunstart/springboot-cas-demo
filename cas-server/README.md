
##运行cas-server
build.cmd run

##项目说明
如我们表单不止需要有用户名，密码，还需要有验证码的信息，这样，就需要自定义表单的方式来完成
##主要目录

##表单添加
###创建表单
表单对象，需要继承默认的RememberMeUsernamePasswordCredential ，
添加用户所需要的字段，我现在需要加上一个验证码的字段信息。
