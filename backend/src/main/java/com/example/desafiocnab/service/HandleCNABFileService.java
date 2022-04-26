package com.example.desafiocnab.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.desafiocnab.model.CNAB;
import com.example.desafiocnab.repository.HandleCNABFileRepository;
import com.example.desafiocnab.util.DateUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HandleCNABFileService {

    private HandleCNABFileRepository handleCNABFileRepository;

    public HandleCNABFileService(HandleCNABFileRepository handleCNABFileRepository) {
        this.handleCNABFileRepository = handleCNABFileRepository;
    }

    public void readFile(MultipartFile multipartFile) throws UnsupportedEncodingException, IOException {

        List<CNAB> fileList = new ArrayList<>();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(multipartFile.getInputStream(), "UTF-8"));
        while ((line = br.readLine()) != null) {
            fileList.add(CNAB.builder()
                    .tipo(line.substring(0, 1))
                    .data(DateUtil.CNABStringToLocalDate(line.substring(1, 9)))
                    .valor(NormalizeValue(line.substring(9, 19)))
                    .cpf(line.substring(19, 30))
                    .cartao(line.substring(30, 42))
                    .hora(DateUtil.CNABStringToLocalTime(line.substring(42, 48)))
                    .donoLoja(line.substring(48, 62))
                    .nomeLoja(line.substring(62, 80))
                    .build());
        }

        handleCNABFileRepository.saveAll(fileList);
    }

    private BigDecimal NormalizeValue(String value) {

        int newValue = Integer.parseInt(value);
        return new BigDecimal(newValue / 100);
    }

    public List<CNAB> findAll() {
        return handleCNABFileRepository.findAll();
    }
}