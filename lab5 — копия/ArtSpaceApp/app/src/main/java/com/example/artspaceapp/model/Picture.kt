package com.example.artspaceapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Picture(
    @DrawableRes val imageResId: Int,
    @StringRes val authorNameId: Int,
    @StringRes val artTitleId: Int
)
