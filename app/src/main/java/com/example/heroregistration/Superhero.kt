package com.example.heroregistration

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Superhero(val nombre:String,
val alterego:String,
val bio:String,
val rating:Float) : Parcelable