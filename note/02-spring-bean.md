# Spring Bean 基础
## 定义 Spring Bean
1. 什么是 BeanDefinition？
   - BeanDefinition 是 SpringFramework 中定义Bean 的配置元信息接口
     - Bean 的类名
     - Bean 行为配置元素，作用域、自动绑定的模式、生命周期
     - 其他 Bean 引用
     - 配置设置，如 Bean 属性
## BeanDefinition 元信息
| 属性（Property）            | 说明                                  |
|-------------------------|-------------------------------------|
| Class                   | Bean 全类名，必须是具体类，不能用抽象类或接口           |
| Name                    | Bean 的名称或者 ID                       |
| Scope                   | Bean 的作用域 （如 singleton、prototype 等） |
| Constructor arguments   | Bean 构造器参数（用于依赖注入）                  |
| Properties              | Bean 属性设置（用于依赖流入）                   |
| Autowired mode          | Bean 自动绑定模式（如：通过名称 byName）          |
| Lazy initialization mode | Bean 延迟初始化模式（延迟和非延迟）                |
| Initialization method   | Bean 初始化回调方法名称                      |
| Destruction method      | Bean 销毁回调方法名称                       |

### BeanDefinition 构建
    示例：cn.abner.thinking.in.spring.bean.definition.BeanDefinitionCreationDemo
- 通过 BeanDefinition Builder
- 通过 AbstractBeanDefinition 及派生类
## 命名 Spring Bean
- Bean 的名称生成器 
- 由 Spring Framework 2.0.3 引入，内建两种实现
  - DefaultBeanNameGenerator：默认通用 BeanNameGenerator 实现
  - AnnotationBeanNameGenerator：基于注解扫描的 BeanNameGenerator 实现
## Spring Bean 的别名
    示例：cn.abner.thinking.in.spring.bean.definition.BeanAliasDemo
Bean 别名（Alias）的价值
- 复用现有的 BeanDefinition
- 更具有场景化的命名方法
## 注册 Spring Bean 
### BeanDefinition 注册
    示例：cn.abner.thinking.in.spring.bean.definition.AnnotationBeanDefinitionDemo
- XML 配置元信息
  - <bean name="..." .../>
- Java 注解配置元信息
  - @Bean
  - @Component
  - @Import
- Java API 配置元信息
  - 命名方式 ： BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
  - 非命名方式： BeanDefinitionReaderUtils#registerWithGeneratedName(AbstractBeanDefinition, BeanDefinitionRegistry)
  - 配置类方式： AnnotationBeanDefinitionReader#register(Class...)
## 实例化 Spring Bean
    示例：
      cn.abner.thinking.in.spring.bean.definition.BeanInstantiationDemo
      cn.abner.thinking.in.spring.bean.definition.SpecialBeanInstantiationDemo

- 常规方式
  - 构造器
  - 静态工厂方法
  - 通过 Bean 工厂方法
  - 通过 FactoryBean
- 特殊方式
  - 通过 ServiceLoaderFactoryBean
  - 通过 AutowireCapableBeanFactory#createBean
  - 通过 BeanDefinitionRegistry#registerBeanDefinition(String, BeanDefinition)
## 初始化 Spring Bean

## 延迟初始化 Spring Bean

## 销毁 Spring Bean

## 垃圾回收 Spring Bean

## 问题精选