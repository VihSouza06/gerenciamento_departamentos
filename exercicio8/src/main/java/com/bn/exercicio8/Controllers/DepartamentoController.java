package com.bn.exercicio8.Controllers;

import com.bn.exercicio8.Models.DepartamentoModel;
import com.bn.exercicio8.Services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> departamentos = departamentoService.findAll();
        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> buscarDepartamentoPorId(@PathVariable Long id){
        DepartamentoModel departamento = departamentoService.buscarDepartamentoPorId(id);
        return ResponseEntity.ok(departamento);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel departamentoCriado = departamentoService.criarDepartamento(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(departamentoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(departamentoCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoModel> atualizarDepartamento
            (@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel departamentoAtualizado = departamentoService.atualizarDepartamento(id,departamentoModel);
        return ResponseEntity.ok(departamentoAtualizado);
    }


}
