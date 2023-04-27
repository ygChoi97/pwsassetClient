package com.cnp.pwsasset.pwsprovision.dto;

import com.cnp.pwsasset.pws.dto.PwsDto;
import com.cnp.pwsasset.pws.entity.Pws;
import com.cnp.pwsasset.pwsprovision.entity.PwsProvision;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllPwsProvisionDto {
    private int count;
    private List<PwsProvisionDto> pwsProvisionDtos;

    public FindAllPwsProvisionDto(List<PwsProvision> pwsProvisionList) {
        this.count = pwsProvisionList.size();
        this.convertDtoList(pwsProvisionList);
    }

    private void convertDtoList(List<PwsProvision> pwsProvisionList) {
        List<PwsProvisionDto> dtos = new ArrayList<>();

        for(PwsProvision pwsProvision : pwsProvisionList) {
            dtos.add(new PwsProvisionDto(pwsProvision));
        }
        this.pwsProvisionDtos = dtos;
    }
}
