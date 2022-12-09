package com.izzed.mybiaseslist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bias (
    var name : String? = null,
    var real_name : String? = null,
    var birthdate : String? = null,
    var height : String? = null,
    var blood_type : String? = null,
    var zodiac : String? = null,
    var detail : String? = null,
    var photo : Int? = null
) : Parcelable