package com.agen.myagen.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "xx_admin", schema = "dbo", catalog = "geneshop")
public class XxAdmin {
    private int id;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private String department;
    private String email;
    private boolean isEnabled;
    private boolean isLocked;
    private Timestamp lockedDate;
    private Timestamp loginDate;
    private int loginFailureCount;
    private String loginIp;
    private String name;
    private String password;
    private String username;
    private String accessman;
    private String emailaddress;
    private String address;
    private String emailno;
    private String accessphone;
    private String jgbm;
    private Integer grade;
    private Integer order;
    private String treePath;
    private String cwLxdh;
    private String cwName;
    private String kfLxdh;
    private String kfName;
    private String swLxdh;
    private String swName;
    private String guid;
    private Boolean receiveEmail;
    private Boolean isFormal;
    private Boolean isHunan;
    private String jglx;
    private String wxaccount;
    private String wxlogo;
    private String hunanJgbm;
    private XxAdmin xxAdminByParent;


    @Id
    @Column(name = "id", nullable = false, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_date", nullable = false)
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "department", nullable = true, length = 255)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "is_enabled", nullable = false)
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Basic
    @Column(name = "is_locked", nullable = false)
    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Basic
    @Column(name = "locked_date", nullable = true)
    public Timestamp getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Timestamp lockedDate) {
        this.lockedDate = lockedDate;
    }

    @Basic
    @Column(name = "login_date", nullable = true)
    public Timestamp getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Timestamp loginDate) {
        this.loginDate = loginDate;
    }

    @Basic
    @Column(name = "login_failure_count", nullable = false)
    public int getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(int loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    @Basic
    @Column(name = "login_ip", nullable = true, length = 255)
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "accessman", nullable = true, length = 100)
    public String getAccessman() {
        return accessman;
    }

    public void setAccessman(String accessman) {
        this.accessman = accessman;
    }

    @Basic
    @Column(name = "emailaddress", nullable = true, length = 100)
    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "emailno", nullable = true, length = 100)
    public String getEmailno() {
        return emailno;
    }

    public void setEmailno(String emailno) {
        this.emailno = emailno;
    }

    @Basic
    @Column(name = "accessphone", nullable = true, length = 100)
    public String getAccessphone() {
        return accessphone;
    }

    public void setAccessphone(String accessphone) {
        this.accessphone = accessphone;
    }

    @Basic
    @Column(name = "jgbm", nullable = true, length = 255)
    public String getJgbm() {
        return jgbm;
    }

    public void setJgbm(String jgbm) {
        this.jgbm = jgbm;
    }

    @Basic
    @Column(name = "grade", nullable = true)
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "[order]", nullable = true)
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Basic
    @Column(name = "tree_path", nullable = true, length = 255)
    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    @Basic
    @Column(name = "cw_lxdh", nullable = true, length = 255)
    public String getCwLxdh() {
        return cwLxdh;
    }

    public void setCwLxdh(String cwLxdh) {
        this.cwLxdh = cwLxdh;
    }

    @Basic
    @Column(name = "cw_name", nullable = true, length = 255)
    public String getCwName() {
        return cwName;
    }

    public void setCwName(String cwName) {
        this.cwName = cwName;
    }

    @Basic
    @Column(name = "kf_lxdh", nullable = true, length = 255)
    public String getKfLxdh() {
        return kfLxdh;
    }

    public void setKfLxdh(String kfLxdh) {
        this.kfLxdh = kfLxdh;
    }

    @Basic
    @Column(name = "kf_name", nullable = true, length = 255)
    public String getKfName() {
        return kfName;
    }

    public void setKfName(String kfName) {
        this.kfName = kfName;
    }

    @Basic
    @Column(name = "sw_lxdh", nullable = true, length = 255)
    public String getSwLxdh() {
        return swLxdh;
    }

    public void setSwLxdh(String swLxdh) {
        this.swLxdh = swLxdh;
    }

    @Basic
    @Column(name = "sw_name", nullable = true, length = 255)
    public String getSwName() {
        return swName;
    }

    public void setSwName(String swName) {
        this.swName = swName;
    }

    @Basic
    @Column(name = "guid", nullable = true, length = 255)
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "receive_email", nullable = true)
    public Boolean getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(Boolean receiveEmail) {
        this.receiveEmail = receiveEmail;
    }

    @Basic
    @Column(name = "is_formal", nullable = true)
    public Boolean getFormal() {
        return isFormal;
    }

    public void setFormal(Boolean formal) {
        isFormal = formal;
    }

    @Basic
    @Column(name = "is_hunan", nullable = true)
    public Boolean getHunan() {
        return isHunan;
    }

    public void setHunan(Boolean hunan) {
        isHunan = hunan;
    }

    @Basic
    @Column(name = "jglx", nullable = true, length = 10)
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    @Basic
    @Column(name = "wxaccount", nullable = true, length = 255)
    public String getWxaccount() {
        return wxaccount;
    }

    public void setWxaccount(String wxaccount) {
        this.wxaccount = wxaccount;
    }

    @Basic
    @Column(name = "wxlogo", nullable = true, length = 255)
    public String getWxlogo() {
        return wxlogo;
    }

    public void setWxlogo(String wxlogo) {
        this.wxlogo = wxlogo;
    }

    @Basic
    @Column(name = "hunan_jgbm", nullable = true, length = 255)
    public String getHunanJgbm() {
        return hunanJgbm;
    }

    public void setHunanJgbm(String hunanJgbm) {
        this.hunanJgbm = hunanJgbm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XxAdmin xxAdmin = (XxAdmin) o;

        if (id != xxAdmin.id) return false;
        if (loginFailureCount != xxAdmin.loginFailureCount) return false;
        if (createDate != null ? !createDate.equals(xxAdmin.createDate) : xxAdmin.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(xxAdmin.modifyDate) : xxAdmin.modifyDate != null) return false;
        if (department != null ? !department.equals(xxAdmin.department) : xxAdmin.department != null) return false;
        if (email != null ? !email.equals(xxAdmin.email) : xxAdmin.email != null) return false;
        if (lockedDate != null ? !lockedDate.equals(xxAdmin.lockedDate) : xxAdmin.lockedDate != null) return false;
        if (loginDate != null ? !loginDate.equals(xxAdmin.loginDate) : xxAdmin.loginDate != null) return false;
        if (loginIp != null ? !loginIp.equals(xxAdmin.loginIp) : xxAdmin.loginIp != null) return false;
        if (name != null ? !name.equals(xxAdmin.name) : xxAdmin.name != null) return false;
        if (password != null ? !password.equals(xxAdmin.password) : xxAdmin.password != null) return false;
        if (username != null ? !username.equals(xxAdmin.username) : xxAdmin.username != null) return false;
        if (accessman != null ? !accessman.equals(xxAdmin.accessman) : xxAdmin.accessman != null) return false;
        if (emailaddress != null ? !emailaddress.equals(xxAdmin.emailaddress) : xxAdmin.emailaddress != null)
            return false;
        if (address != null ? !address.equals(xxAdmin.address) : xxAdmin.address != null) return false;
        if (emailno != null ? !emailno.equals(xxAdmin.emailno) : xxAdmin.emailno != null) return false;
        if (accessphone != null ? !accessphone.equals(xxAdmin.accessphone) : xxAdmin.accessphone != null) return false;
        if (jgbm != null ? !jgbm.equals(xxAdmin.jgbm) : xxAdmin.jgbm != null) return false;
        if (grade != null ? !grade.equals(xxAdmin.grade) : xxAdmin.grade != null) return false;
        if (order != null ? !order.equals(xxAdmin.order) : xxAdmin.order != null) return false;
        if (treePath != null ? !treePath.equals(xxAdmin.treePath) : xxAdmin.treePath != null) return false;
        if (cwLxdh != null ? !cwLxdh.equals(xxAdmin.cwLxdh) : xxAdmin.cwLxdh != null) return false;
        if (cwName != null ? !cwName.equals(xxAdmin.cwName) : xxAdmin.cwName != null) return false;
        if (kfLxdh != null ? !kfLxdh.equals(xxAdmin.kfLxdh) : xxAdmin.kfLxdh != null) return false;
        if (kfName != null ? !kfName.equals(xxAdmin.kfName) : xxAdmin.kfName != null) return false;
        if (swLxdh != null ? !swLxdh.equals(xxAdmin.swLxdh) : xxAdmin.swLxdh != null) return false;
        if (swName != null ? !swName.equals(xxAdmin.swName) : xxAdmin.swName != null) return false;
        if (guid != null ? !guid.equals(xxAdmin.guid) : xxAdmin.guid != null) return false;
        if (receiveEmail != null ? !receiveEmail.equals(xxAdmin.receiveEmail) : xxAdmin.receiveEmail != null)
            return false;
        if (jglx != null ? !jglx.equals(xxAdmin.jglx) : xxAdmin.jglx != null) return false;
        if (wxaccount != null ? !wxaccount.equals(xxAdmin.wxaccount) : xxAdmin.wxaccount != null) return false;
        if (wxlogo != null ? !wxlogo.equals(xxAdmin.wxlogo) : xxAdmin.wxlogo != null) return false;
        if (hunanJgbm != null ? !hunanJgbm.equals(xxAdmin.hunanJgbm) : xxAdmin.hunanJgbm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lockedDate != null ? lockedDate.hashCode() : 0);
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        result = 31 * result + loginFailureCount;
        result = 31 * result + (loginIp != null ? loginIp.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (accessman != null ? accessman.hashCode() : 0);
        result = 31 * result + (emailaddress != null ? emailaddress.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (emailno != null ? emailno.hashCode() : 0);
        result = 31 * result + (accessphone != null ? accessphone.hashCode() : 0);
        result = 31 * result + (jgbm != null ? jgbm.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (treePath != null ? treePath.hashCode() : 0);
        result = 31 * result + (cwLxdh != null ? cwLxdh.hashCode() : 0);
        result = 31 * result + (cwName != null ? cwName.hashCode() : 0);
        result = 31 * result + (kfLxdh != null ? kfLxdh.hashCode() : 0);
        result = 31 * result + (kfName != null ? kfName.hashCode() : 0);
        result = 31 * result + (swLxdh != null ? swLxdh.hashCode() : 0);
        result = 31 * result + (swName != null ? swName.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (receiveEmail != null ? receiveEmail.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (wxaccount != null ? wxaccount.hashCode() : 0);
        result = 31 * result + (wxlogo != null ? wxlogo.hashCode() : 0);
        result = 31 * result + (hunanJgbm != null ? hunanJgbm.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName = "id")
    public XxAdmin getXxAdminByParent() {
        return xxAdminByParent;
    }

    public void setXxAdminByParent(XxAdmin xxAdminByParent) {
        this.xxAdminByParent = xxAdminByParent;
    }


}
