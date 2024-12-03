package com.ffzu.mapper;

import com.ffzu.pojo.Bill;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BillMapper {

    // 插入账单：触发器会自动计算并插入 `amount` 和 `billNumber`
    @Insert("INSERT INTO billForm (id, waterBill, electricityBill, year, month) " +
            "VALUES (#{id}, #{waterBill}, #{electricityBill}, #{year}, #{month})")
    void insertBill(Bill bill);

    // 查询账单：按日期范围查询
    @Select("SELECT id, waterBill, electricityBill, amount, billNumber, year, month " +
            "FROM billForm " +
            "WHERE id = #{id} " +
            "AND (year > #{startYear} OR (year = #{startYear} AND month >= #{startMonth})) " +
            "AND (year < #{endYear} OR (year = #{endYear} AND month <= #{endMonth}))")
    List<Bill> findBillsByDateRange(@Param("id") String id,
                                    @Param("startYear") int startYear, @Param("startMonth") int startMonth,
                                    @Param("endYear") int endYear, @Param("endMonth") int endMonth);


    // 查询所有账单
    @Select("SELECT id, waterBill, electricityBill, amount, billNumber, year, month FROM billForm")
    List<Bill> getAllBills();

    // 更新账单：更新 `waterBill` 和 `electricityBill`，`amount` 由触发器更新
    @Update("UPDATE billForm SET waterBill = #{waterBill}, electricityBill = #{electricityBill}, " +
            "year = #{year}, month = #{month} WHERE id = #{id} AND billNumber = #{billNumber}")
    void updateBill(Bill bill);

    // 删除账单
    @Delete("DELETE FROM billForm WHERE billNumber = #{billNumber}")
    void deleteBill(@Param("billNumber") String billNumber);

    // 根据账单号查询单个账单
    @Select("SELECT id, waterBill, electricityBill, amount, billNumber, year, month " +
            "FROM billForm WHERE billNumber = #{billNumber}")
    Bill getBillByBillNumber(@Param("billNumber") String billNumber);
}
