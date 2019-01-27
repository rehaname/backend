package com.oocl.ir4.gipp.backend.controller;

import com.oocl.ir4.gipp.backend.DatabaseConnection;
import com.oocl.ir4.gipp.backend.dto.PairingDTO;
import com.oocl.ir4.gipp.backend.transaction.PairingTransaction;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
public class PairingController {

//    @PostMapping("/group")
//    ResponseEntity<PairingDTO> createGroup(@Valid @RequestBody PairingDTO pairingDTO) throws URISyntaxException {
//        log.info("Request to create group: {}", group);
//        Group result = groupRepository.save(group);
//        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
//                .body(result);
//    }

    @RequestMapping(value = "/api/pairingsave", method = RequestMethod.GET, params = { "jsonString" })
    @CrossOrigin(origins = "*")
    public String savePairing(@RequestParam("jsonString") String json) {
        PairingTransaction result = new PairingTransaction();
        result.execute();
        return result.getResult();
    }
}
