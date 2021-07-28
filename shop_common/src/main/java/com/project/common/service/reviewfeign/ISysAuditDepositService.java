package com.project.common.service.reviewfeign;

import com.project.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("shop-review")
public interface ISysAuditDepositService {

    @ApiOperation(value = "根据用户名称修改用户的预存款",notes = "正数表示存入添加，负数表示消费扣除,可以传操作类型(存入、消费、退款)，若不传则自动判断存入或消费")
    @PostMapping("/deposits/addDeposit")
    Result updateDepositByName(@RequestParam String userName,
                               @RequestParam BigDecimal userDeposit,
                               @RequestParam(required = false) String operationStyle);

    @GetMapping("/findByUserName/{userName}")
    @ApiOperation(value = "查询用户详情",notes = "包括得到用户的预存款变动记录")
    Result findByName(@PathVariable("userName") String userName);

}
