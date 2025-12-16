package com.jaegokeeper.hwan.mapper;

import com.jaegokeeper.hwan.domain.Item;
import com.jaegokeeper.hwan.dto.ItemDetailDTO;
import com.jaegokeeper.hwan.dto.ItemListDTO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {

    void insertItem(Item item);

    long countItemList(@Param("storeId") Integer storeId,
                       @Param("filters") List<String> filters,
                       @Param("keyword")String keyword);

    List<ItemListDTO> findItemList(@Param("storeId") Integer storeId,
                                   @Param("filters") List<String> filters,
                                   @Param("keyword") String keyword,
                                   @Param("offset") int offset,
                                   @Param("size") int size);

    ItemDetailDTO findItemDetail(@Param("storeId") Integer storeId,
                                 @Param("itemId") Integer itemId);
}
