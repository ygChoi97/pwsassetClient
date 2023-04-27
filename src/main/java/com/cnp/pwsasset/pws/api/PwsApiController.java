package com.cnp.pwsasset.pws.api;

import com.cnp.pwsasset.pws.dto.FindAllPwsDto;
import com.cnp.pwsasset.pws.dto.PwsDto;
import com.cnp.pwsasset.pws.dto.ItemNameOfAssetDTO;
import com.cnp.pwsasset.pws.entity.Pws;
import com.cnp.pwsasset.pws.service.PwsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/pws")
@RequiredArgsConstructor
@CrossOrigin
public class PwsApiController {
    private final PwsService service;

    /**
     * 자산 전체 조회 API
     * @return
     */
    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info("/api/pws GET request!");

        FindAllPwsDto dtos = service.findAllService();
        if(dtos.getCount() < 1) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dtos);
    }

    /**
     * 자산(매각, 매각대기) 전체 조회 API
     * @return
     */
    @GetMapping("/disposal")
    public ResponseEntity<?> findDisposalAll() {
        log.info("/api/pws/disposal GET request!");
        String search = "매각";
        FindAllPwsDto dtos = service.findDisposalAllService(search);
        if(dtos.getCount() < 1) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dtos);
    }

    /**
     * 자산 개별 조회 API
     * @param managementId
     * @return
     */
    @GetMapping("/{managementId}")
    public ResponseEntity<?> findPws(@PathVariable String managementId) {
        log.info("/api/pws/{} GET request!", managementId);
        if(managementId == null) return ResponseEntity.badRequest().build();

        PwsDto dto = service.findOneService(managementId);

        if(dto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dto);
    }

    /**
     * 자산 등록 API
     * @param newPws
     * @return
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pws newPws) {
        log.info("/api/pws/{} POST request!", newPws);

        try {
            FindAllPwsDto dtos = service.createService(newPws);

            if (dtos == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(dtos);

        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     *
     * @param list
     * @return
     */
    @PostMapping("/import")
    public ResponseEntity<?> updateDB(@RequestBody List<Pws> list ) {
        log.info("/api/pws/import POST request!");

        try {
            FindAllPwsDto dtos = service.importFromExcelService(list);

            if (dtos == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(dtos);

        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    /**
     * 자산 정보 수정 API
     * @param pws
     * @return
     */
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Pws pws) {
        log.info("api/pws{} PUT request!", pws);

        try {
            FindAllPwsDto dtos = service.updateService(pws);
            return ResponseEntity.ok().body(dtos);
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * 자산 세부항목명 조회 API
     * @return
     */
    @GetMapping("/menu")
    public ResponseEntity<?> findPwsMenu() {
        log.info("/api/pws/menu GET request!");

        List<ItemNameOfAssetDTO> column_info = service.queryColumnCommentService();

        if(column_info == null) ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(column_info);
    }
}
