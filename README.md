## s003 - InMemoryUserDetailsManager(使用内存的用户详情管理器来创建用户)
- 删除s002的配置文件中创建用户部分
- 在 `SecurityConfiguration` 中添加 `UserDetailsService` 的Bean
- 修改`SecurityConfiguration`类的`securityFilterChain`方法，使`/user`拥有`USER`角色才可以访问，`/admin`拥有`ADMIN`角色才可以访问
- 修改 `/admin`方法，使之更容易区分


## s002 - SecurityFilterChain
- 修改配置文件，添加日志
- 修改配置文件，添加用户名，密码和角色
- 修改controller，添加方法 `/user`
- 修改controller，添加方法 `/admin`
- 添加配置类 `SecurityConfiguration` 类，并添加 `securityFilterChain` 方法
- 用配置文件中的帐号进行浏览器登录，并尝试访问 `/`, `/user`, `/admin` 三个路径
- 用Insomnia，进行basic的认证，进行上述三个访问

> tip: 仔细观察发现401是未认证，403是没权限，以后可以根据不同的状态码，前端进行错误提示

## s001 - 创建项目
- 建立项目结构
- 初始化web依赖和security依赖
- 编写首页controller
- 了解默认的用户和密码
- 登录页面测试