package com.project.common.service.backfeign;

import com.project.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "backstage-system")
public interface IPromoteService {
    /**
     * 按照促销订单编号修改促销状态
     * @param promoteId 促销唯一编号
     * @param state     促销状态(‘促销’,'未促销','待审核')
     * @return
     */
    @PutMapping("/promotes/updatePromoteState")
    Result updatePromoteState(@RequestParam String promoteId, @RequestParam String state);
}
