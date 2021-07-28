package com.project.common.service.backfeign;

import com.project.common.dto.CustomerReturnGoodsDto;
import com.project.common.dto.RollbackDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.transform.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author backstage
 * @since 2021-04-07
 */
@FeignClient(value = "backstage-system")
public interface IProductRollbackService{

    /**
     * 添加退货订单及详情
     * @param customerReturnGoodsDto 退货详情
     * @return
     */
    @PutMapping("/rollback/saveRoll")
    Result saveRoll(@RequestParam CustomerReturnGoodsDto customerReturnGoodsDto,@RequestParam String info);

}
