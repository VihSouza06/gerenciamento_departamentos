package com.bn.exercicio8.Repositories;

import com.bn.exercicio8.Models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {
}
