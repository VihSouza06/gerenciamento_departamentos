package com.bn.exercicio8.Services;

import com.bn.exercicio8.Models.DepartamentoModel;
import com.bn.exercicio8.Repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public void deletarDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }

    public DepartamentoModel buscarDepartamentoPorId(Long id){
        return departamentoRepository.findById(id).get();
    }

    public DepartamentoModel atualizarDepartamento(Long id, DepartamentoModel departamentoModel){
        DepartamentoModel novoDepartamento = departamentoRepository.findById(id).get();
        novoDepartamento.setNome(departamentoModel.getNome());
        novoDepartamento.setLocalizacao(departamentoModel.getLocalizacao());
        return departamentoRepository.save(novoDepartamento);

    }

}
