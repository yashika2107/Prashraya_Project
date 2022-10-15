package com.hackygirls.prashraya.periodtracker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class PeriodParcel(val date: LocalDate, val cycleDays: Int) : Parcelable {

}
