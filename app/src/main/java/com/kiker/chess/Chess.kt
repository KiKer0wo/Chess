package com.kiker.chess

import android.widget.TextView
import java.lang.Math.abs

class Chess {

    var chessBoard = mutableSetOf<ChessPiece>()
    var playerInTurn: ChessPlayer = ChessPlayer.WHITE
    var isCheck = false
    var findWinner = 0
    //konstruktor inicjujący figury na szachownicy

    init {
        start()
    }

    //funkcja ustawiająca początkowe pozycje na szachownicy
    fun start() {
        chessBoard.removeAll(chessBoard)

        chessBoard.add(
            ChessPiece(
                0,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.ROOK,
                R.drawable.rook_white
            )
        )
        chessBoard.add(
            ChessPiece(
                1,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.KNIGHT,
                R.drawable.knight_white
            )
        )
        chessBoard.add(
            ChessPiece(
                2,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.BISHOP,
                R.drawable.bishop_white
            )
        )
        chessBoard.add(
            ChessPiece(
                3,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.QUEEN,
                R.drawable.queen_white
            )
        )
        chessBoard.add(
            ChessPiece(
                4,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.KING,
                R.drawable.king_white
            )
        )
        chessBoard.add(
            ChessPiece(
                5,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.BISHOP,
                R.drawable.bishop_white
            )
        )
        chessBoard.add(
            ChessPiece(
                6,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.KNIGHT,
                R.drawable.knight_white
            )
        )
        chessBoard.add(
            ChessPiece(
                7,
                0,
                ChessPlayer.WHITE,
                ChessPieceName.ROOK,
                R.drawable.rook_white
            )
        )
        chessBoard.add(
            ChessPiece(
                0,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )
        chessBoard.add(
            ChessPiece(
                1,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )
        chessBoard.add(
            ChessPiece(
                2,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )
        chessBoard.add(
            ChessPiece(
                3,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )
        chessBoard.add(
            ChessPiece(
                4,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )
        chessBoard.add(
            ChessPiece(
                5,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )
        chessBoard.add(
            ChessPiece(
                6,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )
        chessBoard.add(
            ChessPiece(
                7,
                1,
                ChessPlayer.WHITE,
                ChessPieceName.PAWN,
                R.drawable.pawn_white
            )
        )

        chessBoard.add(
            ChessPiece(
                0,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.ROOK,
                R.drawable.rook_black
            )
        )
        chessBoard.add(
            ChessPiece(
                1,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.KNIGHT,
                R.drawable.knight_black
            )
        )
        chessBoard.add(
            ChessPiece(
                2,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.BISHOP,
                R.drawable.bishop_black
            )
        )
        chessBoard.add(
            ChessPiece(
                3,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.QUEEN,
                R.drawable.queen_black
            )
        )
        chessBoard.add(
            ChessPiece(
                4,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.KING,
                R.drawable.king_black
            )
        )
        chessBoard.add(
            ChessPiece(
                5,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.BISHOP,
                R.drawable.bishop_black
            )
        )
        chessBoard.add(
            ChessPiece(
                6,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.KNIGHT,
                R.drawable.knight_black
            )
        )
        chessBoard.add(
            ChessPiece(
                7,
                7,
                ChessPlayer.BLACK,
                ChessPieceName.ROOK,
                R.drawable.rook_black
            )
        )
        chessBoard.add(
            ChessPiece(
                0,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )
        chessBoard.add(
            ChessPiece(
                1,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )
        chessBoard.add(
            ChessPiece(
                2,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )
        chessBoard.add(
            ChessPiece(
                3,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )
        chessBoard.add(
            ChessPiece(
                4,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )
        chessBoard.add(
            ChessPiece(
                5,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )
        chessBoard.add(
            ChessPiece(
                6,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )
        chessBoard.add(
            ChessPiece(
                7,
                6,
                ChessPlayer.BLACK,
                ChessPieceName.PAWN,
                R.drawable.pawn_black
            )
        )

        playerInTurn = ChessPlayer.WHITE
    }

    fun promote() {
        for (i in 0..7) {
            val pawnPromoted = isPieceAt(i, 0) ?: return
            if (pawnPromoted.pieceName == ChessPieceName.PAWN) {
                chessBoard.remove(pawnPromoted)
                if (pawnPromoted.player == ChessPlayer.BLACK) {
                    chessBoard.add(
                        ChessPiece(
                            i,
                            0,
                            pawnPromoted.player,
                            ChessPieceName.QUEEN,
                            R.drawable.queen_black
                        )
                    )
                } else chessBoard.add(
                    ChessPiece(
                        i,
                        0,
                        pawnPromoted.player,
                        ChessPieceName.QUEEN,
                        R.drawable.queen_white
                    )
                )
            }
        }
        for (i in 0..7) {
            val pawnPromoted = isPieceAt(i, 7) ?: return
            if (pawnPromoted.pieceName == ChessPieceName.PAWN) {
                chessBoard.remove(pawnPromoted)
                if (pawnPromoted.player == ChessPlayer.BLACK) {
                    chessBoard.add(
                        ChessPiece(
                            i,
                            7,
                            pawnPromoted.player,
                            ChessPieceName.QUEEN,
                            R.drawable.queen_black
                        )
                    )
                } else chessBoard.add(
                    ChessPiece(
                        i,
                        7,
                        pawnPromoted.player,
                        ChessPieceName.QUEEN,
                        R.drawable.queen_white
                    )
                )
            }
        }
    }

    fun whiteOrBlack(): Int {
        if (playerInTurn == ChessPlayer.WHITE) {
            return 1
        } else if (playerInTurn == ChessPlayer.BLACK) {
            return 2
        }
        return 3
    }

    fun findWinner(): Int {
        return findWinner
    }

    private fun isKingChecked1() {

        val king = findKing(playerInTurn, ChessPieceName.KING) ?: return
        val pawnBlack1 = isPieceAt(king.col + 1, king.row + 1)
        val pawnBlack2 = isPieceAt(king.col - 1, king.row + 1)
        val pawnWhite1 = isPieceAt(king.col + 1, king.row - 1)
        val pawnWhite2 = isPieceAt(king.col - 1, king.row - 1)

        // szachowanie pionem

        if (!isCheck) {
            if (pawnBlack1?.pieceName == ChessPieceName.PAWN && pawnBlack1.player != playerInTurn) {
                isCheck = true
            } else if (pawnBlack2?.pieceName == ChessPieceName.PAWN && pawnBlack2.player != playerInTurn) {
                isCheck = true
            } else if (pawnWhite1?.pieceName == ChessPieceName.PAWN && pawnWhite1.player != playerInTurn) {
                isCheck = true
            } else if (pawnWhite2?.pieceName == ChessPieceName.PAWN && pawnWhite2.player != playerInTurn) {
                isCheck = true
            }
        }

        //szachowanie wieza i hetmanem w poziomie
        if (!isCheck) {
            for (i in (king.col + 1)..7) {
                val horizontalCheckRight = isPieceAt(i, king.row)
                if (horizontalCheckRight == null) {

                } else if (horizontalCheckRight.player == playerInTurn) {
                    break
                } else if ((horizontalCheckRight.player != playerInTurn) && (horizontalCheckRight.pieceName == ChessPieceName.QUEEN || horizontalCheckRight.pieceName == ChessPieceName.ROOK)) {
                    isCheck = true
                    break
                }

            }
        }
        if (!isCheck) {
            for (i in king.col - 1 downTo 0) {
                val horizontalCheckLeft = isPieceAt(i, king.row)
                if (horizontalCheckLeft == null) {

                } else if ((horizontalCheckLeft.player != playerInTurn) && (horizontalCheckLeft.pieceName == ChessPieceName.QUEEN || horizontalCheckLeft.pieceName == ChessPieceName.ROOK)) {
                    isCheck = true
                    break
                } else if (horizontalCheckLeft.player == playerInTurn) {

                    break
                }


            }
        }

        //szachowanie wieza i hetmanem w pionie

        if (!isCheck) {
            for (i in (king.row + 1)..7) {
                val verticalCheckRight = isPieceAt(king.col, i)
                if (verticalCheckRight == null) {

                } else if (verticalCheckRight.player == playerInTurn) {
                    break
                } else if ((verticalCheckRight.player != playerInTurn) && (verticalCheckRight.pieceName == ChessPieceName.QUEEN || verticalCheckRight.pieceName == ChessPieceName.ROOK)) {
                    isCheck = true
                    break
                }

            }
        }
        if (!isCheck) {
            for (i in king.row - 1 downTo 0) {
                val verticalCheckLeft = isPieceAt(king.col, i)
                if (verticalCheckLeft == null) {

                } else if ((verticalCheckLeft.player != playerInTurn) && (verticalCheckLeft.pieceName == ChessPieceName.QUEEN || verticalCheckLeft.pieceName == ChessPieceName.ROOK)) {
                    isCheck = true
                    break
                } else if (verticalCheckLeft.player == playerInTurn) {

                    break
                }


            }
        }


        //szachowanie goncem i hetmanem na skos

        if (!isCheck) {
            for (i in (king.col + 1)..7) {

                val diagonalCheck = isPieceAt(king.col + (i - king.col), king.row + (i - king.col))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    isCheck = true
                    break
                }
            }
        }

        if (!isCheck) {
            for (i in king.col - 1 downTo 0) {

                val diagonalCheck = isPieceAt(king.col + (i - king.col), king.row + (i - king.col))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    isCheck = true

                    break


                }

            }

        }
        if (!isCheck) {
            for (i in (king.col + 1)..7) {

                val diagonalCheck = isPieceAt(king.col + (i - king.col), king.row - (i - king.col))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    isCheck = true
                    break
                }
            }
        }
        if (!isCheck) {
            for (i in king.col - 1 downTo 0) {

                val diagonalCheck = isPieceAt(king.col + (i - king.col), king.row - (i - king.col))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    isCheck = true

                    break


                }

            }

        }
        // szachowanie koniem

        if (!isCheck) {
            val k1 = isPieceAt(king.col + 2, king.row + 1)
            val k2 = isPieceAt(king.col - 2, king.row + 1)
            val k3 = isPieceAt(king.col + 2, king.row - 1)
            val k4 = isPieceAt(king.col - 2, king.row - 1)

            val k5 = isPieceAt(king.col + 1, king.row + 2)
            val k6 = isPieceAt(king.col - 1, king.row + 2)
            val k7 = isPieceAt(king.col + 1, king.row - 2)
            val k8 = isPieceAt(king.col - 1, king.row - 2)

            if (k1?.pieceName == ChessPieceName.KNIGHT && k1.player != playerInTurn) {
                isCheck = true
            } else if (k2?.pieceName == ChessPieceName.KNIGHT && k2.player != playerInTurn) {
                isCheck = true
            } else if (k3?.pieceName == ChessPieceName.KNIGHT && k3.player != playerInTurn) {
                isCheck = true
            } else if (k4?.pieceName == ChessPieceName.KNIGHT && k4.player != playerInTurn) {
                isCheck = true
            }
            if (k5?.pieceName == ChessPieceName.KNIGHT && k5.player != playerInTurn) {
                isCheck = true
            } else if (k6?.pieceName == ChessPieceName.KNIGHT && k6.player != playerInTurn) {
                isCheck = true
            } else if (k7?.pieceName == ChessPieceName.KNIGHT && k7.player != playerInTurn) {
                isCheck = true
            } else if (k8?.pieceName == ChessPieceName.KNIGHT && k8.player != playerInTurn) {
                isCheck = true
            }

        }


    }

    fun isKingChecked(): Boolean {
        return isCheck
    }

    private fun findKing(color: ChessPlayer, king: ChessPieceName): ChessPiece? {
        for (piece in chessBoard) {
            if (color == piece.player && king == piece.pieceName) {
                return piece
            }
        }
        return null
    }

    //funkcja sprawdzająca czy na szachownicy jest figura

    fun isPieceAt(col: Int, row: Int): ChessPiece? {
        for (piece in chessBoard) {
            if (col == piece.col && row == piece.row) {
                return piece
            }
        }
        return null
    }

    fun movePiece(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int) {

        if (canMove(fromCol, fromRow, toCol, toRow)) {

            if (fromCol == toCol && fromRow == toRow) return
            val movingPiece = isPieceAt(fromCol, fromRow) ?: return

            if (playerInTurn != movingPiece.player) {
                return
            }
            isPieceAt(toCol, toRow)?.let {
                //Sprawdzanie czy jest mozliwosc ruchu
                if (it.player == movingPiece.player) {
                    return
                }

                chessBoard.remove(it)
            }

            chessBoard.remove(movingPiece)

            chessBoard.add(movingPiece.copy(col = toCol, row = toRow))

            playerInTurn =
                if (playerInTurn === ChessPlayer.WHITE) ChessPlayer.BLACK else ChessPlayer.WHITE
            promote()
            isKingChecked1()
        }

    }

    private fun knightRules(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int): Boolean {
        isCheck = false
        if (kotlin.math.abs(fromCol - toCol) == 2 && kotlin.math.abs(fromRow - toRow) == 1 || kotlin.math.abs(
                fromCol - toCol
            ) == 1 && kotlin.math.abs(fromRow - toRow) == 2
        ) {
            return true
        }
        return false
    }

    private fun rookRules(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int): Boolean {

        if ((fromCol == toCol && isVerticalMovePossible(
                fromCol,
                fromRow,
                toCol,
                toRow
            )) || fromRow == toRow && isHorizontalMovePossible(fromCol, fromRow, toCol, toRow)
        ) {

            return true
        }

        return false
    }


    private fun bishopRules(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int): Boolean {
        isCheck = false
        if (abs(fromCol - toCol) == abs(fromRow - toRow)) {
            return isDiagonalMovePossible(fromCol, fromRow, toCol, toRow)
        }
        return false
    }

    private fun queenRules(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int): Boolean {
        isCheck = false
        return rookRules(fromCol, fromRow, toCol, toRow) || bishopRules(
            fromCol,
            fromRow,
            toCol,
            toRow
        )
    }

    private fun kingRules(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int): Boolean {
        isCheck = false
        var canMove = true
        if (queenRules(fromCol, fromRow, toCol, toRow)) {
            val deltaCol = abs(fromCol - toCol)
            val deltaRow = abs(fromRow - toRow)

            val pawnBlack1 = isPieceAt(toCol + 1, toRow + 1)
            val pawnBlack2 = isPieceAt(toCol - 1, toRow + 1)
            val pawnWhite1 = isPieceAt(toCol + 1, toRow - 1)
            val pawnWhite2 = isPieceAt(toCol - 1, toRow - 1)
            if (pawnBlack1?.pieceName == ChessPieceName.PAWN && pawnBlack1.player != playerInTurn) {
                canMove = false
            } else if (pawnBlack2?.pieceName == ChessPieceName.PAWN && pawnBlack2.player != playerInTurn) {
                canMove = false
            } else if (pawnWhite1?.pieceName == ChessPieceName.PAWN && pawnWhite1.player != playerInTurn) {
                canMove = false
            } else if (pawnWhite2?.pieceName == ChessPieceName.PAWN && pawnWhite2.player != playerInTurn) {
                canMove = false
            }

            val k1 = isPieceAt(toCol + 2, toRow + 1)
            val k2 = isPieceAt(toCol - 2, toRow + 1)
            val k3 = isPieceAt(toCol + 2, toRow - 1)
            val k4 = isPieceAt(toCol - 2, toRow - 1)

            val k5 = isPieceAt(toCol + 1, toRow + 2)
            val k6 = isPieceAt(toCol - 1, toRow + 2)
            val k7 = isPieceAt(toCol + 1, toRow - 2)
            val k8 = isPieceAt(toCol - 1, toRow - 2)

            if (k1?.pieceName == ChessPieceName.KNIGHT && k1.player != playerInTurn) {
                canMove = false
            } else if (k2?.pieceName == ChessPieceName.KNIGHT && k2.player != playerInTurn) {
                canMove = false
            } else if (k3?.pieceName == ChessPieceName.KNIGHT && k3.player != playerInTurn) {
                canMove = false
            } else if (k4?.pieceName == ChessPieceName.KNIGHT && k4.player != playerInTurn) {
                canMove = false
            }
            if (k5?.pieceName == ChessPieceName.KNIGHT && k5.player != playerInTurn) {
                canMove = false
            } else if (k6?.pieceName == ChessPieceName.KNIGHT && k6.player != playerInTurn) {
                canMove = false
            } else if (k7?.pieceName == ChessPieceName.KNIGHT && k7.player != playerInTurn) {
                canMove = false
            } else if (k8?.pieceName == ChessPieceName.KNIGHT && k8.player != playerInTurn) {
                canMove = false
            }

            for (i in (toCol + 1)..7) {
                val horizontalCheckRight = isPieceAt(i, toRow)
                if (horizontalCheckRight == null) {

                } else if (horizontalCheckRight.player == playerInTurn) {
                    break
                } else if ((horizontalCheckRight.player != playerInTurn) && (horizontalCheckRight.pieceName == ChessPieceName.QUEEN || horizontalCheckRight.pieceName == ChessPieceName.ROOK)) {
                    canMove = false
                    break
                }

            }

            for (i in toCol - 1 downTo 0) {
                val horizontalCheckLeft = isPieceAt(i, toRow)
                if (horizontalCheckLeft == null) {

                } else if ((horizontalCheckLeft.player != playerInTurn) && (horizontalCheckLeft.pieceName == ChessPieceName.QUEEN || horizontalCheckLeft.pieceName == ChessPieceName.ROOK)) {
                    canMove = false
                    break
                } else if (horizontalCheckLeft.player == playerInTurn) {
                    break
                }


            }

            for (i in (toRow + 1)..7) {
                val verticalCheckRight = isPieceAt(toCol, i)
                if (verticalCheckRight == null) {

                } else if (verticalCheckRight.player == playerInTurn) {
                    break
                } else if ((verticalCheckRight.player != playerInTurn) && (verticalCheckRight.pieceName == ChessPieceName.QUEEN || verticalCheckRight.pieceName == ChessPieceName.ROOK)) {
                    canMove = false
                    break
                }

            }


            for (i in toRow - 1 downTo 0) {
                val verticalCheckLeft = isPieceAt(toCol, i)
                if (verticalCheckLeft == null) {
                } else if ((verticalCheckLeft.player != playerInTurn) && (verticalCheckLeft.pieceName == ChessPieceName.QUEEN || verticalCheckLeft.pieceName == ChessPieceName.ROOK)) {
                    canMove = false
                    break
                } else if (verticalCheckLeft.player == playerInTurn) {
                    break
                }
            }


            for (i in (toCol + 1)..7) {

                val diagonalCheck = isPieceAt(toCol + (i - toCol), toRow + (i - toCol))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    canMove = false
                    break
                }
            }



            for (i in toCol - 1 downTo 0) {

                val diagonalCheck = isPieceAt(toCol + (i - toCol), toRow + (i - toCol))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    canMove = false
                    break
                }

            }

            for (i in (toCol + 1)..7) {

                val diagonalCheck = isPieceAt(toCol + (i - toCol), toRow - (i - toCol))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    canMove = false
                    break
                }
            }


            for (i in toCol - 1 downTo 0) {

                val diagonalCheck = isPieceAt(toCol + (i - toCol), toRow - (i - toCol))

                if (diagonalCheck == null) {

                } else if (diagonalCheck.player == playerInTurn) {
                    break

                } else if ((diagonalCheck.player != playerInTurn) && (diagonalCheck.pieceName == ChessPieceName.QUEEN || diagonalCheck.pieceName == ChessPieceName.BISHOP)) {
                    canMove = false
                    break
                }

            }




            if (canMove) {
                return deltaCol == 1 && deltaRow == 1 || deltaCol + deltaRow == 1
            }
        }
        return false
    }

    private fun pawnRules(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int): Boolean {
        isCheck = false

        val movingPiece = isPieceAt(fromCol, fromRow) ?: return false

        if (playerInTurn == ChessPlayer.WHITE) {
            if (fromCol == toCol) {
                if (fromRow == 1) {

                    return toRow == 2 || toRow == 3
                } else if (fromRow - toRow == -1) {
                    isPieceAt(toCol, toRow)?.let {
                        if (it.player != movingPiece.player) {
                            return false
                        }
                    }
                    return true
                }
            } else if (fromRow - toRow == -1 && (fromCol - toCol == -1 || fromCol - toCol == 1)) {
                isPieceAt(toCol, toRow)?.let {
                    if (it.player != movingPiece.player) {
                        return true
                    }
                }
            }
        } else if (playerInTurn == ChessPlayer.BLACK) {
            if (fromCol == toCol) {
                if (fromRow == 6) {
                    return toRow == 5 || toRow == 4
                } else if (fromRow - toRow == 1) {
                    isPieceAt(toCol, toRow)?.let {
                        if (it.player != movingPiece.player) {
                            return false
                        }
                    }
                    return true
                }
            } else if (fromRow - toRow == 1 && (fromCol - toCol == -1 || fromCol - toCol == 1)) {
                isPieceAt(toCol, toRow)?.let {
                    if (it.player != movingPiece.player) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun isHorizontalMovePossible(
        fromCol: Int,
        fromRow: Int,
        toCol: Int,
        toRow: Int
    ): Boolean {
        if (fromRow != toRow) return false
        val gap = kotlin.math.abs(fromCol - toCol) - 1
        if (gap == 0) return true
        for (i in 1..gap) {
            val nextCol = if (toCol > fromCol) fromCol + i else fromCol - i
            if (isPieceAt(nextCol, fromRow) != null) {
                return false
            }
        }
        return true
    }

    private fun isVerticalMovePossible(
        fromCol: Int,
        fromRow: Int,
        toCol: Int,
        toRow: Int
    ): Boolean {
        if (fromCol != toCol) return false
        val gap = kotlin.math.abs(fromRow - toRow) - 1
        if (gap == 0) return true
        for (i in 1..gap) {
            val nextRow = if (toRow > fromRow) fromRow + i else fromRow - i
            if (isPieceAt(fromCol, nextRow) != null) {
                return false
            }
        }
        return true
    }

    private fun isDiagonalMovePossible(
        fromCol: Int,
        fromRow: Int,
        toCol: Int,
        toRow: Int
    ): Boolean {
        if (abs(fromCol - toCol) != abs(fromRow - toRow)) return false
        val gap = abs(fromCol - toCol) - 1
        for (i in 1..gap) {
            val nextCol = if (toCol > fromCol) fromCol + i else fromCol - i
            val nextRow = if (toRow > fromRow) fromRow + i else fromRow - i
            if (isPieceAt(nextCol, nextRow) != null) {
                return false
            }
        }
        return true
    }

    private fun canMove(fromCol: Int, fromRow: Int, toCol: Int, toRow: Int): Boolean {

        if (findWinner == 2 || findWinner == 1) {
            return false
        }

        if (fromCol == toCol && fromRow == toRow) {
            return false
        }
        val movingPiece = isPieceAt(fromCol, fromRow) ?: return false

        return when (movingPiece.pieceName) {
            ChessPieceName.KNIGHT -> knightRules(fromCol, fromRow, toCol, toRow)
            ChessPieceName.ROOK -> rookRules(fromCol, fromRow, toCol, toRow)
            ChessPieceName.BISHOP -> bishopRules(fromCol, fromRow, toCol, toRow)
            ChessPieceName.QUEEN -> queenRules(fromCol, fromRow, toCol, toRow)
            ChessPieceName.KING -> kingRules(fromCol, fromRow, toCol, toRow)
            ChessPieceName.PAWN -> pawnRules(fromCol, fromRow, toCol, toRow)

        }


    }


    override fun toString(): String {
        var desc = " \n"
        val king = findKing(playerInTurn, ChessPieceName.KING)
        for (row in 7 downTo 0) {
            desc += "$row"
            for (col in 0..7) {
                val piece = isPieceAt(col, row)

                if (piece == null) {
                    desc += " ."
                } else {
                    desc += " "
                    val white = piece.player == ChessPlayer.WHITE
                    desc += when (piece.pieceName) {

                        ChessPieceName.KING -> {
                            if (white) "k" else "K"
                        }
                        ChessPieceName.QUEEN -> {
                            if (white) "q" else "Q"
                        }
                        ChessPieceName.BISHOP -> {
                            if (white) "b" else "B"
                        }
                        ChessPieceName.ROOK -> {
                            if (white) "r" else "R"
                        }
                        ChessPieceName.PAWN -> {
                            if (white) "p" else "P"
                        }
                        ChessPieceName.KNIGHT -> {
                            if (white) "n" else "N"
                        }
                    }
                }
            }
            desc += "\n"

        }
        desc += "  0 1 2 3 4 5 6 7"
        desc += "\n"
        if (king == null) {
            if (playerInTurn == ChessPlayer.WHITE) {
                findWinner = 1
            } else if (playerInTurn == ChessPlayer.BLACK) {
                findWinner = 2
            }
        }
        desc += "${king?.col}, ${king?.row}, $findWinner"

        return desc
    }

}