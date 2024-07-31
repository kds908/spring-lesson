package cn.abner.thinking.in.spring.ioc.overview.dependency.lookup;

import cn.abner.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖查找示例
 * 1。通过名称查找
 * 2。通过类型查找
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/7/31 18:01
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置 xml 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        lookupInTime(beanFactory);
        lookupLazy(beanFactory);

    }

    private static void lookupLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    private static void lookupInTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }
}
