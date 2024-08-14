# Spring IoC 依赖查找

## 依赖查找前世今生
- 单一类型查找
  - JNDI - Javax.naming.Contex#lookup(javax.naming.Name)
  - JavaBeans - java.beans.beancontext.BeanContext
- 集合类型查找
  - java.beans.beancontext.BeanContext
- 层次性依赖查找
  - java.beans.beancontext.BeanContext

## 单一类型依赖查找
      示例：cn.abner.thinking.in.spring.dependency.lookup.ObjectProviderDemo
如何查找已知类型或类型的 Bean 对象
- 根据 Bean 名称查找
  - getBean(String)
  - Spring 2.5 覆盖默认参数： getBean(String, Object...)
- 根据 Bean 类型查找
  - Bean 实时查找
    - Spring 3.0 getBean(Class)
    - Spring 4.1 覆盖默认参数：getBean(Class, Object...)
  - Spring 5.1 Bean 延迟查找
    - getBeanProvider(Class)
    - getBeanProvider(ResolvableType)
  - 根据 Bean 名称 + 类型查找：getBean(String, Class)
  
## 集合类型依赖查找
ListableBeanFactory
- 根据 Bean 类型查找
  - 获取同类型 Bean 名称列表
    - getBeanNamesForType(Class)
    - Spring 4.2 getBeanNamesForType(ResolvableType)
  - 获取同类型 Bean 实例列表
    - getBeansOfType(Class) 以及重载方法
- 通过注解类型查找
  - Spring 3.0 获取标注类型 Bean 名称列表
    - getBeanNamesForAnnotation(Class<? extends Annotation>)
  - Spring 3.0 获取标注类型 Bean 实例列表
    - getBeansWithAnnotation(Class<? extends Annotation>)
  - Spring 3.0 获取指定名称 + 标注类型 Bean 实例
    - findAnnotationOnBean(String, Class<? extends Annotation>)
## 层次性依赖查找
      示例：cn.abner.thinking.in.spring.dependency.lookup.HierarchicalDependencyLookupDemo
HierarchicalBeanFactory
- 双亲 BeanFactory：getParentBeanFactory()
- 层次性查找
  - 根据 Bean 名称查找
    - 基于 containsLocalBean 方法实现
  - 根据 Bean 类型查找实例列表
    - 单一类型：BeanFactoryUtils#beanOfType
    - 集合类型：BeanFactoryUtils#beansOfTypeIncludingAncestors
  - 根据 Java 注解查找名称列表
    - BeanFactoryUtils#beanNamesForTypeIncludingAncestors
## 延迟依赖查找
      示例：
        cn.abner.thinking.in.spring.dependency.lookup.ObjectProviderDemo#lookupIfAvailable
        cn.abner.thinking.in.spring.dependency.lookup.ObjectProviderDemo#lookupByStreamOps
- org.springframework.beans.factory.ObjectFactory
- org.springframework.beans.factory.ObjectProvider
  - Spring 5 对 Java 8 特性扩展
    - 函数式接口
      - getIfAvailable
    - Stream扩展
## 安全依赖查找
### 依赖查找安全性对比
    示例：cn.abner.thinking.in.spring.dependency.lookup.TypeSafetyDependencyLookupDemo
| 依赖查找类型 | 代表实现                               | 是否安全 |
|--------|------------------------------------|------|
| 单一类型查找 | BeanFactory#getBean                | 否    |
|        | ObjectFactory#getObject            | 否    |
|        | ObjectProvider#getIfAvailable      | 是    |
| 集合类型查找 | ListableBeanFactory#getBeansOfType | 是    |
|        | ObjectProvider#stream              | 是    |
## 内建可查找的依赖
### AbstractApplicationContext 内建可查找的依赖
| Bean 名称                     | Bean 实例                        | 使用场景               |
|-----------------------------|--------------------------------|--------------------|
| environment                 | Environment 对象                 | 外部化配置以及 Profiles   |
| systemProperties            | java.util.Properties 对象        | Java系统属性           |
| systemEnvironment           | java.util.Map 对象               | 操作系统环境变量           |
| messageSource               | MessageSource 对象               | 国际化文案              |
| LifecycleProcessor          | LifecycleProcessor 对象          | Lifecycle Bean 处理器 |
| applicationEventMulticaster | ApplicationEventMulticaster 对象 | Spring 事件广播器       |
### 注解驱动 Spring 应用上下文内建可查找的依赖
| Bean 名称                                                                         | Bean 实例                                   | 使用场景                                            |
|---------------------------------------------------------------------------------|-------------------------------------------|-------------------------------------------------|
| org.springframework.context.annotation.internalConfigurationAnnotationProcessor | ConfigurationClassPostProcessor 对象        | 处理 Spring 配置类                                   |
| org.springframework.context.annotation.internalAutowiredAnnotationProcessor     | AutowiredAnnotationBeanPostProcessor 对象   | 处理 @Autowired 以及 @Value 注解                      |
| org.springframework.context.annotation.internalCommonAnnotationProcessor        | CommonAnnotationBeanPostProcessor 对象      | （条件激活）处理 JSR-250 注解，如 @PostConstruct            |
| org.springframework.context.annotation.internalEventListenerProcessor           | EventListenerMethodProcessor 对象           | 处理标 @EventListener 的 Spring 事件监听方法              |
| org.springframework.context.annotation.internalEventListenerFactory             | DefaultEventListenerFactory 对象            | 处理标 @EventListener 事件监听方法适配为ApplicationListener |
| org.springframework.context.annotation.internalPersistenceAnnotationProcessor   | PersistenceAnnotationBeanPostProcessor 对象 | （条件激活）处理JPA注解场景                                 |
## 依赖查找中的经典异常
### BeansException 子类型
      示例：
          cn.abner.thinking.in.spring.dependency.lookup.NoUniqueBeanDefinitionExceptionDemo
          cn.abner.thinking.in.spring.dependency.lookup.BeanInstantiationExceptionDemo
          cn.abner.thinking.in.spring.dependency.lookup.BeanCreationExceptionDemo
### 注解驱动 Spring 应用上下文内建可查找的依赖
| Bean 名称                         | Bean 实例                   | 使用场景                                            |
|---------------------------------|---------------------------|-------------------------------------------------|
| NoSuchBeanDefinitionException   | 当查找 Bean 不存在于 IoC 容器时     | BeanFactory#getBean<br/>ObjectFactory#getObject | 
| NoUniqueBeanDefinitionException | 类型依赖查找时，IoC 容器存在多个Bean 实例 | BeanFactory#getBean(Class)                      | 
| BeanInstantiationException      | 当 Bean 所对应的类型非具体类时        | BeanFactory#getBean                             | 
| BeanCreationException           | 当 Bean 初始化过程中             | Bean 初始化方法执行异常                                  | 
| BeanDefinitionStoreException    | 当 BeanDefinition 配置元信息非法时 | XML 配置资源无法打开时                                   | 
## 问题精选
**沙雕题：** ObjectFactory 与 BeanFactory 的区别？
答：均提供依赖查找能力，
不过ObjectFactory 仅关注一个或一种类型的 Bean 依赖查找，并且自身不具备依赖查找能力，能力由 BeanFactory 输出。
BeanFactory 提供了单一类型、集合类型以及层次型多种依赖查找方式
**996问题：** BeanFactory.getBean 是否是线程安全的？
是线程安全的，执行过程中会加互斥锁
****