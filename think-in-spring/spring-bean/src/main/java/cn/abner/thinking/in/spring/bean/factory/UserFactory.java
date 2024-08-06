package cn.abner.thinking.in.spring.bean.factory;

import cn.abner.thinking.in.spring.ioc.overview.domain.User;

/**
 * 工厂类
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}
