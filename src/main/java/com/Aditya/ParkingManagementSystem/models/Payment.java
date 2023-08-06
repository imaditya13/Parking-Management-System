package com.Aditya.ParkingManagementSystem.models;

public class Payment extends BaseEntity{

    private PaymentType paymentType;
    private Integer amount;
    private PaymentStatus paymentStatus;
    private String referenceId;

    public Payment(Long uuid) {
        super(uuid);
    }


    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
