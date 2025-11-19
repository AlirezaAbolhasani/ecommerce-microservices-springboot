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
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Alireza Abolhasani
 * ecommerce-microservices-springboot
 * 11/11/2025
 */
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("products/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products/{id}")
    @Operation(summary = "Find a product by id. This number is unique.",
            description = "Id must existed.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = Messages.PRODUCT_SUCCESSFULLY_FOUND
                    , content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ProductDto.class))
            }
            ),
            @ApiResponse(
                    responseCode = "404", description = Messages.PRODUCT_NOT_FOUND
                    , content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BusinessException.class))
            }
            )
    })
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> productDto = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        ProductDto productDto = productService.saveProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @PatchMapping("products/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto dto) {
        ProductDto productDto = productService.updatePartial(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<ProductDto> updateQuantity(@PathVariable Long id, @RequestBody Integer quantity) {
        ProductDto productDto = productService.updateProductQuantity(id, quantity);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Long id) {
        ProductDto productDto = productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }
}
