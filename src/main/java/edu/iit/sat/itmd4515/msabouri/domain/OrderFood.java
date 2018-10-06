/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.msabouri.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author Milad
 */
@Entity
@Table(name = "ORDER_FOOD")
public class OrderFood {

    private static final Logger LOG = Logger.getLogger(OrderFood.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;
    @Digits(integer = 3, fraction = 0)
    @Min(1)
    private Integer quantity;
    @Digits(integer = 4, fraction = 2)
    @Min(0)
    @Max(9999)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
    
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;



    public OrderFood() {
    }

    public OrderFood(Date orderDate, Integer quantity, BigDecimal price) {
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Get the value of orderId
     *
     * @return the value of orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Set the value of orderId
     *
     * @param orderId new value of orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderFood{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", quantity=" + quantity + ", price=" + price + '}';
    }
    public Offer getOffer() {
        return offer;
    }
    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
