package com.project.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 后端订单退货单
 * @author backstage
 * @since 2021-04-07
 */

public class RollbackDto implements Serializable {

    /**退货编号*/
    private String pkReId;
    /**销售订单号*/
    private String ordId;
    /**客户账号*/
    private String fkCliAccount;
    /**退货时间*/
    private String roDate;
    /**退货状态 枚举类型：申请中,已退货,已退款,已入库*/
    private String roType;
    /**退货详情编号*/
    private String pkReturnInfoId;
    /**退货编号*/
    private String reId;
    /**退货原因*/
    private String idxReturnInfo;
    /**退货数量*/
    private Integer idxReturnNumber;
    /**退货销售价*/
    private BigDecimal idxReturnPrice;
    /**商品唯一编号*/
    private String fkBackProductId;


}
