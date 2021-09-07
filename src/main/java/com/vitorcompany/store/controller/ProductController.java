package com.vitorcompany.store.controller;


import com.vitorcompany.store.product.ProductDTO;
import com.vitorcompany.store.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping()
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(productDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(value = "/")
    public ResponseEntity<ProductDTO> findById(@RequestParam String id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<ProductDTO>> findBydescriptionAndBetweenValues(@RequestParam String q, @RequestParam Integer minValue, @RequestParam Integer maxValue){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByValues(q, minValue, maxValue));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> alter(@RequestParam String id, @RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.alter(id, productDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String id){
        if(service.delete(id)){
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }
}
