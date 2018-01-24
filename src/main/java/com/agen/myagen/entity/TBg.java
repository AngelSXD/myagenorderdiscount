package com.agen.myagen.entity;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "t_bg", schema = "dbo", catalog = "geneshop")
public class TBg {
    private int id;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private Integer bgtype;
    private Boolean fpbj;
    private String pdfPath;
    private Integer status;
    private String wordPath;
    private Timestamp bgDate;
    private Timestamp cjDate;
    private Timestamp zjDate;
    private String emailStatus;
    private String guid;
    private Boolean fpbjCj;
    private Integer infoId;
    private Boolean isPz;
    private Timestamp pzDate;
    private Integer memberId;
    private Integer cybId;
    private int orderId;
    private Integer productId;

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
    @Column(name = "bgtype", nullable = true)
    public Integer getBgtype() {
        return bgtype;
    }

    public void setBgtype(Integer bgtype) {
        this.bgtype = bgtype;
    }

    @Basic
    @Column(name = "fpbj", nullable = true)
    public Boolean getFpbj() {
        return fpbj;
    }

    public void setFpbj(Boolean fpbj) {
        this.fpbj = fpbj;
    }

    @Basic
    @Column(name = "pdf_path", nullable = true, length = 255)
    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "word_path", nullable = true, length = 255)
    public String getWordPath() {
        return wordPath;
    }

    public void setWordPath(String wordPath) {
        this.wordPath = wordPath;
    }

    @Basic
    @Column(name = "bg_date", nullable = true)
    public Timestamp getBgDate() {
        return bgDate;
    }

    public void setBgDate(Timestamp bgDate) {
        this.bgDate = bgDate;
    }

    @Basic
    @Column(name = "cj_date", nullable = true)
    public Timestamp getCjDate() {
        return cjDate;
    }

    public void setCjDate(Timestamp cjDate) {
        this.cjDate = cjDate;
    }

    @Basic
    @Column(name = "zj_date", nullable = true)
    public Timestamp getZjDate() {
        return zjDate;
    }

    public void setZjDate(Timestamp zjDate) {
        this.zjDate = zjDate;
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
    @Column(name = "guid", nullable = true, length = 255)
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "fpbj_cj", nullable = true)
    public Boolean getFpbjCj() {
        return fpbjCj;
    }

    public void setFpbjCj(Boolean fpbjCj) {
        this.fpbjCj = fpbjCj;
    }

    @Basic
    @Column(name = "info_id", nullable = true, precision = 0)
    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    @Basic
    @Column(name = "is_pz", nullable = true)
    public Boolean getPz() {
        return isPz;
    }

    public void setPz(Boolean pz) {
        isPz = pz;
    }

    @Basic
    @Column(name = "pz_date", nullable = true)
    public Timestamp getPzDate() {
        return pzDate;
    }

    public void setPzDate(Timestamp pzDate) {
        this.pzDate = pzDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TBg tBg = (TBg) o;

        if (id != tBg.id) return false;
        if (createDate != null ? !createDate.equals(tBg.createDate) : tBg.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(tBg.modifyDate) : tBg.modifyDate != null) return false;
        if (bgtype != null ? !bgtype.equals(tBg.bgtype) : tBg.bgtype != null) return false;
        if (fpbj != null ? !fpbj.equals(tBg.fpbj) : tBg.fpbj != null) return false;
        if (pdfPath != null ? !pdfPath.equals(tBg.pdfPath) : tBg.pdfPath != null) return false;
        if (status != null ? !status.equals(tBg.status) : tBg.status != null) return false;
        if (wordPath != null ? !wordPath.equals(tBg.wordPath) : tBg.wordPath != null) return false;
        if (bgDate != null ? !bgDate.equals(tBg.bgDate) : tBg.bgDate != null) return false;
        if (cjDate != null ? !cjDate.equals(tBg.cjDate) : tBg.cjDate != null) return false;
        if (zjDate != null ? !zjDate.equals(tBg.zjDate) : tBg.zjDate != null) return false;
        if (emailStatus != null ? !emailStatus.equals(tBg.emailStatus) : tBg.emailStatus != null) return false;
        if (guid != null ? !guid.equals(tBg.guid) : tBg.guid != null) return false;
        if (fpbjCj != null ? !fpbjCj.equals(tBg.fpbjCj) : tBg.fpbjCj != null) return false;
        if (infoId != null ? !infoId.equals(tBg.infoId) : tBg.infoId != null) return false;
        if (isPz != null ? !isPz.equals(tBg.isPz) : tBg.isPz != null) return false;
        if (pzDate != null ? !pzDate.equals(tBg.pzDate) : tBg.pzDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (bgtype != null ? bgtype.hashCode() : 0);
        result = 31 * result + (fpbj != null ? fpbj.hashCode() : 0);
        result = 31 * result + (pdfPath != null ? pdfPath.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (wordPath != null ? wordPath.hashCode() : 0);
        result = 31 * result + (bgDate != null ? bgDate.hashCode() : 0);
        result = 31 * result + (cjDate != null ? cjDate.hashCode() : 0);
        result = 31 * result + (zjDate != null ? zjDate.hashCode() : 0);
        result = 31 * result + (emailStatus != null ? emailStatus.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (fpbjCj != null ? fpbjCj.hashCode() : 0);
        result = 31 * result + (infoId != null ? infoId.hashCode() : 0);
        result = 31 * result + (isPz != null ? isPz.hashCode() : 0);
        result = 31 * result + (pzDate != null ? pzDate.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "member_id", nullable = true, precision = 0)
    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "cyb_id", nullable = true, precision = 0)
    public Integer getCybId() {
        return cybId;
    }

    public void setCybId(Integer cybId) {
        this.cybId = cybId;
    }

    @Basic
    @Column(name = "order_id", nullable = false, precision = 0)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "product_id", nullable = true, precision = 0)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
