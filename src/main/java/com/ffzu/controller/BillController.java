package com.ffzu.controller;

import com.ffzu.pojo.Bill;
import com.ffzu.pojo.Result;
import com.ffzu.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    /**
     * 添加账单接口
     *
     * @param bill 账单对象
     * @return 返回添加结果
     */
    @PostMapping("/add")
    public Result<String> addBill(@RequestBody Bill bill) {
        billService.addBill(bill);
        return Result.success("账单添加成功");
    }

    /**
     * 修改账单接口
     *
     * @param updatedBill 修改后的账单对象
     * @return 返回修改结果
     */
    @PutMapping("/update")
    public Result<String> updateBill(@RequestBody Bill updatedBill) {
        billService.updateBill(updatedBill);
        return Result.success("账单修改成功");
    }

    /**
     * 删除账单接口
     *
     * @param requestData 包含 billNumber 的请求体
     * @return 返回删除结果
     */
    @PostMapping("/delete")
    public Result<String> deleteBill(@RequestBody Map<String, Object> requestData) {
        String billNumber = (String) requestData.get("billNumber");
        billService.deleteBill(billNumber);
        return Result.success("账单删除成功");
    }

    /**
     * 根据日期范围查询账单
     *
     * @param requestData 包含 id, startYear, startMonth, endYear, endMonth 的请求体
     * @return 返回符合条件的账单列表
     */
    @PostMapping("/range")
    public Result<List<Bill>> getBillsByDateRange(@RequestBody Map<String, Object> requestData) {
        String id = (String) requestData.get("id");
        int startYear = (int) requestData.get("startYear");
        int startMonth = (int) requestData.get("startMonth");
        int endYear = (int) requestData.get("endYear");
        int endMonth = (int) requestData.get("endMonth");

        List<Bill> bills = billService.findBillsByDateRange(id, startYear, startMonth, endYear, endMonth);
        return Result.success(bills);
    }

    /**
     * 根据日期范围计算账单总额
     *
     * @param requestData 包含 id, startYear, startMonth, endYear, endMonth 的请求体
     * @return 返回账单总额
     */
    @PostMapping("/sum")
    public Result<BigDecimal> getBillSumByDateRange(@RequestBody Map<String, Object> requestData) {
        String id = (String) requestData.get("id");
        int startYear = (int) requestData.get("startYear");
        int startMonth = (int) requestData.get("startMonth");
        int endYear = (int) requestData.get("endYear");
        int endMonth = (int) requestData.get("endMonth");

        BigDecimal total = billService.getBillSumByDateRange(id, startYear, startMonth, endYear, endMonth);
        return Result.success(total);
    }

    /**
     * 根据账单编号查询账单
     *
     * @param requestData 包含 billNumber 的请求体
     * @return 返回账单详情
     */
    @PostMapping("/get")
    public Result<Bill> getBillByBillNumber(@RequestBody Map<String, Object> requestData) {
        String billNumber = (String) requestData.get("billNumber");
        Bill bill = billService.getBillByBillNumber(billNumber);
        return Result.success(bill);
    }
}
