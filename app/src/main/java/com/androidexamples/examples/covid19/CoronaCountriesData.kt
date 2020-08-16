package com.androidexamples.examples.covid19

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class CoronaCountriesData {
    @SerializedName("Country")
    @Expose
     val country: String? = null

    @SerializedName("CountryCode")
    @Expose
     val countryCode: String? = null

    @SerializedName("Slug")
    @Expose
     val slug: String? = null

    @SerializedName("NewConfirmed")
    @Expose
     val newConfirmed: Int? = null

    @SerializedName("TotalConfirmed")
    @Expose
     val totalConfirmed: Int? = null

    @SerializedName("NewRecovered")
    @Expose
     val newRecovered: Int? = null

    @SerializedName("TotalRecovered")
    @Expose
     val totalRecovered: Int? = null

}

class Countries{
    @SerializedName("Countries")
    @Expose
     val countries: ArrayList<CoronaCountriesData>? = null
}