# Spring IoC 依赖注入
## 依赖注入的模式和类型
### 模式
- 手动模式 - 配置或编程的方式，提前安排注入规则
  - XML 资源配置元信息
  - Java 注解配置元信息
  - API 配置元信息

- 自动模式 - 实现方提供依赖自动关联方式，按照内建注入规则
  - Autowired
### 类型
| 依赖注入类型    | 配置元数据举例                                       |
|-----------|-----------------------------------------------|
| Setter方法  | \<property name="user" ref="userBean"/>       |
| 构造器       | <construct-arg name="user" ref="userBean"/>   |
| 字段        | @Autowired User user                          |
| 方法        | @Autowired public void user(User user){...}   |
| 接口回调      | class MyBean implements BeanFactoryAware{...} |

## 自动绑定（Autowiring）

## 自动绑定（Autowiring）模式
### Autowiring modes
| 模式          | 说明                                    |
|-------------|---------------------------------------|
| no          | 默认值，未激活 Autowiring，需要手动指定依赖注入对象       |
| byName      | 根据被注入属性的名称作为 Bean 名称进行依赖查找，并将对象设置到该属性 |
| byType      | 根据被注入属性的类型作为依赖类型进行查找，并将对象设置到该属性       |
| constructor | 特殊 byType 类型，用于构造器参数                  |
参考枚举： org.springframework.beans.factory.annotation.Autowire

## 自动绑定（Autowiring）限制和不足

## Setter 方法依赖注入

## 构造器依赖注入

## 字段注入

## 方法注入

## 回调注入

## 依赖注入类型选择

## 基础类型注入

## 集合类型注入

## 限定注入

## 延迟依赖注入

## 依赖处理过程

## @Autowired 注入原理

## JSR-330 @Inject 注入原理

## Java 通用注解注入原理

## 自定义依赖注入注解

## 问题精选
