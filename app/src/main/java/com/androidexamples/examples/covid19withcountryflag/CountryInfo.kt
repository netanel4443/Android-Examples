package com.androidexamples.examples.covid19withcountryflag

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class CountryDetails{

    @SerializedName("country")
    @Expose
     val country: String? = null

    @SerializedName("countryInfo")
    @Expose
     val countryInfo: CountryInfo? = null

    @SerializedName("cases")
    @Expose
     val cases: Int? = null

    @SerializedName("todayCases")
    @Expose
     val todayCases: Int? = null

    @SerializedName("todayDeaths")
    @Expose
     val todayDeaths: Int? = null

    @SerializedName("recovered")
    @Expose
     val recovered: Int? = null

    @SerializedName("todayRecovered")
    @Expose
     val todayRecovered: Int? = null

    @SerializedName("active")
    @Expose
     val active: Int? = null

    @SerializedName("critical")
    @Expose
     val critical: Int? = null

    @SerializedName("tests")
    @Expose
     val tests: Int? = null
}


class CountryInfo {

    @SerializedName("flag")
    @Expose
     val flag: String? = null
}