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

## 安全依赖查找

## 内建可查找的依赖

## 依赖查找中的经典异常

## 问题精选