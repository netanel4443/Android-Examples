package com.androidexamples

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



class CountryCoronaDetails {
    @SerializedName("Country")
    @Expose
     val country: String? = null

    @SerializedName("NewConfirmed")
    @Expose
     val newConfirmed: Int? = null

    @SerializedName("TotalConfirmed")
    @Expose
     val totalConfirmed: Int? = null

    @SerializedName("NewDeaths")
    @Expose
     val newDeaths: Int? = null


    @SerializedName("NewRecovered")
    @Expose
     val newRecovered: Int? = null

    @SerializedName("TotalRecovered")
    @Expose
     val totalRecovered: Int? = null

}

 class Example {

    @SerializedName("Countries")
    @Expose
     val countries :  ArrayList<CountryCoronaDetails>?=null;
}