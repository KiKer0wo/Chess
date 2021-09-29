package com.kiker.chess


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import java.util.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), ChessDelegate {
    var chess = Chess()
    //private lateinit var printWriter: PrintWriter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "$chess")
        // połaczenie z interfejsem
        val chessView = findViewById<ChessView>(R.id.chess_view)
        chessView.chessDelegate = this


        //implementacja przycisku reset
        findViewById<Button>(R.id.ResetButton).setOnClickListener {
            chess.start()
            val displayWord = findViewById<TextView>(R.id.playerMove)
            val information = findViewById<TextView>(R.id.Information)
            displayWord.text = "RUCH BIAŁEGO"
            information.text = " "
            chessView.invalidate()

        }

    }

    override fun isPieceAt(col: Int, row: Int): ChessPiece? {
        return chess.isPieceAt(col, row)
    }

    override fun movePiece(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int) {

        if (fromCol == toCol && fromRow == toRow) {
            return
        }
        chess.movePiece(fromCol, fromRow, toCol, toRow)
        val chessView = findViewById<ChessView>(R.id.chess_view)
        val displayWord = findViewById<TextView>(R.id.playerMove)
        val information = findViewById<TextView>(R.id.Information)
        when {
            chess.whiteOrBlack() == 1 -> {
                displayWord.text = "RUCH BIAŁEGO"
            }
            chess.whiteOrBlack() == 2 -> {
                displayWord.text = "RUCH CZARNEGO"
            }
        }
        if (chess.isKingChecked()) {
            information.text = "Info: Check"
        } else if (!chess.isKingChecked()) {
            information.text = "Info: "
        }

        Log.d(TAG, "$chess")
        when {
            chess.findWinner() == 1 -> {
                information.text = "CHECK MATE" + "\n" + "CZARNY WYGRAŁ"
                displayWord.text = " "
            }
            chess.findWinner() == 2 -> {
                information.text = "CHECK MATE" + "\n" + "BIAŁY WYGRAŁ "
                displayWord.text = " "
            }
            else -> chessView.invalidate()
        }


    }
}

