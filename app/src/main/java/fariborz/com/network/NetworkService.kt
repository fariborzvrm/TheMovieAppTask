package fariborz.com.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Fariborz on 19/03/2020.
 */
//Singleton Class
class NetworkService private constructor() {
    private val mRetrofit: Retrofit
    private var mTmdbApi: TMDBApi? = null

    val tmdbApi: TMDBApi
        get() {
            if (mTmdbApi == null) {
                mTmdbApi = mRetrofit.create<TMDBApi>(TMDBApi::class.java)
            }
            return mTmdbApi!!
        }

    init {
        val client = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(loggingInterceptor)

        mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
    }

    companion object {
        private val BASE_URL = "https://api.themoviedb.org/3/"
        private var mInstance: NetworkService? = null

        val instance: NetworkService
            get() {
                if (mInstance == null) {
                    mInstance = NetworkService()
                }
                return mInstance!!
            }
    }
}