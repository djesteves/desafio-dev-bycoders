package com.example.desafiocnab.api.cnab.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.desafiocnab.exception.UnprocessableEntityException;
import com.example.desafiocnab.api.cnab.entity.CNAB;
import com.example.desafiocnab.api.cnab.repository.HandleCNABFileRepository;
import com.example.desafiocnab.util.DateUtil;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Log4j2
public class HandleCNABFileService {

    private HandleCNABFileRepository handleCNABFileRepository;

    public HandleCNABFileService(HandleCNABFileRepository handleCNABFileRepository) {
        this.handleCNABFileRepository = handleCNABFileRepository;
    }

    public void readFile(MultipartFile multipartFile) throws IOException {

        log.info("Iniciando validação e parser do documento!");

        if (multipartFile.isEmpty()) {
            log.error("O Arquivo está vazio!");
            throw new UnprocessableEntityException("O Arquivo está vazio!");
        }

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
                    .build()
            );
        }

        handleCNABFileRepository.saveAll(fileList);

        log.info("Validação e parser do documento realizada com sucesso!");
    }

    private BigDecimal NormalizeValue(String value) {

        int newValue = Integer.parseInt(value);
        return new BigDecimal(newValue / 100);
    }

    public List<CNAB> findAll() {
        return handleCNABFileRepository.findAll();
    }
}