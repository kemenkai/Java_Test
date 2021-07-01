package com.kmk.java4;

import java.util.Objects;

/**
 * @author kemengkai
 * @create 2021-06-18 8:53
 */
public class Man extends Person {

    boolean isSmoking;
    int id = 1002;
    String aa;

    public void earnMoney() {
        System.out.println("男人负责挣钱养家");
    }

    public void eat() {
        System.out.println("男人多吃肉，长肌肉");
    }

    public void walk() {
        System.out.println("男人霸气的走路");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Man man = (Man)o;
        return isSmoking == man.isSmoking && id == man.id && Objects.equals(aa, man.aa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSmoking, id, aa);
    }
}
