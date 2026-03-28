package com.example.artspaceapp.data

import com.example.artspaceapp.R
import com.example.artspaceapp.model.Picture

object PicturesData {
    val pictures = listOf(
        Picture(R.drawable.mem,
            R.string.pic1AuthorName,
            R.string.pic1Title
        ),
        Picture(R.drawable.apple,
            R.string.pic2AuthorName,
            R.string.pic2Title
        ),
        Picture(R.drawable.night,
            R.string.pic3AuthorName,
            R.string.pic3Title
        ),
        Picture(R.drawable.hunt,
            R.string.pic4AuthorName,
            R.string.pic4Title
        ),
        Picture(R.drawable.winter,
            R.string.pic5AuthorName,
            R.string.pic5Title
        ),
    )
}