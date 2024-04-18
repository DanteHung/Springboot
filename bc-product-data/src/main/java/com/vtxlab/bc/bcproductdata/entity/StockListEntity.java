package com.vtxlab.bc.bcproductdata.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tproduct_stock_list")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@ToString
public class StockListEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_code")
    private String stockCode;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // @JsonManagedReference
    // private List<PostEntity> posts = new ArrayList<>();

}