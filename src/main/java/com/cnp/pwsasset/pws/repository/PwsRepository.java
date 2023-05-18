package com.cnp.pwsasset.pws.repository;

import com.cnp.pwsasset.pws.dto.ItemNameOfAssetDTO;
import com.cnp.pwsasset.pws.entity.Pws;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PwsRepository {

    /**
     * 자산 개별 조회 SQL
     * @param managementId
     * @return
     */
    Pws findOneFromIdasset(String managementId);

    /**
     *
     * @param sn
     * @return
     */

    Pws findOneFromSN(String sn);
    /**
     * 자산 세부항목명 조회 SQL
     * @return
     */
    List<ItemNameOfAssetDTO> queryColumnComment();

    /**
     * 자산 등록 SQL
     * @param pws
     * @return
     */
    boolean save(Pws pws);

    /**
     * 자산 전체 조회 SQL
     * @return
     */
    List<Pws> findAll();

    /**
     * 자산 정보 수정 SQL
     * @param pws
     * @return
     */
    boolean modifyWhereIdasset(Pws pws);

    /**
     *
     * @param pws
     * @return
     */
    boolean modifyWhereSN(Pws pws);

    boolean modifyWhereID(Pws pws);

    /**
     *  자산 목록 등록 SQL
     * @param list
     * @return
     */

    boolean insertData(List<Pws> list);

    List<Pws> findDisposalAll(String search);


}
