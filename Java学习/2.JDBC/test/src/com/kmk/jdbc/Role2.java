package com.kmk.jdbc;

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
public class Role2 {

    Long id;
    String roleName;
    String remark;
    Long parentId;
    Integer sort;
    Timestamp updateTime;
    Timestamp createTime;

    public Role2() {
    }

    public Role2(Long id, String roleName, String remark, Long parentId, Integer sort, Timestamp updateTime,
        Timestamp createTime) {
        this.id = id;
        this.roleName = roleName;
        this.remark = remark;
        this.parentId = parentId;
        this.sort = sort;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Role2 employee = (Role2)o;
        return Objects.equals(id, employee.id) && Objects.equals(roleName, employee.roleName) && Objects
            .equals(remark, employee.remark) && Objects.equals(parentId, employee.parentId) && Objects
            .equals(sort, employee.sort) && Objects.equals(updateTime, employee.updateTime) && Objects
            .equals(createTime, employee.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, remark, parentId, sort, updateTime, createTime);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", roleName='" + roleName + '\'' + ", remark='" + remark + '\''
            + ", parentId=" + parentId + ", sort=" + sort + ", updateTime=" + updateTime + ", createTime=" + createTime
            + '}';
    }
}
