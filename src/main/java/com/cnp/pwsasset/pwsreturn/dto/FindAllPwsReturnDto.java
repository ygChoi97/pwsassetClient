package com.cnp.pwsasset.pwsreturn.dto;

import com.cnp.pwsasset.pwsreturn.entity.PwsReturn;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllPwsReturnDto {
    private int count;
    private List<PwsReturnDto> pwsReturnDtos;

    public FindAllPwsReturnDto(List<PwsReturn> pwsReturnList) {
        this.count = pwsReturnList.size();
        this.covertDtoList(pwsReturnList);
    }

    private void covertDtoList(List<PwsReturn> pwsReturnList) {
        List<PwsReturnDto> dtos = new ArrayList<>();

        for(PwsReturn pwsReturn : pwsReturnList) {
            dtos.add(new PwsReturnDto(pwsReturn));
        }
        this.pwsReturnDtos = dtos;
    }


}
