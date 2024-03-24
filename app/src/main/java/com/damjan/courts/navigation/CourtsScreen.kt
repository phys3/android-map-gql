package com.damjan.courts.navigation

import androidx.annotation.StringRes
import com.damjan.courts.R

enum class NavRoutes(@StringRes val title: Int) {
    Home(title = R.string.home),
    FindEvent(title = R.string.find_event),
    AddEvent(title = R.string.add_event),
}