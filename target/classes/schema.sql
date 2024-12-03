-- 创建用户表
CREATE TABLE IF NOT EXISTS userForm (
                                        id VARCHAR(10) PRIMARY KEY,          -- 宿舍号, 格式为 xx#xxx
                                        password VARCHAR(50) DEFAULT '123456' -- 默认密码
);

-- 插入默认管理员账号
INSERT IGNORE INTO userForm (id, password)
VALUES ('admin', '000000');

-- 创建账单表
CREATE TABLE IF NOT EXISTS billForm (
                                        id VARCHAR(10),                     -- 用户表单的 id (宿舍号)
                                        waterBill DECIMAL(10, 2),           -- 水费
                                        electricityBill DECIMAL(10, 2),     -- 电费
                                        amount DECIMAL(10, 2),              -- 总金额 (水费 + 电费)
                                        year INT,                           -- 年份
                                        month INT,                          -- 月份
                                        billNumber VARCHAR(15),             -- 账单号 (格式为宿舍号加年月)
                                        FOREIGN KEY (id) REFERENCES userForm(id) -- 外键，关联用户表的 id
);

-- 删除已存在的触发器（避免重复创建报错）
DROP TRIGGER IF EXISTS calculateAmountBeforeInsert;
DROP TRIGGER IF EXISTS generateBillNumberBeforeInsert;

-- 创建触发器：在插入账单时自动计算并插入 `amount` 字段
CREATE TRIGGER calculateAmountBeforeInsert
    BEFORE INSERT ON billForm
    FOR EACH ROW
BEGIN
    SET NEW.amount = NEW.waterBill + NEW.electricityBill;
END;

-- 创建触发器：在插入账单时自动生成 `billNumber` 字段
CREATE TRIGGER generateBillNumberBeforeInsert
    BEFORE INSERT ON billForm
    FOR EACH ROW
BEGIN
    SET NEW.billNumber = CONCAT(NEW.id, LPAD(NEW.year, 4, '0'), LPAD(NEW.month, 2, '0'));
END;

-- 删除已存在的存储过程（避免重复创建报错）
DROP PROCEDURE IF EXISTS generateDormIds;

-- 创建存储过程来插入宿舍号数据
DELIMITER $$

CREATE PROCEDURE generateDormIds()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE j INT DEFAULT 101;  -- 每栋楼的宿舍号从 101 开始
    DECLARE dormId VARCHAR(10);

    -- 循环生成宿舍号
    WHILE i <= 50 DO
            SET j = 101;  -- 重置 j 的初始值为 101

            WHILE j <= 520 DO
                    -- 使用 CONCAT 拼接宿舍号
                    SET dormId = CONCAT(LPAD(i, 2, '0'), '#', LPAD(j, 3, '0'));
                    INSERT IGNORE INTO userForm (id) VALUES (dormId);
                    SET j = j + 1;
                END WHILE;

            SET i = i + 1;
        END WHILE;
END$$

DELIMITER ;

-- 调用存储过程来插入宿舍号
CALL generateDormIds();

-- 删除存储过程以避免后续重复创建
DROP PROCEDURE IF EXISTS generateDormIds;

