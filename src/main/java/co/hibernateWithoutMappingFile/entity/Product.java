package co.hibernateWithoutMappingFile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_DTLS")
public class Product {
    @Id
    @Column(name="PRODUCT_ID")
    private Integer productId;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="PRODUCT_PRICE")
    private Float productPrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }
}
