package cn.abner.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public class ObjectProviderDemo {   // @Configuration 是非必须注解
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        lookupByObjectProvider(applicationContext);

        applicationContext.close();
    }

    @Bean
    public String helloWorld() {  // 方法名即为 Bean 名称
        return "Hello, World";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
    }
}
