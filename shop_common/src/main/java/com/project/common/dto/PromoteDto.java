package com.project.common.dto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

/**
 * <p>
 *  促销方案审核
 * </p>
 *
 * @author frank
 * @since 2021-04-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PromoteDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    /**
     * 主键
     */
    private Long pkPromotionId;
    /**
     * 商品唯一标识
     */
    private String pPrudunctId;
    /**
     * 商品名
     */
    private String pPrudunctName;
    /**
     * 促销数量
     */
    private Integer pPrudunctNum;
    /**
     * 促销价格
     */
    private double pProductPrice;

    /**
     * 促销折扣率
     */
    private BigDecimal pPrudunctRate;
    /**
     * 发起人
     */
    private String pBuildName;
    /**
     * 促销详情
     */
    private String pPlan;

    /**
     * 默认未审核，未审核是0，已审核是1，已通过是2
     */
    private String pState;

    /**
     * 促销订单唯一标识
     */
    private String pOnlyId;
    /**
     * 申请日期
     */
    private LocalDate pDate = LocalDate.now();

//    /**
//     * 促销审核日志
//     */
//    @TableField(exist = false)
//    private List<SysAuditPromotionInfoBean> infoList;
}
