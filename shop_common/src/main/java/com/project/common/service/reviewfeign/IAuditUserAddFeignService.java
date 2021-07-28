package com.project.common.service.reviewfeign;

import com.project.common.dto.UserDto;
import com.project.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="shop-review")
@Api("用户远程调用接口")
public interface IAuditUserAddFeignService {

    @ApiOperation("加入要审核的用户")
    @PostMapping("/auditUsers/add")
    Result addUserInfo(UserDto userDto);

    @ApiOperation("修改用户审核状态")
    @PostMapping("/auditUsers/updateStatus")
    Result updateStatus(@RequestParam("userName") String userName,@RequestParam("status") String status);

}
