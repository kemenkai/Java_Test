package com.kmk.jdbc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author kemengkai
 * @create 2021-08-20 11:17
 *
 * ORM编程思想(Object relational mapping)
 * 一个数据表对应一个java类
 * 表中的一条记录对应java类的一个对象
 * 表中的一个字段对应java类的一个属性
 */
public class Role {

    Long id;
    String role_name;
    String remark;
    Long parent_id;
    Integer sort;
    Timestamp update_time;
    Timestamp create_time;

    public Role() {
    }

    public Role(Long id, String role_name, String remark, Long parent_id, Integer sort, Timestamp update_time,
        Timestamp create_time) {
        this.id = id;
        this.role_name = role_name;
        this.remark = remark;
        this.parent_id = parent_id;
        this.sort = sort;
        this.update_time = update_time;
        this.create_time = create_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Role employee = (Role)o;
        return Objects.equals(id, employee.id) && Objects.equals(role_name, employee.role_name) && Objects
            .equals(remark, employee.remark) && Objects.equals(parent_id, employee.parent_id) && Objects
            .equals(sort, employee.sort) && Objects.equals(update_time, employee.update_time) && Objects
            .equals(create_time, employee.create_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role_name, remark, parent_id, sort, update_time, create_time);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", roleName='" + role_name + '\'' + ", remark='" + remark + '\''
            + ", parentId=" + parent_id + ", sort=" + sort + ", updateTime=" + update_time + ", createTime=" + create_time
            + '}';
    }
}
