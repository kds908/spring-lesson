package cn.abner.thinking.in.spring.ioc.overview.dependency.injection;

import cn.abner.thinking.in.spring.ioc.overview.annotation.Super;
import cn.abner.thinking.in.spring.ioc.overview.domain.User;
import cn.abner.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository repository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(repository.getUsers());
        // ⬇️ 依赖注入 org.springframework.beans.factory.support.DefaultListableBeanFactory
        System.out.println(repository.getBeanFactory());
        // ⬇️ false
        System.out.println(repository.getBeanFactory() == beanFactory);
        // ⬇️ 依赖查找 (错误代码 ⬇) No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userFactory = repository.getUserObjectFactory();
        // ⬇️ true
        System.out.println(userFactory.getObject() == beanFactory);
        System.out.println(userFactory.getObject());
    }
}
