package cn.abner.thinking.in.spring.ioc.overview.dependency.injection;

import cn.abner.thinking.in.spring.ioc.overview.annotation.Super;
import cn.abner.thinking.in.spring.ioc.overview.domain.User;
import cn.abner.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/7/31 18:01
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // ApplicationContext is a Sub-interface of BeanFactory
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        // 依赖来源一：自定义 Bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
//        System.out.println(repository.getUsers());
        // ⬇️ 依赖来源二：依赖注入（内建依赖） org.springframework.beans.factory.support.DefaultListableBeanFactory
        System.out.println(userRepository.getBeanFactory());
        // ⬇️ false
        System.out.println(userRepository.getBeanFactory() == applicationContext);
        // ⬇️ 依赖查找 (错误代码 ⬇) No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userFactory = userRepository.getUserObjectFactory();
        // ⬇️ true
        System.out.println(userFactory.getObject() == applicationContext);
        System.out.println(userFactory.getObject());

        // 依赖来源三：容器内建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }

    private static void whoIsIoCContainer(UserRepository repository, BeanFactory beanFactory) {
        // ConfigurableApplicationContext <- ApplicationContext <-
        // 这个等式为什么不成立？
        System.out.println(repository.getBeanFactory() == beanFactory);

    }
}
