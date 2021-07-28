package com.project.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GoodsDto implements Serializable {
    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品类型
     */
    private String goodsType;


    /**
     * 商品规格
     */
    private String goodsSpe;

    /**
     * 商品数量
     */
    private Integer goodsStock;

    /**
     * 商品进价
     */
    private BigDecimal goodsPurchaseprice;

    /**
     * 上架状态
     */
    private String goodsState = "下架";


    /**
     * 商品厂商
     */
    private String goodsFactory;

    /**
     * 商品销售价
     */
    private BigDecimal goodsSaleprice;
}
