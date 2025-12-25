package com.example.dessertclicker.ui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.R
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ClickerViewModel(): ViewModel() {

    private val desserts: List<Dessert> = Datasource.dessertList;
    private val _uiState = MutableStateFlow(ClickerUIState())
    val uiState: StateFlow<ClickerUIState> = _uiState.asStateFlow()

    init{
        _uiState.update { currentState->
            currentState.copy(
                currentDessertPrice = desserts[_uiState.value.currentDessertIndex].price,
                currentDessertImageId = desserts[_uiState.value.currentDessertIndex].imageId
            )
        }
    }


    fun updateRevenue(){
        val tempRevenue = _uiState.value.currentDessertPrice + _uiState.value.revenue
        val tempDessertsSold = _uiState.value.dessertsSold + 1;

        _uiState.update { currentState->
            currentState.copy(
                revenue = tempRevenue,
                dessertsSold = tempDessertsSold
            )
        }
    }

    fun showNextDessert(){
        val dessertToShow = determineDessertToShow()
        _uiState.update { currentState->
            currentState.copy(
                currentDessertImageId = dessertToShow.imageId,
                currentDessertPrice = dessertToShow.price
            )
        }
    }

    fun determineDessertToShow(): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (_uiState.value.dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }

    /**
     * Share desserts sold information using ACTION_SEND intent
     */
    fun shareSoldDessertsInformation(intentContext: Context) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                intentContext.getString(R.string.share_text, _uiState.value.dessertsSold, _uiState.value.revenue)
            )
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        try {
            ContextCompat.startActivity(intentContext, shareIntent, null)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                intentContext,
                intentContext.getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG
            ).show()
        }
    }



}