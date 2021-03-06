package com.oratakashi.covid19.data.network

import com.oratakashi.covid19.data.model.confirm.DataConfirm
import com.oratakashi.covid19.data.model.death.DataDeath
import com.oratakashi.covid19.data.model.recovered.DataRecovered
import com.oratakashi.covid19.data.model.statistik.ResponseStatistik
import io.reactivex.Single
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("api")
    fun getData() : Single<ResponseStatistik>
    @GET("api/confirmed")
    fun getConfirmed() : Single<List<DataConfirm>>
    @GET("api/recovered")
    fun getRecovered() : Single<List<DataRecovered>>
    @GET("api/deaths")
    fun getDeaths() : Single<List<DataDeath>>
}