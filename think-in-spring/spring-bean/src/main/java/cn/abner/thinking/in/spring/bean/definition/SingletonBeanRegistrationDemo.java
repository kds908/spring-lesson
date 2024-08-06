package cn.abner.thinking.in.spring.bean.definition;

import cn.abner.thinking.in.spring.bean.factory.DefaultUserFactory;
import cn.abner.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体 Bean 注册示例
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 创建一个外部对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 注册外部单例对象
        beanFactory.registerSingleton("userFactory", userFactory);
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 通过依赖查找的方式获取 UserFactory
        UserFactory userFactoryLookUp = beanFactory.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == userFactoryLookUp: " + (userFactory == userFactoryLookUp));

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }
}
