package com.agen.myagen.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "xx_member", schema = "dbo", catalog = "geneshop")
public class XxMember {
    private int id;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private String address;
    private BigDecimal amount;
    private String attributeValue0;
    private String attributeValue1;
    private String attributeValue2;
    private String attributeValue3;
    private String attributeValue4;
    private String attributeValue5;
    private String attributeValue6;
    private String attributeValue7;
    private String attributeValue8;
    private String attributeValue9;
    private BigDecimal balance;
    private Timestamp birth;
    private String email;
    private Integer gender;
    private boolean isEnabled;
    private boolean isLocked;
    private Timestamp lockedDate;
    private Timestamp loginDate;
    private int loginFailureCount;
    private String loginIp;
    private String loginPluginId;
    private String mobile;
    private String name;
    private String nickname;
    private String openId;
    private String password;
    private String phone;
    private int point;
    private String registerIp;
    private Timestamp safeKeyExpire;
    private String safeKeyValue;
    private String username;
    private String zipCode;
    private String memberno;
    private String insno;
    private String guid;
    private String sampleGuid;
    private Timestamp enableDate;
    private String isShow;
    private Boolean isSendSms;
    private Boolean isSendEmail;
    private Boolean isConfirm;
    private String wxaccount;
    private String bankCardNumber;


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
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 12)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "attribute_value0", nullable = true, length = 255)
    public String getAttributeValue0() {
        return attributeValue0;
    }

    public void setAttributeValue0(String attributeValue0) {
        this.attributeValue0 = attributeValue0;
    }

    @Basic
    @Column(name = "attribute_value1", nullable = true, length = 255)
    public String getAttributeValue1() {
        return attributeValue1;
    }

    public void setAttributeValue1(String attributeValue1) {
        this.attributeValue1 = attributeValue1;
    }

    @Basic
    @Column(name = "attribute_value2", nullable = true, length = 255)
    public String getAttributeValue2() {
        return attributeValue2;
    }

    public void setAttributeValue2(String attributeValue2) {
        this.attributeValue2 = attributeValue2;
    }

    @Basic
    @Column(name = "attribute_value3", nullable = true, length = 255)
    public String getAttributeValue3() {
        return attributeValue3;
    }

    public void setAttributeValue3(String attributeValue3) {
        this.attributeValue3 = attributeValue3;
    }

    @Basic
    @Column(name = "attribute_value4", nullable = true, length = 255)
    public String getAttributeValue4() {
        return attributeValue4;
    }

    public void setAttributeValue4(String attributeValue4) {
        this.attributeValue4 = attributeValue4;
    }

    @Basic
    @Column(name = "attribute_value5", nullable = true, length = 255)
    public String getAttributeValue5() {
        return attributeValue5;
    }

    public void setAttributeValue5(String attributeValue5) {
        this.attributeValue5 = attributeValue5;
    }

    @Basic
    @Column(name = "attribute_value6", nullable = true, length = 255)
    public String getAttributeValue6() {
        return attributeValue6;
    }

    public void setAttributeValue6(String attributeValue6) {
        this.attributeValue6 = attributeValue6;
    }

    @Basic
    @Column(name = "attribute_value7", nullable = true, length = 255)
    public String getAttributeValue7() {
        return attributeValue7;
    }

    public void setAttributeValue7(String attributeValue7) {
        this.attributeValue7 = attributeValue7;
    }

    @Basic
    @Column(name = "attribute_value8", nullable = true, length = 255)
    public String getAttributeValue8() {
        return attributeValue8;
    }

    public void setAttributeValue8(String attributeValue8) {
        this.attributeValue8 = attributeValue8;
    }

    @Basic
    @Column(name = "attribute_value9", nullable = true, length = 255)
    public String getAttributeValue9() {
        return attributeValue9;
    }

    public void setAttributeValue9(String attributeValue9) {
        this.attributeValue9 = attributeValue9;
    }

    @Basic
    @Column(name = "balance", nullable = false, precision = 12)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "birth", nullable = true)
    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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
    @Column(name = "login_plugin_id", nullable = true, length = 100)
    public String getLoginPluginId() {
        return loginPluginId;
    }

    public void setLoginPluginId(String loginPluginId) {
        this.loginPluginId = loginPluginId;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 255)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
    @Column(name = "nickname", nullable = true, length = 255)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "open_id", nullable = true, length = 100)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "point", nullable = false, precision = 0)
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Basic
    @Column(name = "register_ip", nullable = false, length = 255)
    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    @Basic
    @Column(name = "safe_key_expire", nullable = true)
    public Timestamp getSafeKeyExpire() {
        return safeKeyExpire;
    }

    public void setSafeKeyExpire(Timestamp safeKeyExpire) {
        this.safeKeyExpire = safeKeyExpire;
    }

    @Basic
    @Column(name = "safe_key_value", nullable = true, length = 255)
    public String getSafeKeyValue() {
        return safeKeyValue;
    }

    public void setSafeKeyValue(String safeKeyValue) {
        this.safeKeyValue = safeKeyValue;
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
    @Column(name = "zip_code", nullable = true, length = 255)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "memberno", nullable = true, length = 50)
    public String getMemberno() {
        return memberno;
    }

    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }

    @Basic
    @Column(name = "insno", nullable = true, length = 50)
    public String getInsno() {
        return insno;
    }

    public void setInsno(String insno) {
        this.insno = insno;
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
    @Column(name = "sample_guid", nullable = true, length = 255)
    public String getSampleGuid() {
        return sampleGuid;
    }

    public void setSampleGuid(String sampleGuid) {
        this.sampleGuid = sampleGuid;
    }

    @Basic
    @Column(name = "enable_date", nullable = true)
    public Timestamp getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(Timestamp enableDate) {
        this.enableDate = enableDate;
    }

    @Basic
    @Column(name = "is_show", nullable = true, length = 10)
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    @Basic
    @Column(name = "is_send_sms", nullable = true)
    public Boolean getSendSms() {
        return isSendSms;
    }

    public void setSendSms(Boolean sendSms) {
        isSendSms = sendSms;
    }

    @Basic
    @Column(name = "is_send_email", nullable = true)
    public Boolean getSendEmail() {
        return isSendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        isSendEmail = sendEmail;
    }

    @Basic
    @Column(name = "is_confirm", nullable = true)
    public Boolean getConfirm() {
        return isConfirm;
    }

    public void setConfirm(Boolean confirm) {
        isConfirm = confirm;
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
    @Column(name = "bank_card_number", nullable = true, length = 255)
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XxMember xxMember = (XxMember) o;

        if (id != xxMember.id) return false;
        if (isEnabled != xxMember.isEnabled) return false;
        if (isLocked != xxMember.isLocked) return false;
        if (loginFailureCount != xxMember.loginFailureCount) return false;
        if (point != xxMember.point) return false;
        if (createDate != null ? !createDate.equals(xxMember.createDate) : xxMember.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(xxMember.modifyDate) : xxMember.modifyDate != null) return false;
        if (address != null ? !address.equals(xxMember.address) : xxMember.address != null) return false;
        if (amount != null ? !amount.equals(xxMember.amount) : xxMember.amount != null) return false;
        if (attributeValue0 != null ? !attributeValue0.equals(xxMember.attributeValue0) : xxMember.attributeValue0 != null)
            return false;
        if (attributeValue1 != null ? !attributeValue1.equals(xxMember.attributeValue1) : xxMember.attributeValue1 != null)
            return false;
        if (attributeValue2 != null ? !attributeValue2.equals(xxMember.attributeValue2) : xxMember.attributeValue2 != null)
            return false;
        if (attributeValue3 != null ? !attributeValue3.equals(xxMember.attributeValue3) : xxMember.attributeValue3 != null)
            return false;
        if (attributeValue4 != null ? !attributeValue4.equals(xxMember.attributeValue4) : xxMember.attributeValue4 != null)
            return false;
        if (attributeValue5 != null ? !attributeValue5.equals(xxMember.attributeValue5) : xxMember.attributeValue5 != null)
            return false;
        if (attributeValue6 != null ? !attributeValue6.equals(xxMember.attributeValue6) : xxMember.attributeValue6 != null)
            return false;
        if (attributeValue7 != null ? !attributeValue7.equals(xxMember.attributeValue7) : xxMember.attributeValue7 != null)
            return false;
        if (attributeValue8 != null ? !attributeValue8.equals(xxMember.attributeValue8) : xxMember.attributeValue8 != null)
            return false;
        if (attributeValue9 != null ? !attributeValue9.equals(xxMember.attributeValue9) : xxMember.attributeValue9 != null)
            return false;
        if (balance != null ? !balance.equals(xxMember.balance) : xxMember.balance != null) return false;
        if (birth != null ? !birth.equals(xxMember.birth) : xxMember.birth != null) return false;
        if (email != null ? !email.equals(xxMember.email) : xxMember.email != null) return false;
        if (gender != null ? !gender.equals(xxMember.gender) : xxMember.gender != null) return false;
        if (lockedDate != null ? !lockedDate.equals(xxMember.lockedDate) : xxMember.lockedDate != null) return false;
        if (loginDate != null ? !loginDate.equals(xxMember.loginDate) : xxMember.loginDate != null) return false;
        if (loginIp != null ? !loginIp.equals(xxMember.loginIp) : xxMember.loginIp != null) return false;
        if (loginPluginId != null ? !loginPluginId.equals(xxMember.loginPluginId) : xxMember.loginPluginId != null)
            return false;
        if (mobile != null ? !mobile.equals(xxMember.mobile) : xxMember.mobile != null) return false;
        if (name != null ? !name.equals(xxMember.name) : xxMember.name != null) return false;
        if (nickname != null ? !nickname.equals(xxMember.nickname) : xxMember.nickname != null) return false;
        if (openId != null ? !openId.equals(xxMember.openId) : xxMember.openId != null) return false;
        if (password != null ? !password.equals(xxMember.password) : xxMember.password != null) return false;
        if (phone != null ? !phone.equals(xxMember.phone) : xxMember.phone != null) return false;
        if (registerIp != null ? !registerIp.equals(xxMember.registerIp) : xxMember.registerIp != null) return false;
        if (safeKeyExpire != null ? !safeKeyExpire.equals(xxMember.safeKeyExpire) : xxMember.safeKeyExpire != null)
            return false;
        if (safeKeyValue != null ? !safeKeyValue.equals(xxMember.safeKeyValue) : xxMember.safeKeyValue != null)
            return false;
        if (username != null ? !username.equals(xxMember.username) : xxMember.username != null) return false;
        if (zipCode != null ? !zipCode.equals(xxMember.zipCode) : xxMember.zipCode != null) return false;
        if (memberno != null ? !memberno.equals(xxMember.memberno) : xxMember.memberno != null) return false;
        if (insno != null ? !insno.equals(xxMember.insno) : xxMember.insno != null) return false;
        if (guid != null ? !guid.equals(xxMember.guid) : xxMember.guid != null) return false;
        if (sampleGuid != null ? !sampleGuid.equals(xxMember.sampleGuid) : xxMember.sampleGuid != null) return false;
        if (enableDate != null ? !enableDate.equals(xxMember.enableDate) : xxMember.enableDate != null) return false;
        if (isShow != null ? !isShow.equals(xxMember.isShow) : xxMember.isShow != null) return false;
        if (isSendSms != null ? !isSendSms.equals(xxMember.isSendSms) : xxMember.isSendSms != null) return false;
        if (isSendEmail != null ? !isSendEmail.equals(xxMember.isSendEmail) : xxMember.isSendEmail != null)
            return false;
        if (isConfirm != null ? !isConfirm.equals(xxMember.isConfirm) : xxMember.isConfirm != null) return false;
        if (wxaccount != null ? !wxaccount.equals(xxMember.wxaccount) : xxMember.wxaccount != null) return false;
        if (bankCardNumber != null ? !bankCardNumber.equals(xxMember.bankCardNumber) : xxMember.bankCardNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (attributeValue0 != null ? attributeValue0.hashCode() : 0);
        result = 31 * result + (attributeValue1 != null ? attributeValue1.hashCode() : 0);
        result = 31 * result + (attributeValue2 != null ? attributeValue2.hashCode() : 0);
        result = 31 * result + (attributeValue3 != null ? attributeValue3.hashCode() : 0);
        result = 31 * result + (attributeValue4 != null ? attributeValue4.hashCode() : 0);
        result = 31 * result + (attributeValue5 != null ? attributeValue5.hashCode() : 0);
        result = 31 * result + (attributeValue6 != null ? attributeValue6.hashCode() : 0);
        result = 31 * result + (attributeValue7 != null ? attributeValue7.hashCode() : 0);
        result = 31 * result + (attributeValue8 != null ? attributeValue8.hashCode() : 0);
        result = 31 * result + (attributeValue9 != null ? attributeValue9.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        result = 31 * result + (isLocked ? 1 : 0);
        result = 31 * result + (lockedDate != null ? lockedDate.hashCode() : 0);
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        result = 31 * result + loginFailureCount;
        result = 31 * result + (loginIp != null ? loginIp.hashCode() : 0);
        result = 31 * result + (loginPluginId != null ? loginPluginId.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + point;
        result = 31 * result + (registerIp != null ? registerIp.hashCode() : 0);
        result = 31 * result + (safeKeyExpire != null ? safeKeyExpire.hashCode() : 0);
        result = 31 * result + (safeKeyValue != null ? safeKeyValue.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (memberno != null ? memberno.hashCode() : 0);
        result = 31 * result + (insno != null ? insno.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (sampleGuid != null ? sampleGuid.hashCode() : 0);
        result = 31 * result + (enableDate != null ? enableDate.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (isSendSms != null ? isSendSms.hashCode() : 0);
        result = 31 * result + (isSendEmail != null ? isSendEmail.hashCode() : 0);
        result = 31 * result + (isConfirm != null ? isConfirm.hashCode() : 0);
        result = 31 * result + (wxaccount != null ? wxaccount.hashCode() : 0);
        result = 31 * result + (bankCardNumber != null ? bankCardNumber.hashCode() : 0);
        return result;
    }


}
