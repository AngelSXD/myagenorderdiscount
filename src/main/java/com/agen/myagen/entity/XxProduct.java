package com.agen.myagen.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "xx_product", schema = "dbo", catalog = "geneshop")
public class XxProduct {
    private int id;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private int allocatedStock;
    private String attributeValue0;
    private String attributeValue1;
    private String attributeValue10;
    private String attributeValue11;
    private String attributeValue12;
    private String attributeValue13;
    private String attributeValue14;
    private String attributeValue15;
    private String attributeValue16;
    private String attributeValue17;
    private String attributeValue18;
    private String attributeValue19;
    private String attributeValue2;
    private String attributeValue3;
    private String attributeValue4;
    private String attributeValue5;
    private String attributeValue6;
    private String attributeValue7;
    private String attributeValue8;
    private String attributeValue9;
    private BigDecimal cost;
    private int exchangePoint;
    private String fullName;
    private int hits;
    private String image;
    private String introduction;
    private boolean isList;
    private boolean isMarketable;
    private boolean isTop;
    private String keyword;
    private BigDecimal marketPrice;
    private String memo;
    private int monthHits;
    private Timestamp monthHitsDate;
    private int monthSales;
    private Timestamp monthSalesDate;
    private String name;
    private BigDecimal price;
    private int rewardPoint;
    private int sales;
    private double score;
    private int scoreCount;
    private String seoDescription;
    private String seoKeywords;
    private String seoTitle;
    private String sn;
    private Integer stock;
    private String stockMemo;
    private int totalScore;
    private int type;
    private String unit;
    private int weekHits;
    private Timestamp weekHitsDate;
    private int weekSales;
    private Timestamp weekSalesDate;
    private Integer weight;
    private Integer cybLx;
    private Boolean isHEnabled;
    private Boolean isWjEnabled;
    private String guid;
    private String belong;

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
    @Column(name = "allocated_stock", nullable = false)
    public int getAllocatedStock() {
        return allocatedStock;
    }

    public void setAllocatedStock(int allocatedStock) {
        this.allocatedStock = allocatedStock;
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
    @Column(name = "attribute_value10", nullable = true, length = 255)
    public String getAttributeValue10() {
        return attributeValue10;
    }

    public void setAttributeValue10(String attributeValue10) {
        this.attributeValue10 = attributeValue10;
    }

    @Basic
    @Column(name = "attribute_value11", nullable = true, length = 255)
    public String getAttributeValue11() {
        return attributeValue11;
    }

    public void setAttributeValue11(String attributeValue11) {
        this.attributeValue11 = attributeValue11;
    }

    @Basic
    @Column(name = "attribute_value12", nullable = true, length = 255)
    public String getAttributeValue12() {
        return attributeValue12;
    }

    public void setAttributeValue12(String attributeValue12) {
        this.attributeValue12 = attributeValue12;
    }

    @Basic
    @Column(name = "attribute_value13", nullable = true, length = 255)
    public String getAttributeValue13() {
        return attributeValue13;
    }

    public void setAttributeValue13(String attributeValue13) {
        this.attributeValue13 = attributeValue13;
    }

    @Basic
    @Column(name = "attribute_value14", nullable = true, length = 255)
    public String getAttributeValue14() {
        return attributeValue14;
    }

    public void setAttributeValue14(String attributeValue14) {
        this.attributeValue14 = attributeValue14;
    }

    @Basic
    @Column(name = "attribute_value15", nullable = true, length = 255)
    public String getAttributeValue15() {
        return attributeValue15;
    }

    public void setAttributeValue15(String attributeValue15) {
        this.attributeValue15 = attributeValue15;
    }

    @Basic
    @Column(name = "attribute_value16", nullable = true, length = 255)
    public String getAttributeValue16() {
        return attributeValue16;
    }

    public void setAttributeValue16(String attributeValue16) {
        this.attributeValue16 = attributeValue16;
    }

    @Basic
    @Column(name = "attribute_value17", nullable = true, length = 255)
    public String getAttributeValue17() {
        return attributeValue17;
    }

    public void setAttributeValue17(String attributeValue17) {
        this.attributeValue17 = attributeValue17;
    }

    @Basic
    @Column(name = "attribute_value18", nullable = true, length = 255)
    public String getAttributeValue18() {
        return attributeValue18;
    }

    public void setAttributeValue18(String attributeValue18) {
        this.attributeValue18 = attributeValue18;
    }

    @Basic
    @Column(name = "attribute_value19", nullable = true, length = 255)
    public String getAttributeValue19() {
        return attributeValue19;
    }

    public void setAttributeValue19(String attributeValue19) {
        this.attributeValue19 = attributeValue19;
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
    @Column(name = "cost", nullable = true, precision = 6)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "exchange_point", nullable = false, precision = 0)
    public int getExchangePoint() {
        return exchangePoint;
    }

    public void setExchangePoint(int exchangePoint) {
        this.exchangePoint = exchangePoint;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 255)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "hits", nullable = false, precision = 0)
    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 255)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "introduction", nullable = true, length = -1)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "is_list", nullable = false)
    public boolean isList() {
        return isList;
    }

    public void setList(boolean list) {
        isList = list;
    }

    @Basic
    @Column(name = "is_marketable", nullable = false)
    public boolean isMarketable() {
        return isMarketable;
    }

    public void setMarketable(boolean marketable) {
        isMarketable = marketable;
    }

    @Basic
    @Column(name = "is_top", nullable = false)
    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    @Basic
    @Column(name = "keyword", nullable = true, length = 255)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "market_price", nullable = false, precision = 6)
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    @Basic
    @Column(name = "memo", nullable = true, length = 255)
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Basic
    @Column(name = "month_hits", nullable = false, precision = 0)
    public int getMonthHits() {
        return monthHits;
    }

    public void setMonthHits(int monthHits) {
        this.monthHits = monthHits;
    }

    @Basic
    @Column(name = "month_hits_date", nullable = false)
    public Timestamp getMonthHitsDate() {
        return monthHitsDate;
    }

    public void setMonthHitsDate(Timestamp monthHitsDate) {
        this.monthHitsDate = monthHitsDate;
    }

    @Basic
    @Column(name = "month_sales", nullable = false, precision = 0)
    public int getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(int monthSales) {
        this.monthSales = monthSales;
    }

    @Basic
    @Column(name = "month_sales_date", nullable = false)
    public Timestamp getMonthSalesDate() {
        return monthSalesDate;
    }

    public void setMonthSalesDate(Timestamp monthSalesDate) {
        this.monthSalesDate = monthSalesDate;
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
    @Column(name = "price", nullable = false, precision = 6)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "reward_point", nullable = false, precision = 0)
    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    @Basic
    @Column(name = "sales", nullable = false, precision = 0)
    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Basic
    @Column(name = "score", nullable = false, precision = 0)
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "score_count", nullable = false, precision = 0)
    public int getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(int scoreCount) {
        this.scoreCount = scoreCount;
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
    @Column(name = "sn", nullable = false, length = 100)
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Basic
    @Column(name = "stock", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "stock_memo", nullable = true, length = 255)
    public String getStockMemo() {
        return stockMemo;
    }

    public void setStockMemo(String stockMemo) {
        this.stockMemo = stockMemo;
    }

    @Basic
    @Column(name = "total_score", nullable = false, precision = 0)
    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "unit", nullable = true, length = 255)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "week_hits", nullable = false, precision = 0)
    public int getWeekHits() {
        return weekHits;
    }

    public void setWeekHits(int weekHits) {
        this.weekHits = weekHits;
    }

    @Basic
    @Column(name = "week_hits_date", nullable = false)
    public Timestamp getWeekHitsDate() {
        return weekHitsDate;
    }

    public void setWeekHitsDate(Timestamp weekHitsDate) {
        this.weekHitsDate = weekHitsDate;
    }

    @Basic
    @Column(name = "week_sales", nullable = false, precision = 0)
    public int getWeekSales() {
        return weekSales;
    }

    public void setWeekSales(int weekSales) {
        this.weekSales = weekSales;
    }

    @Basic
    @Column(name = "week_sales_date", nullable = false)
    public Timestamp getWeekSalesDate() {
        return weekSalesDate;
    }

    public void setWeekSalesDate(Timestamp weekSalesDate) {
        this.weekSalesDate = weekSalesDate;
    }

    @Basic
    @Column(name = "weight", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
    @Column(name = "is_h_enabled", nullable = true)
    public Boolean getHEnabled() {
        return isHEnabled;
    }

    public void setHEnabled(Boolean HEnabled) {
        isHEnabled = HEnabled;
    }

    @Basic
    @Column(name = "is_wj_enabled", nullable = true)
    public Boolean getWjEnabled() {
        return isWjEnabled;
    }

    public void setWjEnabled(Boolean wjEnabled) {
        isWjEnabled = wjEnabled;
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
    @Column(name = "belong", nullable = true, length = 255)
    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XxProduct xxProduct = (XxProduct) o;

        if (id != xxProduct.id) return false;
        if (allocatedStock != xxProduct.allocatedStock) return false;
        if (exchangePoint != xxProduct.exchangePoint) return false;
        if (hits != xxProduct.hits) return false;
        if (monthHits != xxProduct.monthHits) return false;
        if (monthSales != xxProduct.monthSales) return false;
        if (rewardPoint != xxProduct.rewardPoint) return false;
        if (sales != xxProduct.sales) return false;
        if (Double.compare(xxProduct.score, score) != 0) return false;
        if (scoreCount != xxProduct.scoreCount) return false;
        if (totalScore != xxProduct.totalScore) return false;
        if (type != xxProduct.type) return false;
        if (weekHits != xxProduct.weekHits) return false;
        if (weekSales != xxProduct.weekSales) return false;
        if (createDate != null ? !createDate.equals(xxProduct.createDate) : xxProduct.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(xxProduct.modifyDate) : xxProduct.modifyDate != null) return false;
        if (attributeValue0 != null ? !attributeValue0.equals(xxProduct.attributeValue0) : xxProduct.attributeValue0 != null)
            return false;
        if (attributeValue1 != null ? !attributeValue1.equals(xxProduct.attributeValue1) : xxProduct.attributeValue1 != null)
            return false;
        if (attributeValue10 != null ? !attributeValue10.equals(xxProduct.attributeValue10) : xxProduct.attributeValue10 != null)
            return false;
        if (attributeValue11 != null ? !attributeValue11.equals(xxProduct.attributeValue11) : xxProduct.attributeValue11 != null)
            return false;
        if (attributeValue12 != null ? !attributeValue12.equals(xxProduct.attributeValue12) : xxProduct.attributeValue12 != null)
            return false;
        if (attributeValue13 != null ? !attributeValue13.equals(xxProduct.attributeValue13) : xxProduct.attributeValue13 != null)
            return false;
        if (attributeValue14 != null ? !attributeValue14.equals(xxProduct.attributeValue14) : xxProduct.attributeValue14 != null)
            return false;
        if (attributeValue15 != null ? !attributeValue15.equals(xxProduct.attributeValue15) : xxProduct.attributeValue15 != null)
            return false;
        if (attributeValue16 != null ? !attributeValue16.equals(xxProduct.attributeValue16) : xxProduct.attributeValue16 != null)
            return false;
        if (attributeValue17 != null ? !attributeValue17.equals(xxProduct.attributeValue17) : xxProduct.attributeValue17 != null)
            return false;
        if (attributeValue18 != null ? !attributeValue18.equals(xxProduct.attributeValue18) : xxProduct.attributeValue18 != null)
            return false;
        if (attributeValue19 != null ? !attributeValue19.equals(xxProduct.attributeValue19) : xxProduct.attributeValue19 != null)
            return false;
        if (attributeValue2 != null ? !attributeValue2.equals(xxProduct.attributeValue2) : xxProduct.attributeValue2 != null)
            return false;
        if (attributeValue3 != null ? !attributeValue3.equals(xxProduct.attributeValue3) : xxProduct.attributeValue3 != null)
            return false;
        if (attributeValue4 != null ? !attributeValue4.equals(xxProduct.attributeValue4) : xxProduct.attributeValue4 != null)
            return false;
        if (attributeValue5 != null ? !attributeValue5.equals(xxProduct.attributeValue5) : xxProduct.attributeValue5 != null)
            return false;
        if (attributeValue6 != null ? !attributeValue6.equals(xxProduct.attributeValue6) : xxProduct.attributeValue6 != null)
            return false;
        if (attributeValue7 != null ? !attributeValue7.equals(xxProduct.attributeValue7) : xxProduct.attributeValue7 != null)
            return false;
        if (attributeValue8 != null ? !attributeValue8.equals(xxProduct.attributeValue8) : xxProduct.attributeValue8 != null)
            return false;
        if (attributeValue9 != null ? !attributeValue9.equals(xxProduct.attributeValue9) : xxProduct.attributeValue9 != null)
            return false;
        if (cost != null ? !cost.equals(xxProduct.cost) : xxProduct.cost != null) return false;
        if (fullName != null ? !fullName.equals(xxProduct.fullName) : xxProduct.fullName != null) return false;
        if (image != null ? !image.equals(xxProduct.image) : xxProduct.image != null) return false;
        if (introduction != null ? !introduction.equals(xxProduct.introduction) : xxProduct.introduction != null)
            return false;
        if (keyword != null ? !keyword.equals(xxProduct.keyword) : xxProduct.keyword != null) return false;
        if (marketPrice != null ? !marketPrice.equals(xxProduct.marketPrice) : xxProduct.marketPrice != null)
            return false;
        if (memo != null ? !memo.equals(xxProduct.memo) : xxProduct.memo != null) return false;
        if (monthHitsDate != null ? !monthHitsDate.equals(xxProduct.monthHitsDate) : xxProduct.monthHitsDate != null)
            return false;
        if (monthSalesDate != null ? !monthSalesDate.equals(xxProduct.monthSalesDate) : xxProduct.monthSalesDate != null)
            return false;
        if (name != null ? !name.equals(xxProduct.name) : xxProduct.name != null) return false;
        if (price != null ? !price.equals(xxProduct.price) : xxProduct.price != null) return false;
        if (seoDescription != null ? !seoDescription.equals(xxProduct.seoDescription) : xxProduct.seoDescription != null)
            return false;
        if (seoKeywords != null ? !seoKeywords.equals(xxProduct.seoKeywords) : xxProduct.seoKeywords != null)
            return false;
        if (seoTitle != null ? !seoTitle.equals(xxProduct.seoTitle) : xxProduct.seoTitle != null) return false;
        if (sn != null ? !sn.equals(xxProduct.sn) : xxProduct.sn != null) return false;
        if (stock != null ? !stock.equals(xxProduct.stock) : xxProduct.stock != null) return false;
        if (stockMemo != null ? !stockMemo.equals(xxProduct.stockMemo) : xxProduct.stockMemo != null) return false;
        if (unit != null ? !unit.equals(xxProduct.unit) : xxProduct.unit != null) return false;
        if (weekHitsDate != null ? !weekHitsDate.equals(xxProduct.weekHitsDate) : xxProduct.weekHitsDate != null)
            return false;
        if (weekSalesDate != null ? !weekSalesDate.equals(xxProduct.weekSalesDate) : xxProduct.weekSalesDate != null)
            return false;
        if (weight != null ? !weight.equals(xxProduct.weight) : xxProduct.weight != null) return false;
        if (cybLx != null ? !cybLx.equals(xxProduct.cybLx) : xxProduct.cybLx != null) return false;
        if (guid != null ? !guid.equals(xxProduct.guid) : xxProduct.guid != null) return false;
        if (belong != null ? !belong.equals(xxProduct.belong) : xxProduct.belong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + allocatedStock;
        result = 31 * result + (attributeValue0 != null ? attributeValue0.hashCode() : 0);
        result = 31 * result + (attributeValue1 != null ? attributeValue1.hashCode() : 0);
        result = 31 * result + (attributeValue10 != null ? attributeValue10.hashCode() : 0);
        result = 31 * result + (attributeValue11 != null ? attributeValue11.hashCode() : 0);
        result = 31 * result + (attributeValue12 != null ? attributeValue12.hashCode() : 0);
        result = 31 * result + (attributeValue13 != null ? attributeValue13.hashCode() : 0);
        result = 31 * result + (attributeValue14 != null ? attributeValue14.hashCode() : 0);
        result = 31 * result + (attributeValue15 != null ? attributeValue15.hashCode() : 0);
        result = 31 * result + (attributeValue16 != null ? attributeValue16.hashCode() : 0);
        result = 31 * result + (attributeValue17 != null ? attributeValue17.hashCode() : 0);
        result = 31 * result + (attributeValue18 != null ? attributeValue18.hashCode() : 0);
        result = 31 * result + (attributeValue19 != null ? attributeValue19.hashCode() : 0);
        result = 31 * result + (attributeValue2 != null ? attributeValue2.hashCode() : 0);
        result = 31 * result + (attributeValue3 != null ? attributeValue3.hashCode() : 0);
        result = 31 * result + (attributeValue4 != null ? attributeValue4.hashCode() : 0);
        result = 31 * result + (attributeValue5 != null ? attributeValue5.hashCode() : 0);
        result = 31 * result + (attributeValue6 != null ? attributeValue6.hashCode() : 0);
        result = 31 * result + (attributeValue7 != null ? attributeValue7.hashCode() : 0);
        result = 31 * result + (attributeValue8 != null ? attributeValue8.hashCode() : 0);
        result = 31 * result + (attributeValue9 != null ? attributeValue9.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + exchangePoint;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + hits;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (marketPrice != null ? marketPrice.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + monthHits;
        result = 31 * result + (monthHitsDate != null ? monthHitsDate.hashCode() : 0);
        result = 31 * result + monthSales;
        result = 31 * result + (monthSalesDate != null ? monthSalesDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + rewardPoint;
        result = 31 * result + sales;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + scoreCount;
        result = 31 * result + (seoDescription != null ? seoDescription.hashCode() : 0);
        result = 31 * result + (seoKeywords != null ? seoKeywords.hashCode() : 0);
        result = 31 * result + (seoTitle != null ? seoTitle.hashCode() : 0);
        result = 31 * result + (sn != null ? sn.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (stockMemo != null ? stockMemo.hashCode() : 0);
        result = 31 * result + totalScore;
        result = 31 * result + type;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + weekHits;
        result = 31 * result + (weekHitsDate != null ? weekHitsDate.hashCode() : 0);
        result = 31 * result + weekSales;
        result = 31 * result + (weekSalesDate != null ? weekSalesDate.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (cybLx != null ? cybLx.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (belong != null ? belong.hashCode() : 0);
        return result;
    }
}
