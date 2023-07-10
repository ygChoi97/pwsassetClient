package com.cnp.pwsasset.pws.service;

import com.cnp.pwsasset.pws.dto.FindAllPwsDto;
import com.cnp.pwsasset.pws.dto.PwsDto;
import com.cnp.pwsasset.pws.dto.ItemNameOfAssetDTO;
import com.cnp.pwsasset.pws.entity.Pws;
import com.cnp.pwsasset.pws.repository.PwsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PwsService {
    private final PwsRepository repository;

    public FindAllPwsDto findAllService() {

        return new FindAllPwsDto(repository.findAll());
    }
    public PwsDto findOneServiceFromIdasset(String managementId) {

        Pws pws = repository.findOneFromIdasset(managementId);
        log.info("findOneFromIdasset returns data - {}", pws);

        return pws!=null ? new PwsDto(pws) : null;
    }

    public PwsDto findOneFromSNService(String sn) {
        Pws pws = repository.findOneFromSN(sn);
        log.info("findOneFromSNService returns data - {}", pws);

        return pws!=null ? new PwsDto(pws) : null;
    }
    //    public List<ResponseDTO> queryColumnCommentService() {
    public List<ItemNameOfAssetDTO> queryColumnCommentService() {

        List<ItemNameOfAssetDTO> column_info = repository.queryColumnComment();
        log.info("queryColumnCommentService returns data - {}", column_info);

        return column_info;
    }

    public FindAllPwsDto createService(final Pws newPws) {

        if(newPws == null) {
            log.warn("newPws cannot be null!");
            throw new RuntimeException("newPws cannot be null!");
        }

        boolean flag = repository.save(newPws);

        if(flag) log.info("자산관리번호 {} 등록되었습니다.", newPws.getIdasset());
        if(flag == false)
            log.warn("자산관리번호 {} 등록되지 않았습니다.", newPws.getIdasset());

        return flag ? findAllService() : null;

    }

    public FindAllPwsDto updateServiceWhereIdasset(final Pws pws) {
        if (pws == null) {
            log.warn("pws cannot be null!");
            throw new RuntimeException("pws cannot be null!");
        }

        boolean flag = repository.modifyWhereIdasset(pws);
        if(flag == false)
            log.warn("자산이 업데이트되지 않았습니다.");
        return flag ? findAllService() : null;

    }

    public FindAllPwsDto updateServiceWhereSN(Pws pws) {
        if (pws == null) {
            log.warn("pws cannot be null!");
            throw new RuntimeException("pws cannot be null!");
        }

        boolean flag = repository.modifyWhereSN(pws);
        if(flag == false)
            log.warn("자산이 업데이트되지 않았습니다.");
        return flag ? findAllService() : null;
    }

    public FindAllPwsDto importFromExcelService(List<Pws> list) {
        if(list == null) {
            log.warn("list cannot be null!");
            throw new RuntimeException("list cannot be null!");
        }
        boolean flag = repository.insertData(list);

        if(flag) log.info("자산 {}개 항목이 추가/업데이트되었습니다.", list.size());
        if(flag == false)
            log.warn("자산이 업데이트되지 않았습니다.");

        return flag ? findAllService() : null;
    }

    public FindAllPwsDto findDisposalAllService(String search) {
        return new FindAllPwsDto(repository.findDisposalAll(search));
    }
}
