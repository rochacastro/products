package com.vitorcompany.store.product;

import com.vitorcompany.store.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO saveProduct(ProductDTO productDTO){
        Product product = new Product(productDTO);
        return new ProductDTO(repository.save(product));
    }

    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();
        if(products.isEmpty()){
            new ArrayList<>();
        }

        return products.stream().map(transaction -> new ProductDTO(transaction)).collect(Collectors.toList());
    }

    public ProductDTO findById(String id) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ObjectNotFoundException(String.format("No product found with id %s", id));
        }
        return new ProductDTO(product.get());
    }

    public ProductDTO alter(String id, ProductDTO productDTO) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ObjectNotFoundException(String.format("No product found with id %s", id));
        }
        Product productForSave = new Product(id, productDTO);
        return new ProductDTO(repository.save(productForSave));        
    }


    public boolean delete(String id) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            return false;
        }
        repository.delete(product.get());
        return true;
    }

    public List<ProductDTO> findByValues(String q, Integer minValue, Integer maxValue) {
        List<Product> products = repository.findBydescriptionAndBetweenValues(q.toLowerCase(Locale.ROOT), BigDecimal.valueOf(minValue), BigDecimal.valueOf(maxValue));
        if(products.isEmpty()){
            return new ArrayList<>();
        }
        return products.stream().map(transaction -> new ProductDTO(transaction)).collect(Collectors.toList());
    }
}
