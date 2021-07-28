package com.project.common.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 审核中心和供应商的 订单dto
 */
@Data
public class SupplierOrderDto  implements Serializable {
    /**订单编号*/
    private String orderNumber;
    /**数量*/
    private Long number;
    /**总价*/
    private BigDecimal totalPrice;
    /**采购公司*/
    private String companyName;
    /**收货联系人*/
    private String contact;
    /**收货地址*/
    private String address;
    /**收货联系人电话*/
    private String tel;
    /**订单创建时间*/
    private LocalDate orderCreateDate;
    /**采购订单编号*/
    private String purchasingInfoNumber;

    /**商品类型*/
    private String productTypeLx;
	/**商品规格*/	
    private String productTypeGg;
    /**商品名称*/	
	private String productSnapshopName;
	/**商品照片路径*/	
    private String productSnapshopPath;
	/**商品单价*/	
    private BigDecimal productSnapshopPrice;
	/**商品生产日期*/	
    private LocalDate productSnapshopDate;
    /**商品编号*/
    private String productNumber;
    /**供应商编号*/
    private String supplierNumber;
}
