package cn.abner.thinking.in.spring.bean.definition;

import cn.abner.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * 注解 BeanDefinition 示例
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/8/5 16:23
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) // 3. 通过 @Import 来进行导入
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class （配置类）
        applicationContext.register(Config.class);
        // 通过 BeanDefinition 注册 API 实现
        // 1. 命名 Bean 注册方式
        registerBeanDefinition(applicationContext, "as-user");
        // 2. 非命名 Bean 注册方式
        registerBeanDefinition(applicationContext);

        applicationContext.refresh();

        System.out.println("Config 类型所有 Beans：" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型所有 Beans：" + applicationContext.getBeansOfType(User.class));
        // 显式地关闭 spring 应用上下文
        applicationContext.close();
    }

    /**
     * 有命名 Bean 的注册方式
     * @param registry
     * @param beanName
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1L)
                .addPropertyValue("name", "abner");

        // 判断如果 beanName 参数存在
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名的 Bean 注册方法
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null);
    }

    // 2. 通过 @Component 方式
    @Component // 定义当前类作为 Spring Bean 组件
    public static class Config {
        // 1. 通过 @Bean 方式定义
        @Bean(name = {"user", "abner-user"})
        public User user() {
            User user = new User();
            user.setId(111);
            user.setName("abner");
            return user;
        }
    }
}
