package com.hackygirls.prashraya.periodtracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class PeriodDateEntity(@PrimaryKey val date: LocalDate, @ColumnInfo(name = "cycleDays") val cycleDays: Int)