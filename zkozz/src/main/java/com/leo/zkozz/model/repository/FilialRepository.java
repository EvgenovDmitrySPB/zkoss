package com.leo.zkozz.model.repository;

import com.leo.zkozz.model.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Integer> {

}
