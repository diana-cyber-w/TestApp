package com.example.testapp.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ViewPagerPosition(
    val position: Int
) : Parcelable
