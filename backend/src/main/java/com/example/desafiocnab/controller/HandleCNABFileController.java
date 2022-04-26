package com.example.desafiocnab.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.example.desafiocnab.model.CNAB;
import com.example.desafiocnab.service.HandleCNABFileService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController 
@RequestMapping("v1/upload/cnab")
public class HandleCNABFileController {

    private HandleCNABFileService handleCNABFileService;

    public HandleCNABFileController (HandleCNABFileService handleCNABFileService) {

        this.handleCNABFileService = handleCNABFileService;
    }
    @PostMapping
    public ResponseEntity<Void> upload (@RequestParam("file") MultipartFile multipartFile) throws UnsupportedEncodingException, IOException {

        handleCNABFileService.readFile(multipartFile);

        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<CNAB>> findAll () {

        return ResponseEntity.ok(handleCNABFileService.findAll());
    }
}
