package cn.abner.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.annotation.Inherited;

/**
 * 默认 {@link UserFactory} 实现
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    // 1.基于 @PostConstruct 注解
    @PostConstruct
    public void init() {
        System.out.println("UserFactory 初始化 : @PostConstruct");
    }

    public void initUserFactory() {
        System.out.println("自定义初始化方法：UserFactory 初始化");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet : UserFactory 初始化");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy : UserFactory 销毁");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy : UserFactory 销毁");
    }

    public void doDestroy() {
        System.out.println("自定义销毁方法 doDestroy ：UserFactory 销毁");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 DefaultFactory 正在被回收");
    }
}
