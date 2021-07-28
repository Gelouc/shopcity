package com.project.common.service.frontfeign;

import com.project.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value="shop-front-desk")
@Api("用户远程调用接口")
public interface IUserFeignService {
    @ApiOperation("通过用户名修改用户状态")
    @PutMapping("/users")
    Result updateUserStatus (@RequestParam String cliName, @RequestParam Integer cliState);

    @ApiOperation("通过用户名修改用户等级和折扣")
    @PutMapping("/users/updateUserGrade")
    Result updateUserGrade (@RequestParam String cliName, @RequestParam Integer userGrade,@RequestParam BigDecimal userDiscount);
}
