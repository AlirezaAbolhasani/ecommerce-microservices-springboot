package org.orcacode.ecommerceproductservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.orcacode.ecommerceproductservice.dto.ProductDto;
import org.orcacode.ecommerceproductservice.dto.ProductMapper;
import org.orcacode.ecommerceproductservice.entity.Product;
import org.orcacode.ecommerceproductservice.exception.BusinessException;
import org.orcacode.ecommerceproductservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.orcacode.ecommerceproductservice.messages.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("e-commerce/product/")
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductService productService;

    public ProductController(ProductMapper productMapper, ProductService productService) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping("e-commerce/product/{id}")
    @Operation(summary = "Find a product by id. This number is unique.",
            description = "Id must existed.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = Messages.Product_SUCCESSFULLY_FOUND
                    , content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ProductDto.class))
            }
            ),
            @ApiResponse(
                    responseCode = "404", description = Messages.Product_NOT_FOUND
                    , content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BusinessException.class))
            }
            )
    })
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id) {
        ProductDto productDto = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("e-commerce/product/{id}")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> productDto = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        Product productEntity = productMapper.toEntity(dto);
        ProductDto productDto = productService.saveProduct(productEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @PatchMapping("e-commerce/product/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable UUID id, @RequestBody ProductDto dto) {
        ProductDto productDto = productService.updatePartial(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PutMapping("e-commerce/product/{id}")
    public ResponseEntity<ProductDto> updateQuantity(@PathVariable UUID id, @RequestBody Integer quantity) {
        ProductDto productDto = productService.updateProductQuantity(id, quantity);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @DeleteMapping("e-commerce/product/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable UUID id) {
        ProductDto productDto = productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }
}
