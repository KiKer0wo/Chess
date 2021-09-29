package com.kiker.chess

interface ChessDelegate {

    fun isPieceAt(col: Int, row: Int): ChessPiece?
    fun movePiece(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int)

}