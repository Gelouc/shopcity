package com.project.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoDto implements Serializable {
    /**
     * 订单详情编号，唯一标识
     */
    private String orderInfoCode;

    /**
     * 订单生成日期
     */
    private LocalDate orderInfoCreate;

    /**
     * 订单详情状态
     */
    private String orderInfoState;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 订单详情总价
     */
    private BigDecimal money;

    /**
     * 商品对象
     */
    private GoodsDto goodsDto;
}
