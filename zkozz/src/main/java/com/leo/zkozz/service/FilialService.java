package com.leo.zkozz.service;

import com.leo.zkozz.model.Filial;
import com.leo.zkozz.model.repository.FilialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilialService {

    private final FilialRepository filialRepository;

    public FilialService(FilialRepository filialRepository) {
        this.filialRepository = filialRepository;
    }

    public List<Filial> findAll() {
        return filialRepository.findAll();
    }
}
