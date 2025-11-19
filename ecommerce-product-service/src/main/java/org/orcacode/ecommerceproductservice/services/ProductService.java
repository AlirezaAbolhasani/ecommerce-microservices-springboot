package org.orcacode.ecommerceproductservice.services;

import org.modelmapper.ModelMapper;
import org.orcacode.ecommerceproductservice.dto.ProductDto;
import org.orcacode.ecommerceproductservice.dto.ProductMapper;
import org.orcacode.ecommerceproductservice.entity.Product;
import org.orcacode.ecommerceproductservice.exception.BusinessException;
import org.orcacode.ecommerceproductservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.orcacode.ecommerceproductservice.messages.Messages.*;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/9/2025
 */

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final ProductMapper productMapper;
//    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, ProductMapper productMapper) {
        this.productRepository = Objects.requireNonNull(productRepository, REPOSITORY_MUST_NOT_BE_NULL);
        this.mapper = modelMapper;
        this.productMapper = productMapper;
    }

    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(pr -> mapper.map(pr, ProductDto.class)).collect(Collectors.toList());
    }

    @Transactional
    public ProductDto getProductById(Long id) {
        return mapper.map(productRepository.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND)), ProductDto.class);
    }

    @Transactional
    public ProductDto deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND));
        productRepository.deleteById(id);
        return productMapper.toDto(product);
    }

    @Transactional
    public ProductDto saveProduct(ProductDto dto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(dto)));
    }

    @Transactional
    public ProductDto updatePartial(Long id, ProductDto productPatchDto) {
        if (id == null) {
            throw new BusinessException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND);
        } else {
            Product updatedProduct = productMapper.toEntity(getProductById(id));
            productMapper.updateFromDto(productPatchDto, updatedProduct); // MapStruct updates only non-null fields
            return mapper.map(productRepository.save(updatedProduct), ProductDto.class);
        }
    }

    @Transactional
    public ProductDto updateProductQuantity(Long id, Integer quantity) {
        if (id == null) {
            throw new BusinessException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND);
        } else {
            Product product = productMapper.toEntity(getProductById(id));
            product.setQuantity(quantity);
            return productMapper.toDto(productRepository.save(product));
        }
    }

}
