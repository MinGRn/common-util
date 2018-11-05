# 手机号码归属地查询

判断手机号码归属地是通过 webservice。网上有个 webservice
网站：http://www.webxml.com.cn/zh_cn/web_services.aspx。

该网站每天免费调用 100 次，如果需要更多则需要付费。

打开网址会查询手机号码归属地下有三个网址发现：

![web-sit.png](img/web-sit.png)

先不管！看WSDL即可！在我们本地安装的 JDK bin 目录下有个 wsimport.exe 程序

![wsimport.png](img/wsimport.png)

cmd命令运行(win10 shift+右键即可在此处运行 cmd)：

```
wsimport  -s  "D:/shilin/"  -p  "com.shilin.mobile.ws"  "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl";
```

其中：`D：/shilin` 是指定的文件夹 `com.shilin.mobile.ws` 是生成的包路径！生成了这些文件：

![code.png](img/code.png)

运行 [Test.java](src/test/java/Test.java) 测试示例即可。