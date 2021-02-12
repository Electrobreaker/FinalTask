package com.FinalTask.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer roleId;
    private String roleName;


    public Role(Integer id, String name) {
        this.roleId = id;
        this.roleName = name;
    }

    public Integer getId() {
        return roleId;
    }

    public void setId(Integer id) {
        this.roleId = id;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }

//    @XmlTransient
//    public Collection<Users> getUsersCollection() {
//        return usersCollection;
//    }

//    public void setUsersCollection(Collection<Users> usersCollection) {
//        this.usersCollection = usersCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newp.Role[ id=" + roleId + " ]";
    }
}
