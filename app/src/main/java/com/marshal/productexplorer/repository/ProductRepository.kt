package com.marshal.productexplorer.repository

import com.marshal.productexplorer.api.ProductService
import com.marshal.productexplorer.model.ProductResponse

class ProductRepository(private val productService: ProductService) {
    suspend fun getProducts(): ProductResponse = productService.getProducts()
    suspend fun searchProducts(query: String): ProductResponse = productService.searchProducts(query)
}
