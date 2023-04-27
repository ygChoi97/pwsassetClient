package com.cnp.pwsasset.pwsreturn.service;

import com.cnp.pwsasset.pws.dto.ItemNameOfAssetDTO;
import com.cnp.pwsasset.pwsreturn.dto.FindAllPwsReturnDto;
import com.cnp.pwsasset.pwsreturn.entity.PwsReturn;
import com.cnp.pwsasset.pwsreturn.repository.PwsReturnRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PwsReturnService {
    private final PwsReturnRepository repository;
    public FindAllPwsReturnDto findAllService() {
        return new FindAllPwsReturnDto(repository.findAll());
    }

    public FindAllPwsReturnDto importFromExcelService(List<PwsReturn> list) {
        if(list == null) {
            log.warn("list cannot be null!");
            throw new RuntimeException("list cannot be null!");
        }
        boolean flag = repository.insertData(list);

        if(flag) log.info("반납 {}개 항목이 추가/업데이트되었습니다.", list.size());
        if(!flag)
            log.warn("반납이 업데이트되지 않았습니다.");

        return flag ? findAllService() : null;
    }

    public List<ItemNameOfAssetDTO> queryColumnCommentService() {
        List<ItemNameOfAssetDTO> column_info = repository.queryColumnComment();
        log.info("queryColumnCommentService returns data - {}", column_info);

        return column_info;
    }
}
