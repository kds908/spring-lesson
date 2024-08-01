# Think In Spring

---

## Spring 编程模型
- 面向对象编程
    - 契约接口： Aware、 BeanPostProcessor ...
    - 设计模式：观察者模式、组合模式、模板模式...
    - 对象继承： Abstract* 类
- 面向切面编程
    - 动态代理： JdkDynamicAopProxy
    - 字节码提升： ASM、CGLib、AspectJ ...
- 面向元编程
    - 注解：模式注解 (@Component、@Service、@Respository...)
    - 配置：Environment抽象、PropertySources、BeanDefinition...
    - 泛型：GenericTypeResolver、ResolvableType...
- 函数驱动
    - 函数接口：ApplicationEventPublisher
    - Reactive：Spring WebFlux
- 模块驱动
    - Maven Artifacts
    - OSGI Bundles
    - Java 9 Automatic Modules
    - Spring @Enable*

---

## Spring 核心价值
- 生态系统
  - Spring Boot
  - Spring Cloud
  - Spring Security
  - Spring Data
  - Other
- API 抽象设计
  - AOP抽象
  - 事务抽象
  - Environment 抽象
  - 生命周期
- 编程模型
  - 面向对象模型
    - 契约接口
  - 面向切面编程
    - 动态代理
    - 字节码提升
  - 面向元编程
    - 配置元信息
    - 注解
    - 配置元信息
  - 面向模块编程
    - Maven Artifacts
    - OSGI Bundles
    - Java 9 Automatic Modules
    - Spring @Enable*
  - 面向函数编程
    - Lambda
    - Reactive
- 设计思想
  - OOP 面向对象
  - IoC/DI 
  - DDD 领域驱动
  - TDD 测试驱动
  - EDP 事件驱动
  - FP  函数编程
- 设计模式
  - 专属模式
    - 前缀模式
      - Enable 模式
      - Configurable模式
    - 后缀模式
      - 处理器模式
        - Processor
        - Resolver
        - Handler
      - 意识模式
        - Aware
      - 配置器模式
        - Configure
      - 选择器模式
        - org.springframework.context.annotation.ImportSelector
  - 传统 GoF 23
- 用户基础
  - Spring 用户
    - Spring Framework
    - Spring Boot
    - Spring Cloud
  - 传统用户
    - Java SE
    - Java EE

--- 
### 问题：

沙雕问题：什么是 Spring Framework ？

996问题：Spring Framework 有哪些核心模块？
  - spring-core : 提供 Spring 基础 API 模块，如资源管理、泛型处理
  - spring-beans : Spring Bean 相关，如依赖查找，依赖流入
  - spring-aop ： Spring AOP 处理，如动态代理，AOP 字节码提升
  - spring-context : 事件驱动、注解驱动、模块驱动等
  - spring-expression : Spring 表达式语言模块

劝退问题：Spring Framework 的优势和不足是什么？
  问题的答案，贯穿 Spring 始终

--- 

## Spring IoC
### IoC 发展简介
  - 好莱坞原则
  - 控制反转
  - DI
### IoC 主要实现策略
  - 依赖查找
  - 依赖注入
### IoC 容器的职责
  - 通用职责
    - 依赖处理
      - 依赖查找
      - 依赖注入
    - 生命周期管理
      - 容器
      - 托管的资源（Java Bean 或其他资源）
    - 配置
      - 容器配置
      - 外部化配置
      - 托管的资源（Java Bean 或其他资源）
### IoC 容器的实现
  - Java SE
    - Java Beans
    - Java ServiceLoader SPI
    - JNDI（Java Naming and Directory Interface）
  - Java EE
    - EJB（Enterprise Java Beans）
    - Servlet
  - 开源
    - Apache Avalon
    - PicoContainer
    - Google Guice
    - Spring Framework
### 传统 IoC 容器实现
  - Java Beans 作为 IoC 容器
    - 特性
      - 依赖查找
      - 生命周期管理
      - 配置元信息
      - 事件
      - 自定义
      - 资源管理
      - 持久化
    - 规范
      - JavaBeans
      - BeanContext

  - cn.abner.ioc.java.bean.BeanInfoDemo
### 轻量级 IoC 容器
  - 轻量级容器的特征：
    - 可管理应用代码 A container that can manage application code.
    - 快速启动 A container that is quick to start up.
    - 不需要复杂的配置 A container that doesn't require any special deployment steps to deploy objects within it. 
    - 轻量级内存占用以及最小的API依赖 A container that has such a light footprint and minimal API dependencies that it can be run in a variety of environments.
    - 容器需要管控渠道
  - 轻量级容器的好处：
    - 释放聚式容器
    - 最大化代码复用
    - 更大程度的面向对象
    - 更大化的产品化
    - 更好的可测试性
### 依赖查找 VS. 依赖注入
| 类型   | 依赖处理 | 实现便利性 | 代码侵入性  | API 依赖性  | 可读性 |
|------|------|-------|--------|----------|-----|
| 依赖查找 | 主动获取 | 相对繁琐  | 侵入业务逻辑 | 依赖容器API  | 良好  |
| 依赖注入 | 被动提供 | 相对便利  | 低侵入性   | 不依赖容器API | 一般  |

  根据当时的场景，因地制宜
### 构造器注入 VS. Setter 注入
  - Spring 团队通常是鼓励使用构造器注入的
  - Setter 注入应该仅用于可选
  - Setter 注入的优点：
    - JavaBean 属性在 IDE 是良好支持的
    - JavaBean 属性通常是自文档形式
    - JavaBean 属性
    - 如有必要可使用标准JavaBeans property-editor 类型转换
    - 一些创建好的JavaBeans 可不修改应用于基于JavaBean的IoC容器
  - Setter 注入缺点：
    - 属性注入无序
  - 构造器注入优点：
    - 初始化后，是个不变的对象
  - 构造器注入缺点：
    - 

---
### 问题：
1. 沙雕问题： 什么是IoC？

简单地说，IoC 是控制反转，类似于好莱坞原则，主要有依赖查找和依赖注入实现

2. 996问题：依赖查找和依赖注入有什么区别？

依赖查找是主动或手动的依赖查找方式，通常需要依赖容器或标准API实现。而依赖注入则是手动或自动依赖绑定的方式，无需特定的容器和API

3. 劝退题： Spring 作为 IoC 容器有什么优势？

- 典型的IoC管理，依赖查找和依赖注入
- AOP抽象
- 事务抽象
- 事件机制
- SPI扩展
- 强大的第三方整合
- 易测试性
- 更好的面向对象

--- 

## Spring IoC 容器概述
### Spring IoC 依赖查找
    示例：cn.abner.thinking.in.spring.ioc.overview.dependency.lookup.DependencyLookupDemo
  - 根据 Bean 名称查找
    - 实时查找
    - 延时查找
  - 根据 Bean 类型查找
    - 单个 Bean 对象
    - 集合 Bean 对象
  - 根据 Bean 名称 + 类型查找
  - 根据 Java 注解查找
    - 单个 Bean 对象
    - 集合 Bean 对象
### Spring IoC 依赖注入
    示例：cn.abner.thinking.in.spring.ioc.overview.dependency.injection.DependencyInjectionDemo
  - 根据 Bean 名称注入
  - 根据 Bean 类型注入
    - 单个 Bean 对象
    - 集合 Bean 对象
  - 注入容器内建 Bean 对象
  - 注入非 Bean 对象
  - 注入类型
    - 实时注入
    - 延迟注入
    
### Spring IoC 依赖来源

### Spring IoC 配置元信息

### Spring IoC 容器

### Spring 应用上下文

### 使用 Spring IoC 容器

### Spring IoC 容器生命周期

### 问题

--- 




