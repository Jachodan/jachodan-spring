package com.jaegokeeper.hwan.mapper;

import org.apache.ibatis.annotations.Param;

public interface StockHistoryMapper {

//    @Param quantity는 변화량
    int insertHistory(@Param("stockId") Integer stockId,
                      @Param("hisType") String hisType,
                      @Param("delta") Integer quantity);
}
