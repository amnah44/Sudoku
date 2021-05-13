package com.example.sudoku

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var gameBoard: SudokuBoard? = null
    private var gameBoardSolver: Solver? = null
    private var solveBTN: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameBoard = findViewById(R.id.sudokuBoard)
        gameBoardSolver = gameBoard!!.getSolver()
        solveBTN = findViewById(R.id.solve)
    }

    fun BTNOnePress(view: View?) {
        gameBoardSolver!!.setNumberPos(1)
        gameBoard!!.invalidate()
    }

    fun BTNTwoPress(view: View?) {
        gameBoardSolver!!.setNumberPos(2)
        gameBoard!!.invalidate()
    }

    fun BTNThreePress(view: View?) {
        gameBoardSolver!!.setNumberPos(3)
        gameBoard!!.invalidate()
    }

    fun BTNFourPress(view: View?) {
        gameBoardSolver!!.setNumberPos(4)
        gameBoard!!.invalidate()
    }

    fun BTNFivePress(view: View?) {
        gameBoardSolver!!.setNumberPos(5)
        gameBoard!!.invalidate()
    }

    fun BTNSixPress(view: View?) {
        gameBoardSolver!!.setNumberPos(6)
        gameBoard!!.invalidate()
    }

    fun BTNSevenPress(view: View?) {
        gameBoardSolver!!.setNumberPos(7)
        gameBoard!!.invalidate()
    }

    fun BTNEightPress(view: View?) {
        gameBoardSolver!!.setNumberPos(8)
        gameBoard!!.invalidate()
    }

    fun BTNNinePress(view: View?) {
        gameBoardSolver!!.setNumberPos(9)
        gameBoard!!.invalidate()
    }

    fun solve(view: View?) {
        if (solveBTN!!.text.toString() == getString(R.string.solve)) {
            solveBTN!!.text = getString(R.string.clear)
            gameBoardSolver?.emptyBoxIndexes
            val solveBoardThread: SolveBoardThread = SolveBoardThread()
            Thread(solveBoardThread).start()
            gameBoard!!.invalidate()
        } else {
            solveBTN!!.text = getString(R.string.solve)
            gameBoardSolver!!.resetBoard()
            gameBoard!!.invalidate()
        }
    }

    internal inner class SolveBoardThread : Runnable {
        override fun run() {
            gameBoardSolver!!.solve(gameBoard!!)
        }
    }
}
