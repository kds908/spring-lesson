package cn.abner.ioc.java.beans;

/**
 * 描述人的 POJO 类
 *
 * setter / getter 方法
 * 可写（Writable）/ 可读（Readable）方法
 * <p>
 *
 * @author: Abner Song
 * <p>
 */
public class Person {
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
