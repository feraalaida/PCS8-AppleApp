package com.feraalaida.appleapp.data.model

import android.hardware.usb.UsbEndpoint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Manga (
    val title : String = "",
    val thumb : String = "",
    val type : String = "",
    val update_on : String = "",
    val endpoint: String = "",
    val chapter: String = ""
) : Parcelable