package com.example.hello_shoes_02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "stock")
public class InventoryEntity {

//    @EmbeddedId
//    private InventoryPrimaryKey id;
    @Id
    private String stockId;

//    @ManyToOne
//    @JoinColumn(name ="itemCode" , nullable = false)
//    private ProductEntity itemEntity;

//    @ManyToOne
//    @JoinColumn(name ="supplierCode",nullable = false)
//    private SupplierEntity supplierEntity;

    private Integer qty;
    private Integer max_qty;
    private Integer size;

    @Temporal(TemporalType.DATE)
    private Date lastDate;

    @Temporal(TemporalType.DATE)
    private Date nextDate;

    private Double buy_price;


}
