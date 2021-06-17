package com.kmk.project2.bean;

/**
 * @author kemengkai
 * @create 2021-06-11 9:35
 */
public class Customer {

    private String name;
    private char gender;
    private Integer age;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String name, char gender, Integer age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //显示当前对象的信息
    public String info(){
        return name + "\t" + gender + "\t" + age + "\t" + phone + "\t" + email;
    }

    @Override
    public String toString() {
        return "Customer{" + "name='" + name + '\'' + ", gender=" + gender + ", age=" + age + ", phone='" + phone + '\''
            + ", email='" + email + '\'' + '}';
    }
}
