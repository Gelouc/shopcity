package com.project.common.service.supplierfeign;

import com.project.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "shop-supplier-system")
public interface SupplierAuditService {

    @PostMapping("/pscSuppliers/updateStatus")
    Result updateRegistryStatus(@PathVariable("supplierNumber") String supplierNumber, @PathVariable("status") String status);
    @PostMapping("/supplierAudit/updateStatusGrade")
    Result updateStatusGrade(String supplierNumber,Integer supplierStatus,Integer supplierGrade,String supplierComment);

    @PostMapping("/supplierAudit/updateRegistryStatus")
    Result updateRegistryStatus(String supplierNumber,Integer supplierStatus,String supplierComment);

    @GetMapping("/supplierAudit/findById")
    Result findById(String supplierNumber);

    @GetMapping("/supplierAudit/findAll")
    Result findAll(Integer page, Integer size,String supplierName);

//    @PostMapping("/supplierAudit/add")
//    Result add(SysAuditSupplierInfoBean sysAuditSupplierInfoBean);
}
