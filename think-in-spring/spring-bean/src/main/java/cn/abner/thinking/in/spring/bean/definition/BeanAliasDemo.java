package cn.abner.thinking.in.spring.bean.definition;

import cn.abner.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User user = beanFactory.getBean("user", User.class);
        User abnerUser = beanFactory.getBean("abner-user", User.class);
        System.out.println("abner-user 是否与 user Bean 相同：" + (user == abnerUser));
    }
}
