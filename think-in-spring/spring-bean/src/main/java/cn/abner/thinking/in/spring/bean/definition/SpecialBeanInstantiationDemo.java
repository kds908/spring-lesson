package cn.abner.thinking.in.spring.bean.definition;

import cn.abner.thinking.in.spring.bean.factory.DefaultUserFactory;
import cn.abner.thinking.in.spring.bean.factory.UserFactory;
import cn.abner.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation-context.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/special-bean-instantiation-context.xml");
        // 通过 applicationcontext 获取 AutowireCapableBeanFactory 实现
//        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(serviceLoader);
        demoServiceLoader();
        // 创建 UserFacoty 对象，通过 AutowireCapableBeanFactory 实现
//        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
//        userFactory.createUser();
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
