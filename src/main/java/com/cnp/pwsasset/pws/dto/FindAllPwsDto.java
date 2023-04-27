package com.cnp.pwsasset.pws.dto;

import com.cnp.pwsasset.pws.entity.Pws;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllPwsDto {
    private int count;
    private List<PwsDto> pwsDtos;

    public FindAllPwsDto(List<Pws> pwsList) {
        this.count = pwsList.size();
        this.convertDtoList(pwsList);
    }
    public void convertDtoList(List<Pws> pwsList) {
        List<PwsDto> dtos = new ArrayList<>();

        for(Pws pws : pwsList) {
            dtos.add(new PwsDto(pws));
        }
        this.pwsDtos = dtos;
    }
}
