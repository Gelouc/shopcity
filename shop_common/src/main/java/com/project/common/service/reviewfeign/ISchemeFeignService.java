package com.project.common.service.reviewfeign;


import com.project.common.dto.SchemeDto;
import com.project.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="shop-review")
public interface ISchemeFeignService {
    @PostMapping("/sys-audit-scheme-bean/saveScheme")
    Result saveScheme(@RequestBody SchemeDto schemeDto);
}
