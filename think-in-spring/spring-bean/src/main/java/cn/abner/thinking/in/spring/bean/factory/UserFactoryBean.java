package cn.abner.thinking.in.spring.bean.factory;

import cn.abner.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link cn.abner.thinking.in.spring.ioc.overview.domain.User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
