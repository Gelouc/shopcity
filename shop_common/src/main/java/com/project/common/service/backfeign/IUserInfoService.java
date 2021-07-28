package com.project.common.service.backfeign;


import com.project.common.dto.UserDto;
import com.project.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "backstage-system")
public interface IUserInfoService {

    @PostMapping("/userInfo/add")
    Result saveUser(@RequestParam UserDto userDto);

    /**
     * 修改用户状态
     * @param account 用户账户名
     * @param status 用户状态
     * @return
     */
    @PutMapping("/userInfo/updateUserStatus/{account}/{status}")
    Result updateUserStatus(@PathVariable("account") String account,
                            @PathVariable("status") String status);
}
