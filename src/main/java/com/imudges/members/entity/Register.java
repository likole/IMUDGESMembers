package com.imudges.members.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by likole on 10/23/17.
 */
@Entity
public class Register {
    private String ak;
    private String sk;

    @Id
    @Column(name = "ak")
    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    @Basic
    @Column(name = "sk")
    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Register register = (Register) o;

        if (ak != null ? !ak.equals(register.ak) : register.ak != null) return false;
        if (sk != null ? !sk.equals(register.sk) : register.sk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ak != null ? ak.hashCode() : 0;
        result = 31 * result + (sk != null ? sk.hashCode() : 0);
        return result;
    }
}
