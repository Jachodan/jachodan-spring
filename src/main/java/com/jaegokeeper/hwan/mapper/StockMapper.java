package com.jaegokeeper.hwan.mapper;

import com.jaegokeeper.hwan.domain.Stock;
import com.jaegokeeper.hwan.dto.StockKeyDTO;
import org.apache.ibatis.annotations.Param;

public interface StockMapper {

    //아이템 생성시 stock 삽입용 추후 변경 가능??
    void insertStock(Stock stock);

    //    스토어값과 아이템값에 맞는 아이템의 재고수량을 불러옴
    StockKeyDTO findStockKey(@Param("storeId") Integer storeId,
                             @Param("itemId") Integer itemId);


    //재고수량를 업데이트
    int updateQuantity(@Param("stockId") Integer stockId,
                       @Param("quantity") Integer quantity,
                       @Param("favoriteYn") Boolean favoriteYn);

}
