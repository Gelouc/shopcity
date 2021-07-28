package com.project.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {
    /**
     * 用户名，唯一标识
     */
    private String userName;

    /**
     * 订单编号，唯一标识
     */
    private String orderCode;

    /**
     * 订单总价
     */
    private BigDecimal orderMoney;

    /**
     * 收货人姓名
     */
    private String orderName;

    /**
     * 收货人地址
     */
    private String orderAddress;

    /**
     * 收货人电话
     */
    private String orderTel;
    /**
     * 订单详情集合
     */
    private List<OrderInfoDto> orderInfoDtoList;
}
