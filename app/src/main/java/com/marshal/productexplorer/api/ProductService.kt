package com.marshal.productexplorer.api

import com.marshal.productexplorer.model.ProductResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/search")
    suspend fun searchProducts(@Query("q") query: String): ProductResponse

    companion object {
        private const val BASE_URL = "https://dummyjson.com/"

        fun create(): ProductService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductService::class.java)
        }
    }
}
