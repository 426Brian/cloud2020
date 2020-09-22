package com.cloud.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    void update(@Param("money") BigDecimal money, @Param("userId") Long usedId);

}
