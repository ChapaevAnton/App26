package com.w4eret1ckrtb1tch.app26.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Employee(val surName:String,val name:String,val fullName:String): Parcelable {
}