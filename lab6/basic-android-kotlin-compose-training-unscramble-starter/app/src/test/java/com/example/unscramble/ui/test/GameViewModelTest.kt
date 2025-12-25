package com.example.unscramble.ui.test

import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import com.example.unscramble.ui.GameViewModel
import junit.framework.Assert.assertTrue
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset()  {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        // Утверждаем, что обновленное разгаданное слово является правильным.
        assertFalse(currentGameUiState.isGuessedWordWrong)
        // Утверждаем, что очки обновились правильно.
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)

    }

    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet(){
        var currentGameUiState = viewModel.uiState.value
        val playerWord = "incorrect"

        viewModel.updateUserGuess(playerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        assertTrue(currentGameUiState.isGuessedWordWrong)
    }

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded(){

    }

    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly(){

    }

    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased(){

    }


    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}