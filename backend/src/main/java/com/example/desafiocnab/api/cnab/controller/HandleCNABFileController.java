package com.example.desafiocnab.api.cnab.controller;

import com.example.desafiocnab.api.cnab.entity.CNAB;
import com.example.desafiocnab.api.cnab.entity.CNABResponse;
import com.example.desafiocnab.api.cnab.service.HandleCNABFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1/cnab")
public class HandleCNABFileController {

    private HandleCNABFileService handleCNABFileService;

    public HandleCNABFileController(HandleCNABFileService handleCNABFileService) {
        this.handleCNABFileService = handleCNABFileService;
    }

    @PostMapping("upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        handleCNABFileService.readFile(multipartFile);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<CNAB>> findAll () {

        return ResponseEntity.ok(handleCNABFileService.findAll());
    }

    @GetMapping("total_store")
    public ResponseEntity<List<CNABResponse>> calcTotalLoja () {

        return ResponseEntity.ok(handleCNABFileService.calcTotalLoja());
    }
}
