# url-shrinker-jfinal
网址缩短器接口（jfinal版本），反正你懂的咯！

### 跳转接口
uux.me/xxx<br />
xxx为要跳转的url的id<br />
例子：http://uux.me/anmt<br />

### 查询接口
uux.me/api/query?key=xxx<br />
xxx为要跳转的url的id，或者就是目标url<br />
例子：http://uux.me/api/query?key=http://anmt.me<br />
例子：http://uux.me/api/query?key=anmt<br />

### 增加接口
uux.me/api/add?url=xxx<br />
xxx为要增加的url<br />
例子：http://uux.me/api/add?url=http://anmt.me<br />

注意：增加接口有防频繁操作，具体以配置文件为主。<br />
注意：在添加url时是大小写敏感的，就是说你添加的时候url有大写的，那么在根据url查询的时候，该大写的也得大写，包括“http”和“https”，跳转的时候重定向的url该大写的也是大写的。<br />