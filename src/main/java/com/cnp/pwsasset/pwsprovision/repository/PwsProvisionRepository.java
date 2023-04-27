package com.cnp.pwsasset.pwsprovision.repository;

import com.cnp.pwsasset.pws.dto.ItemNameOfAssetDTO;
import com.cnp.pwsasset.pwsprovision.entity.PwsProvision;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PwsProvisionRepository {
    List<PwsProvision> findAll();

    List<ItemNameOfAssetDTO> queryColumnComment();

    boolean insertData(List<PwsProvision> list);
}
