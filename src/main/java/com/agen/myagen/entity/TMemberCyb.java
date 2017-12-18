package com.agen.myagen.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_member_cyb", schema = "dbo", catalog = "geneshop")
public class TMemberCyb {
    private int id;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private String bz;
    private String cybImgUrl;
    private Integer cybLx;
    private Integer cybZt;
    private String cybbm;
    private String guid;
    private Boolean isEnable;
    private Integer ordernum;
    private Timestamp shDate;
    private Boolean shbj;
    private String shr;
    private Timestamp sjDate;
    private Boolean sjbj;
    private String sjr;
    private String validateNum;
    private String emailStatus;
    private Timestamp sysjsDate;
    private String boxNum;
    private String ks;
    private String zyh;
    private String sjys;
    private String hunancybbm;
    private String hunancybbmjcr;
    private String hunancybbmpzr;
    private Timestamp hunancybbmjcDate;
    private String hunanbbxzcode;
    private String hunanbbxzname;
    private String hunanbblxcode;
    private String hunanbblxname;
    private String bedNum;
    private String diagnosis;
    private String sampleType;
    private String sendHospital;

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
    @Column(name = "bz", nullable = true, length = 255)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "cyb_img_url", nullable = true, length = 255)
    public String getCybImgUrl() {
        return cybImgUrl;
    }

    public void setCybImgUrl(String cybImgUrl) {
        this.cybImgUrl = cybImgUrl;
    }

    @Basic
    @Column(name = "cyb_lx", nullable = true)
    public Integer getCybLx() {
        return cybLx;
    }

    public void setCybLx(Integer cybLx) {
        this.cybLx = cybLx;
    }

    @Basic
    @Column(name = "cyb_zt", nullable = true)
    public Integer getCybZt() {
        return cybZt;
    }

    public void setCybZt(Integer cybZt) {
        this.cybZt = cybZt;
    }

    @Basic
    @Column(name = "cybbm", nullable = true, length = 100)
    public String getCybbm() {
        return cybbm;
    }

    public void setCybbm(String cybbm) {
        this.cybbm = cybbm;
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
    @Column(name = "is_enable", nullable = true)
    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    @Basic
    @Column(name = "ordernum", nullable = true)
    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    @Basic
    @Column(name = "sh_date", nullable = true)
    public Timestamp getShDate() {
        return shDate;
    }

    public void setShDate(Timestamp shDate) {
        this.shDate = shDate;
    }

    @Basic
    @Column(name = "shbj", nullable = true)
    public Boolean getShbj() {
        return shbj;
    }

    public void setShbj(Boolean shbj) {
        this.shbj = shbj;
    }

    @Basic
    @Column(name = "shr", nullable = true, length = 255)
    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    @Basic
    @Column(name = "sj_date", nullable = true)
    public Timestamp getSjDate() {
        return sjDate;
    }

    public void setSjDate(Timestamp sjDate) {
        this.sjDate = sjDate;
    }

    @Basic
    @Column(name = "sjbj", nullable = true)
    public Boolean getSjbj() {
        return sjbj;
    }

    public void setSjbj(Boolean sjbj) {
        this.sjbj = sjbj;
    }

    @Basic
    @Column(name = "sjr", nullable = true, length = 255)
    public String getSjr() {
        return sjr;
    }

    public void setSjr(String sjr) {
        this.sjr = sjr;
    }

    @Basic
    @Column(name = "validate_num", nullable = true, length = 50)
    public String getValidateNum() {
        return validateNum;
    }

    public void setValidateNum(String validateNum) {
        this.validateNum = validateNum;
    }

    @Basic
    @Column(name = "email_status", nullable = true, length = 255)
    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    @Basic
    @Column(name = "sysjs_date", nullable = true)
    public Timestamp getSysjsDate() {
        return sysjsDate;
    }

    public void setSysjsDate(Timestamp sysjsDate) {
        this.sysjsDate = sysjsDate;
    }

    @Basic
    @Column(name = "box_num", nullable = true, length = 200)
    public String getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(String boxNum) {
        this.boxNum = boxNum;
    }

    @Basic
    @Column(name = "ks", nullable = true, length = 100)
    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    @Basic
    @Column(name = "zyh", nullable = true, length = 100)
    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    @Basic
    @Column(name = "sjys", nullable = true, length = 100)
    public String getSjys() {
        return sjys;
    }

    public void setSjys(String sjys) {
        this.sjys = sjys;
    }

    @Basic
    @Column(name = "hunancybbm", nullable = true, length = 100)
    public String getHunancybbm() {
        return hunancybbm;
    }

    public void setHunancybbm(String hunancybbm) {
        this.hunancybbm = hunancybbm;
    }

    @Basic
    @Column(name = "hunancybbmjcr", nullable = true, length = 100)
    public String getHunancybbmjcr() {
        return hunancybbmjcr;
    }

    public void setHunancybbmjcr(String hunancybbmjcr) {
        this.hunancybbmjcr = hunancybbmjcr;
    }

    @Basic
    @Column(name = "hunancybbmpzr", nullable = true, length = 100)
    public String getHunancybbmpzr() {
        return hunancybbmpzr;
    }

    public void setHunancybbmpzr(String hunancybbmpzr) {
        this.hunancybbmpzr = hunancybbmpzr;
    }

    @Basic
    @Column(name = "hunancybbmjc_date", nullable = true)
    public Timestamp getHunancybbmjcDate() {
        return hunancybbmjcDate;
    }

    public void setHunancybbmjcDate(Timestamp hunancybbmjcDate) {
        this.hunancybbmjcDate = hunancybbmjcDate;
    }

    @Basic
    @Column(name = "hunanbbxzcode", nullable = true, length = 100)
    public String getHunanbbxzcode() {
        return hunanbbxzcode;
    }

    public void setHunanbbxzcode(String hunanbbxzcode) {
        this.hunanbbxzcode = hunanbbxzcode;
    }

    @Basic
    @Column(name = "hunanbbxzname", nullable = true, length = 100)
    public String getHunanbbxzname() {
        return hunanbbxzname;
    }

    public void setHunanbbxzname(String hunanbbxzname) {
        this.hunanbbxzname = hunanbbxzname;
    }

    @Basic
    @Column(name = "hunanbblxcode", nullable = true, length = 100)
    public String getHunanbblxcode() {
        return hunanbblxcode;
    }

    public void setHunanbblxcode(String hunanbblxcode) {
        this.hunanbblxcode = hunanbblxcode;
    }

    @Basic
    @Column(name = "hunanbblxname", nullable = true, length = 100)
    public String getHunanbblxname() {
        return hunanbblxname;
    }

    public void setHunanbblxname(String hunanbblxname) {
        this.hunanbblxname = hunanbblxname;
    }

    @Basic
    @Column(name = "bed_num", nullable = true, length = 255)
    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    @Basic
    @Column(name = "diagnosis", nullable = true, length = 255)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "sample_type", nullable = true, length = 255)
    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    @Basic
    @Column(name = "send_hospital", nullable = true, length = 255)
    public String getSendHospital() {
        return sendHospital;
    }

    public void setSendHospital(String sendHospital) {
        this.sendHospital = sendHospital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMemberCyb that = (TMemberCyb) o;

        if (id != that.id) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (bz != null ? !bz.equals(that.bz) : that.bz != null) return false;
        if (cybImgUrl != null ? !cybImgUrl.equals(that.cybImgUrl) : that.cybImgUrl != null) return false;
        if (cybLx != null ? !cybLx.equals(that.cybLx) : that.cybLx != null) return false;
        if (cybZt != null ? !cybZt.equals(that.cybZt) : that.cybZt != null) return false;
        if (cybbm != null ? !cybbm.equals(that.cybbm) : that.cybbm != null) return false;
        if (guid != null ? !guid.equals(that.guid) : that.guid != null) return false;
        if (ordernum != null ? !ordernum.equals(that.ordernum) : that.ordernum != null) return false;
        if (shDate != null ? !shDate.equals(that.shDate) : that.shDate != null) return false;
        if (shbj != null ? !shbj.equals(that.shbj) : that.shbj != null) return false;
        if (shr != null ? !shr.equals(that.shr) : that.shr != null) return false;
        if (sjDate != null ? !sjDate.equals(that.sjDate) : that.sjDate != null) return false;
        if (sjbj != null ? !sjbj.equals(that.sjbj) : that.sjbj != null) return false;
        if (sjr != null ? !sjr.equals(that.sjr) : that.sjr != null) return false;
        if (validateNum != null ? !validateNum.equals(that.validateNum) : that.validateNum != null) return false;
        if (emailStatus != null ? !emailStatus.equals(that.emailStatus) : that.emailStatus != null) return false;
        if (sysjsDate != null ? !sysjsDate.equals(that.sysjsDate) : that.sysjsDate != null) return false;
        if (boxNum != null ? !boxNum.equals(that.boxNum) : that.boxNum != null) return false;
        if (ks != null ? !ks.equals(that.ks) : that.ks != null) return false;
        if (zyh != null ? !zyh.equals(that.zyh) : that.zyh != null) return false;
        if (sjys != null ? !sjys.equals(that.sjys) : that.sjys != null) return false;
        if (hunancybbm != null ? !hunancybbm.equals(that.hunancybbm) : that.hunancybbm != null) return false;
        if (hunancybbmjcr != null ? !hunancybbmjcr.equals(that.hunancybbmjcr) : that.hunancybbmjcr != null)
            return false;
        if (hunancybbmpzr != null ? !hunancybbmpzr.equals(that.hunancybbmpzr) : that.hunancybbmpzr != null)
            return false;
        if (hunancybbmjcDate != null ? !hunancybbmjcDate.equals(that.hunancybbmjcDate) : that.hunancybbmjcDate != null)
            return false;
        if (hunanbbxzcode != null ? !hunanbbxzcode.equals(that.hunanbbxzcode) : that.hunanbbxzcode != null)
            return false;
        if (hunanbbxzname != null ? !hunanbbxzname.equals(that.hunanbbxzname) : that.hunanbbxzname != null)
            return false;
        if (hunanbblxcode != null ? !hunanbblxcode.equals(that.hunanbblxcode) : that.hunanbblxcode != null)
            return false;
        if (hunanbblxname != null ? !hunanbblxname.equals(that.hunanbblxname) : that.hunanbblxname != null)
            return false;
        if (bedNum != null ? !bedNum.equals(that.bedNum) : that.bedNum != null) return false;
        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (sampleType != null ? !sampleType.equals(that.sampleType) : that.sampleType != null) return false;
        if (sendHospital != null ? !sendHospital.equals(that.sendHospital) : that.sendHospital != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (cybImgUrl != null ? cybImgUrl.hashCode() : 0);
        result = 31 * result + (cybLx != null ? cybLx.hashCode() : 0);
        result = 31 * result + (cybZt != null ? cybZt.hashCode() : 0);
        result = 31 * result + (cybbm != null ? cybbm.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (ordernum != null ? ordernum.hashCode() : 0);
        result = 31 * result + (shDate != null ? shDate.hashCode() : 0);
        result = 31 * result + (shbj != null ? shbj.hashCode() : 0);
        result = 31 * result + (shr != null ? shr.hashCode() : 0);
        result = 31 * result + (sjDate != null ? sjDate.hashCode() : 0);
        result = 31 * result + (sjbj != null ? sjbj.hashCode() : 0);
        result = 31 * result + (sjr != null ? sjr.hashCode() : 0);
        result = 31 * result + (validateNum != null ? validateNum.hashCode() : 0);
        result = 31 * result + (emailStatus != null ? emailStatus.hashCode() : 0);
        result = 31 * result + (sysjsDate != null ? sysjsDate.hashCode() : 0);
        result = 31 * result + (boxNum != null ? boxNum.hashCode() : 0);
        result = 31 * result + (ks != null ? ks.hashCode() : 0);
        result = 31 * result + (zyh != null ? zyh.hashCode() : 0);
        result = 31 * result + (sjys != null ? sjys.hashCode() : 0);
        result = 31 * result + (hunancybbm != null ? hunancybbm.hashCode() : 0);
        result = 31 * result + (hunancybbmjcr != null ? hunancybbmjcr.hashCode() : 0);
        result = 31 * result + (hunancybbmpzr != null ? hunancybbmpzr.hashCode() : 0);
        result = 31 * result + (hunancybbmjcDate != null ? hunancybbmjcDate.hashCode() : 0);
        result = 31 * result + (hunanbbxzcode != null ? hunanbbxzcode.hashCode() : 0);
        result = 31 * result + (hunanbbxzname != null ? hunanbbxzname.hashCode() : 0);
        result = 31 * result + (hunanbblxcode != null ? hunanbblxcode.hashCode() : 0);
        result = 31 * result + (hunanbblxname != null ? hunanbblxname.hashCode() : 0);
        result = 31 * result + (bedNum != null ? bedNum.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (sampleType != null ? sampleType.hashCode() : 0);
        result = 31 * result + (sendHospital != null ? sendHospital.hashCode() : 0);
        return result;
    }
}
