package com.project.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    /**
     * 用户名，唯一标识
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户预存款
     */
    private BigDecimal userMoney;

    /**
     * 用户状态：快速注册为null,正式注册为默认为0,0表示待审核，1表示已审核，2表示审核未通过
     */
    private String userStatus;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户电话
     */
    private String phoneNum;

    /**
     * 资质图片
     */
    private String userPicture;

    /**
     * 身份证图片
     */
    private String userIdimage;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 用户等级
     */
    private Integer userGrade;

    /**
     * 等级折扣
     */
    private BigDecimal userDiscount;
}
