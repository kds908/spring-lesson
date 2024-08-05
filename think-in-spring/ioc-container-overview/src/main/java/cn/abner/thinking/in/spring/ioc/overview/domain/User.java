package cn.abner.thinking.in.spring.ioc.overview.domain;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/7/31 18:03
 */
public class User {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(111);
        user.setName("abner");
        return user;
    }
}
