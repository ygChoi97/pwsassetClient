package com.cnp.pwsasset.pwsprovision.api;

import com.cnp.pwsasset.pws.dto.ItemNameOfAssetDTO;
import com.cnp.pwsasset.pwsprovision.dto.FindAllPwsProvisionDto;
import com.cnp.pwsasset.pwsprovision.entity.PwsProvision;
import com.cnp.pwsasset.pwsprovision.service.PwsProvisionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/provision")
@RequiredArgsConstructor
@CrossOrigin
public class PwsProvisionApiController {
    private final PwsProvisionService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info("/api/provision GET request!");

        FindAllPwsProvisionDto dtos = service.findAllService();
        if(dtos.getCount() < 1) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/import")
    public ResponseEntity<?> updateDB(@RequestBody List<PwsProvision> list ) {
        log.info("/api/provision/import POST request!");

        try {
            FindAllPwsProvisionDto dtos = service.importFromExcelService(list);

            if (dtos == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(dtos);

        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<?> findPwsProvisionMenu() {
        log.info("/api/provision/menu GET request!");

        List<ItemNameOfAssetDTO> column_info = service.queryColumnCommentService();

        if(column_info == null) ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(column_info);
    }
}
