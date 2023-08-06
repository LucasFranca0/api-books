package com.products.service;

import com.products.dto.ProductDTO;
import com.products.exception.ProductNotFoundException;
import com.products.exception.InvalidProductDataException;
import com.products.model.Book;
import com.products.model.Manga;
import com.products.model.Product;
import com.products.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Livro/Mangá não encontrado com o ID: " + id));
    }

    public Product createProduct(ProductDTO productDTO) {
        // Realize todas as validações necessárias no DTO
        if (productDTO.getTitle().trim().isEmpty() || productDTO.getAuthor().trim().isEmpty()) {
            throw new InvalidProductDataException("Título e autor do livro/mangá são obrigatórios.");
        }

        if (productDTO.getVolume() == null) {
            Book book = new Book();
            BeanUtils.copyProperties(productDTO, book);
            return productRepository.save(book);
        }

        Manga manga = new Manga();
        BeanUtils.copyProperties(productDTO, manga);
        return productRepository.save(manga);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        // Verificar se o livro/mangá existe antes de atualizar
        Product product = getProductById(id);

        if (productDTO.getTitle().trim().isEmpty() || productDTO.getAuthor().trim().isEmpty()) {
            throw new InvalidProductDataException("Título e autor do livro/mangá são obrigatórios.");
        }

        BeanUtils.copyProperties(productDTO, product);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        // Verificar se o livro/mangá existe antes de excluir
        getProductById(id);
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}