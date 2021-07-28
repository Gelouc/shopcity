package com.project.common.service.supplierfeign;

import com.project.common.dto.UserDto;
import com.project.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shop-supplier-system")
public interface IPurchasingFeignService {
    /**
     * 按招标编号修改招标状态及投标评价
     * @param purChasingInfoNumber  招标编号
     * @param status 招标状态（投标成功，投标失败）
     * @param purchasingInfo 招标评论
     */
    @PutMapping("pscPurchasingInfos/{purChasingInfoNumber}")
    Result update(
            @PathVariable("purChasingInfoNumber") String purChasingInfoNumber,
            @RequestParam String status,
            @RequestParam String purchasingInfo);

}
