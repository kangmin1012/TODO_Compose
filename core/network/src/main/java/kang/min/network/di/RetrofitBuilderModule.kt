package kang.min.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Suppress("JSON_FORMAT_REDUNDANT")
@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilderModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideKotlinSerializationConverter(): Converter.Factory =
        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideRetrofitBuilder(client: OkHttpClient, converter: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(converter)
            .build()
}