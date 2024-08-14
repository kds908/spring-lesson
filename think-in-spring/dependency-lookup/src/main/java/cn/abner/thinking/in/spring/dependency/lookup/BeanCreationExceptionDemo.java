package cn.abner.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * {@link org.springframework.beans.factory.BeanCreationException} 示例
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/8/14
 */
public class BeanCreationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());
        // 启动应用上下文
        applicationContext.refresh();

        applicationContext.close();
    }

    static class POJO implements InitializingBean {
        @PostConstruct  // CommonAnnotationBeanPostProcessor
        public void init() throws Throwable {
            throw new Throwable("init(): For purposes");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterPropertiesSet : For purposes");
        }
    }
}
