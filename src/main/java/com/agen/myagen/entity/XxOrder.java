package com.agen.myagen.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "xx_order", schema = "dbo", catalog = "geneshop")
public class XxOrder {
    private int id;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private String address;
    private BigDecimal amountPaid;
    private String areaName;
    private String consignee;
    private BigDecimal couponDiscount;
    private int exchangePoint;
    private Timestamp expire;
    private BigDecimal fee;
    private BigDecimal freight;
    private String invoiceTitle;
    private boolean isAllocatedStock;
    private boolean isInvoice;
    private Timestamp lockExpire;
    private String memo;
    private String name;
    private BigDecimal offsetAmount;
    private int orderStatus;
    private String paymentMethodName;
    private int paymentStatus;
    private String phone;
    private BigDecimal promotionDiscount;
    private String promotionName;
    private int rewardPoint;
    private String shippingMethodName;
    private int shippingStatus;
    private String sn;
    private BigDecimal tax;
    private int type;
    private String zipCode;
    private String memberorderno;
    private Integer ordertype;
    private Boolean distributeState;
    private Timestamp ctime;
    private String guid;
    private String cbqrr;
    private Timestamp cbqrTime;
    private Boolean isCbqr;
    private Boolean isSrqr;
    private String srqrr;
    private Timestamp srqrTime;
    private String isShow;
    private Boolean isHunantb;
    private Boolean byCreditCard;
    private XxMember xxMemberByMember;
    private XxAdmin xxAdminByOperator;
    private XxAdmin xxAdminByAdmin;


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
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "amount_paid", nullable = false, precision = 6)
    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Basic
    @Column(name = "area_name", nullable = false, length = 255)
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "consignee", nullable = false, length = 255)
    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @Basic
    @Column(name = "coupon_discount", nullable = false, precision = 6)
    public BigDecimal getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(BigDecimal couponDiscount) {
        this.couponDiscount = couponDiscount;
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
    @Column(name = "expire", nullable = true)
    public Timestamp getExpire() {
        return expire;
    }

    public void setExpire(Timestamp expire) {
        this.expire = expire;
    }

    @Basic
    @Column(name = "fee", nullable = false, precision = 6)
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "freight", nullable = false, precision = 6)
    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "invoice_title", nullable = true, length = 255)
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    @Basic
    @Column(name = "is_allocated_stock", nullable = false)
    public boolean isAllocatedStock() {
        return isAllocatedStock;
    }

    public void setAllocatedStock(boolean allocatedStock) {
        isAllocatedStock = allocatedStock;
    }

    @Basic
    @Column(name = "is_invoice", nullable = false)
    public boolean isInvoice() {
        return isInvoice;
    }

    public void setInvoice(boolean invoice) {
        isInvoice = invoice;
    }

    @Basic
    @Column(name = "lock_expire", nullable = true)
    public Timestamp getLockExpire() {
        return lockExpire;
    }

    public void setLockExpire(Timestamp lockExpire) {
        this.lockExpire = lockExpire;
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
    @Column(name = "name", nullable = false, length = 500)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "offset_amount", nullable = false, precision = 6)
    public BigDecimal getOffsetAmount() {
        return offsetAmount;
    }

    public void setOffsetAmount(BigDecimal offsetAmount) {
        this.offsetAmount = offsetAmount;
    }

    @Basic
    @Column(name = "order_status", nullable = false)
    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "payment_method_name", nullable = true, length = 255)
    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    @Basic
    @Column(name = "payment_status", nullable = false)
    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "promotion_discount", nullable = false, precision = 6)
    public BigDecimal getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(BigDecimal promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    @Basic
    @Column(name = "promotion_name", nullable = true, length = 255)
    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
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
    @Column(name = "shipping_method_name", nullable = true, length = 255)
    public String getShippingMethodName() {
        return shippingMethodName;
    }

    public void setShippingMethodName(String shippingMethodName) {
        this.shippingMethodName = shippingMethodName;
    }

    @Basic
    @Column(name = "shipping_status", nullable = false)
    public int getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(int shippingStatus) {
        this.shippingStatus = shippingStatus;
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
    @Column(name = "tax", nullable = false, precision = 6)
    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
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
    @Column(name = "zip_code", nullable = false, length = 255)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "memberorderno", nullable = true, length = 255)
    public String getMemberorderno() {
        return memberorderno;
    }

    public void setMemberorderno(String memberorderno) {
        this.memberorderno = memberorderno;
    }

    @Basic
    @Column(name = "ordertype", nullable = true)
    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    @Basic
    @Column(name = "distributeState", nullable = true)
    public Boolean getDistributeState() {
        return distributeState;
    }

    public void setDistributeState(Boolean distributeState) {
        this.distributeState = distributeState;
    }

    @Basic
    @Column(name = "ctime", nullable = true)
    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
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
    @Column(name = "cbqrr", nullable = true, length = 255)
    public String getCbqrr() {
        return cbqrr;
    }

    public void setCbqrr(String cbqrr) {
        this.cbqrr = cbqrr;
    }

    @Basic
    @Column(name = "cbqr_time", nullable = true)
    public Timestamp getCbqrTime() {
        return cbqrTime;
    }

    public void setCbqrTime(Timestamp cbqrTime) {
        this.cbqrTime = cbqrTime;
    }

    @Basic
    @Column(name = "is_cbqr", nullable = true)
    public Boolean getCbqr() {
        return isCbqr;
    }

    public void setCbqr(Boolean cbqr) {
        isCbqr = cbqr;
    }

    @Basic
    @Column(name = "is_srqr", nullable = true)
    public Boolean getSrqr() {
        return isSrqr;
    }

    public void setSrqr(Boolean srqr) {
        isSrqr = srqr;
    }

    @Basic
    @Column(name = "srqrr", nullable = true, length = 255)
    public String getSrqrr() {
        return srqrr;
    }

    public void setSrqrr(String srqrr) {
        this.srqrr = srqrr;
    }

    @Basic
    @Column(name = "srqr_time", nullable = true)
    public Timestamp getSrqrTime() {
        return srqrTime;
    }

    public void setSrqrTime(Timestamp srqrTime) {
        this.srqrTime = srqrTime;
    }

    @Basic
    @Column(name = "is_show", nullable = true, length = 255)
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    @Basic
    @Column(name = "is_hunantb", nullable = true)
    public Boolean getHunantb() {
        return isHunantb;
    }

    public void setHunantb(Boolean hunantb) {
        isHunantb = hunantb;
    }

    @Basic
    @Column(name = "by_credit_card", nullable = true)
    public Boolean getByCreditCard() {
        return byCreditCard;
    }

    public void setByCreditCard(Boolean byCreditCard) {
        this.byCreditCard = byCreditCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XxOrder xxOrder = (XxOrder) o;

        if (id != xxOrder.id) return false;
        if (exchangePoint != xxOrder.exchangePoint) return false;
        if (isAllocatedStock != xxOrder.isAllocatedStock) return false;
        if (isInvoice != xxOrder.isInvoice) return false;
        if (orderStatus != xxOrder.orderStatus) return false;
        if (paymentStatus != xxOrder.paymentStatus) return false;
        if (rewardPoint != xxOrder.rewardPoint) return false;
        if (shippingStatus != xxOrder.shippingStatus) return false;
        if (type != xxOrder.type) return false;
        if (createDate != null ? !createDate.equals(xxOrder.createDate) : xxOrder.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(xxOrder.modifyDate) : xxOrder.modifyDate != null) return false;
        if (address != null ? !address.equals(xxOrder.address) : xxOrder.address != null) return false;
        if (amountPaid != null ? !amountPaid.equals(xxOrder.amountPaid) : xxOrder.amountPaid != null) return false;
        if (areaName != null ? !areaName.equals(xxOrder.areaName) : xxOrder.areaName != null) return false;
        if (consignee != null ? !consignee.equals(xxOrder.consignee) : xxOrder.consignee != null) return false;
        if (couponDiscount != null ? !couponDiscount.equals(xxOrder.couponDiscount) : xxOrder.couponDiscount != null)
            return false;
        if (expire != null ? !expire.equals(xxOrder.expire) : xxOrder.expire != null) return false;
        if (fee != null ? !fee.equals(xxOrder.fee) : xxOrder.fee != null) return false;
        if (freight != null ? !freight.equals(xxOrder.freight) : xxOrder.freight != null) return false;
        if (invoiceTitle != null ? !invoiceTitle.equals(xxOrder.invoiceTitle) : xxOrder.invoiceTitle != null)
            return false;
        if (lockExpire != null ? !lockExpire.equals(xxOrder.lockExpire) : xxOrder.lockExpire != null) return false;
        if (memo != null ? !memo.equals(xxOrder.memo) : xxOrder.memo != null) return false;
        if (name != null ? !name.equals(xxOrder.name) : xxOrder.name != null) return false;
        if (offsetAmount != null ? !offsetAmount.equals(xxOrder.offsetAmount) : xxOrder.offsetAmount != null)
            return false;
        if (paymentMethodName != null ? !paymentMethodName.equals(xxOrder.paymentMethodName) : xxOrder.paymentMethodName != null)
            return false;
        if (phone != null ? !phone.equals(xxOrder.phone) : xxOrder.phone != null) return false;
        if (promotionDiscount != null ? !promotionDiscount.equals(xxOrder.promotionDiscount) : xxOrder.promotionDiscount != null)
            return false;
        if (promotionName != null ? !promotionName.equals(xxOrder.promotionName) : xxOrder.promotionName != null)
            return false;
        if (shippingMethodName != null ? !shippingMethodName.equals(xxOrder.shippingMethodName) : xxOrder.shippingMethodName != null)
            return false;
        if (sn != null ? !sn.equals(xxOrder.sn) : xxOrder.sn != null) return false;
        if (tax != null ? !tax.equals(xxOrder.tax) : xxOrder.tax != null) return false;
        if (zipCode != null ? !zipCode.equals(xxOrder.zipCode) : xxOrder.zipCode != null) return false;
        if (memberorderno != null ? !memberorderno.equals(xxOrder.memberorderno) : xxOrder.memberorderno != null)
            return false;
        if (ordertype != null ? !ordertype.equals(xxOrder.ordertype) : xxOrder.ordertype != null) return false;
        if (distributeState != null ? !distributeState.equals(xxOrder.distributeState) : xxOrder.distributeState != null)
            return false;
        if (ctime != null ? !ctime.equals(xxOrder.ctime) : xxOrder.ctime != null) return false;
        if (guid != null ? !guid.equals(xxOrder.guid) : xxOrder.guid != null) return false;
        if (cbqrr != null ? !cbqrr.equals(xxOrder.cbqrr) : xxOrder.cbqrr != null) return false;
        if (cbqrTime != null ? !cbqrTime.equals(xxOrder.cbqrTime) : xxOrder.cbqrTime != null) return false;
        if (isCbqr != null ? !isCbqr.equals(xxOrder.isCbqr) : xxOrder.isCbqr != null) return false;
        if (isSrqr != null ? !isSrqr.equals(xxOrder.isSrqr) : xxOrder.isSrqr != null) return false;
        if (srqrr != null ? !srqrr.equals(xxOrder.srqrr) : xxOrder.srqrr != null) return false;
        if (srqrTime != null ? !srqrTime.equals(xxOrder.srqrTime) : xxOrder.srqrTime != null) return false;
        if (isShow != null ? !isShow.equals(xxOrder.isShow) : xxOrder.isShow != null) return false;
        if (isHunantb != null ? !isHunantb.equals(xxOrder.isHunantb) : xxOrder.isHunantb != null) return false;
        if (byCreditCard != null ? !byCreditCard.equals(xxOrder.byCreditCard) : xxOrder.byCreditCard != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (amountPaid != null ? amountPaid.hashCode() : 0);
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (consignee != null ? consignee.hashCode() : 0);
        result = 31 * result + (couponDiscount != null ? couponDiscount.hashCode() : 0);
        result = 31 * result + exchangePoint;
        result = 31 * result + (expire != null ? expire.hashCode() : 0);
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        result = 31 * result + (freight != null ? freight.hashCode() : 0);
        result = 31 * result + (invoiceTitle != null ? invoiceTitle.hashCode() : 0);
        result = 31 * result + (isAllocatedStock ? 1 : 0);
        result = 31 * result + (isInvoice ? 1 : 0);
        result = 31 * result + (lockExpire != null ? lockExpire.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (offsetAmount != null ? offsetAmount.hashCode() : 0);
        result = 31 * result + orderStatus;
        result = 31 * result + (paymentMethodName != null ? paymentMethodName.hashCode() : 0);
        result = 31 * result + paymentStatus;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (promotionDiscount != null ? promotionDiscount.hashCode() : 0);
        result = 31 * result + (promotionName != null ? promotionName.hashCode() : 0);
        result = 31 * result + rewardPoint;
        result = 31 * result + (shippingMethodName != null ? shippingMethodName.hashCode() : 0);
        result = 31 * result + shippingStatus;
        result = 31 * result + (sn != null ? sn.hashCode() : 0);
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (memberorderno != null ? memberorderno.hashCode() : 0);
        result = 31 * result + (ordertype != null ? ordertype.hashCode() : 0);
        result = 31 * result + (distributeState != null ? distributeState.hashCode() : 0);
        result = 31 * result + (ctime != null ? ctime.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (cbqrr != null ? cbqrr.hashCode() : 0);
        result = 31 * result + (cbqrTime != null ? cbqrTime.hashCode() : 0);
        result = 31 * result + (isCbqr != null ? isCbqr.hashCode() : 0);
        result = 31 * result + (isSrqr != null ? isSrqr.hashCode() : 0);
        result = 31 * result + (srqrr != null ? srqrr.hashCode() : 0);
        result = 31 * result + (srqrTime != null ? srqrTime.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (isHunantb != null ? isHunantb.hashCode() : 0);
        result = 31 * result + (byCreditCard != null ? byCreditCard.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "member", referencedColumnName = "id", nullable = false)
    public XxMember getXxMemberByMember() {
        return xxMemberByMember;
    }

    public void setXxMemberByMember(XxMember xxMemberByMember) {
        this.xxMemberByMember = xxMemberByMember;
    }


    @ManyToOne
    @JoinColumn(name = "operator", referencedColumnName = "id")
    public XxAdmin getXxAdminByOperator() {
        return xxAdminByOperator;
    }

    public void setXxAdminByOperator(XxAdmin xxAdminByOperator) {
        this.xxAdminByOperator = xxAdminByOperator;
    }


    @ManyToOne
    @JoinColumn(name = "admin", referencedColumnName = "id")
    public XxAdmin getXxAdminByAdmin() {
        return xxAdminByAdmin;
    }

    public void setXxAdminByAdmin(XxAdmin xxAdminByAdmin) {
        this.xxAdminByAdmin = xxAdminByAdmin;
    }


}
