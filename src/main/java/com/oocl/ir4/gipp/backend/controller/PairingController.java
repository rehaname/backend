package com.oocl.ir4.gipp.backend.controller;

import com.oocl.ir4.gipp.backend.Repository.PairingRepository;
import com.oocl.ir4.gipp.backend.model.PairingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping(path="/api/pairings")
@CrossOrigin(origins = "*")
public class PairingController {
    @Autowired
    private PairingRepository pairingRepository;

//    @GetMapping(path="/addPair")
//    public @ResponseBody String addNewPair (@RequestParam String name, @RequestParam String name1, @RequestParam Integer pairCount) {
//        PairingModel pairingModel = new PairingModel();
//        pairingModel.setName(name);
//        pairingModel.setName1(name1);
//        pairingModel.setPairCount(pairCount);
//
//        pairingRepository.save(pairingModel);
//
//        return "Saved";
//    }

    @PostMapping(path="/addNewPair")
    ResponseEntity<PairingModel> addNewPair(@RequestBody PairingModel pairingModel) throws URISyntaxException {
        PairingModel result = pairingRepository.save(pairingModel);

        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }
}
