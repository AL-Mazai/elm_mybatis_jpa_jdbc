package com.elm.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer businessId;

    @Override
    public String toString() {
        return "\n食品编号："+this.foodId+
                "\n食品名称："+this.foodName+
                "\n食品介绍："+this.foodExplain+
                "\n食品价格："+this.foodPrice+
                "\n所属商家："+this.businessId;
    }
}
