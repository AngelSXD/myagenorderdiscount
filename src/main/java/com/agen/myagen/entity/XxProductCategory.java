package com.agen.myagen.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "xx_product_category", schema = "dbo", catalog = "geneshop")
public class XxProductCategory {
    private int id;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private Integer orders;
    private int grade;
    private String name;
    private String seoDescription;
    private String seoKeywords;
    private String seoTitle;
    private String treePath;
    private XxProductCategory xxProductCategoryByParent;

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
    @Column(name = "orders", nullable = true)
    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @Basic
    @Column(name = "grade", nullable = false)
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "seo_description", nullable = true, length = 255)
    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    @Basic
    @Column(name = "seo_keywords", nullable = true, length = 255)
    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    @Basic
    @Column(name = "seo_title", nullable = true, length = 255)
    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    @Basic
    @Column(name = "tree_path", nullable = false, length = 255)
    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XxProductCategory that = (XxProductCategory) o;

        if (id != that.id) return false;
        if (grade != that.grade) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (orders != null ? !orders.equals(that.orders) : that.orders != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (seoDescription != null ? !seoDescription.equals(that.seoDescription) : that.seoDescription != null)
            return false;
        if (seoKeywords != null ? !seoKeywords.equals(that.seoKeywords) : that.seoKeywords != null) return false;
        if (seoTitle != null ? !seoTitle.equals(that.seoTitle) : that.seoTitle != null) return false;
        if (treePath != null ? !treePath.equals(that.treePath) : that.treePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        result = 31 * result + grade;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (seoDescription != null ? seoDescription.hashCode() : 0);
        result = 31 * result + (seoKeywords != null ? seoKeywords.hashCode() : 0);
        result = 31 * result + (seoTitle != null ? seoTitle.hashCode() : 0);
        result = 31 * result + (treePath != null ? treePath.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName = "id")
    public XxProductCategory getXxProductCategoryByParent() {
        return xxProductCategoryByParent;
    }

    public void setXxProductCategoryByParent(XxProductCategory xxProductCategoryByParent) {
        this.xxProductCategoryByParent = xxProductCategoryByParent;
    }


}
