package com.cnp.pwsasset.pwsreturn.repository;

import com.cnp.pwsasset.pws.dto.ItemNameOfAssetDTO;
import com.cnp.pwsasset.pwsreturn.entity.PwsReturn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PwsReturnRepository {
    List<PwsReturn> findAll();

    boolean insertData(List<PwsReturn> list);

    List<ItemNameOfAssetDTO> queryColumnComment();
}
