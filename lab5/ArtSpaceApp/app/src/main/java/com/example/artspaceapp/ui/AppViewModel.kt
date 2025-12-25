package com.example.artspaceapp.ui

import android.content.res.Configuration
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.lifecycle.ViewModel
import com.example.artspaceapp.data.PicturesData
import com.example.artspaceapp.model.Picture
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel() : ViewModel()  {
    private val picList: List<Picture> = PicturesData.pictures
    private val _uiState = MutableStateFlow(AppUIState())
    val uiState: StateFlow<AppUIState> = _uiState.asStateFlow()



    init {
        _uiState.update { currentState ->
            currentState.copy(
                pictureId = picList[_uiState.value.index].imageResId,
                artTitleId = picList[_uiState.value.index].artTitleId,
                authorNameId = picList[_uiState.value.index].authorNameId
            )
        }
    }

    fun updatePic(){_uiState.update { currentState ->
            currentState.copy(
                pictureId = picList[_uiState.value.index].imageResId,
                artTitleId = picList[_uiState.value.index].artTitleId,
                authorNameId = picList[_uiState.value.index].authorNameId
            )
        }
    }

    fun indexUp(){
        var tempIndex = _uiState.value.index + 1;
        when (tempIndex) {
            picList.size -> tempIndex = 0
            -1 -> tempIndex = picList.size - 1
        }
        _uiState.update { currentState ->
            currentState.copy(
                index = tempIndex
            )
        }

    }

    fun indexDown(){
        var tempIndex = _uiState.value.index - 1;
        when (tempIndex) {
            picList.size -> tempIndex = 0
            -1 -> tempIndex = picList.size - 1
        }
        _uiState.update { currentState ->
            currentState.copy(
                index = tempIndex
            )
        }
    }
}