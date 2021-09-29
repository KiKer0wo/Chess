package com.kiker.chess

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_MOVE
import android.view.View
import java.lang.Float.min
import kotlin.math.min

class ChessView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {


    private var originX = 20f
    private var originY = 200f
    private val scale = 1f
    private var cellSide = 130f
    private val paint = Paint()
    var chessDelegate: ChessDelegate? = null
    private var movingPiece: ChessPiece? = null
    private var fromCol: Int = -1
    private var fromRow: Int = -1
    private var movingPieceX = -1f
    private var movingPieceY = -1f
    private var movingPieceBitmap: Bitmap? = null

    private val imgResIDs = setOf(
        R.drawable.rook_black,
        R.drawable.rook_white,
        R.drawable.king_black,
        R.drawable.king_white,
        R.drawable.bishop_black,
        R.drawable.bishop_white,
        R.drawable.knight_black,
        R.drawable.knight_white,
        R.drawable.queen_black,
        R.drawable.queen_white,
        R.drawable.pawn_black,
        R.drawable.pawn_white,
    )

    private fun createChessBoard(canvas: Canvas?) {
        for (j in 0..3) {
            for (i in 0..3) {
                paint.color = Color.LTGRAY
                canvas?.drawRect(
                    originX + 2 * i * cellSide,
                    originY + 2 * j * cellSide,
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    paint
                )
                canvas?.drawRect(
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    originX + (2 * i + 2) * cellSide,
                    originY + (2 * j + 2) * cellSide,
                    paint
                )

                paint.color = Color.GRAY
                canvas?.drawRect(
                    originX + (2 * i + 1) * cellSide,
                    originY + 2 * j * cellSide,
                    originX + (2 * i + 2) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    paint
                )
                canvas?.drawRect(
                    originX + (2 * i) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 2) * cellSide,
                    paint
                )
            }
        }
    }

    private fun loadBitmaps() {
        imgResIDs.forEach {
            bitmaps[it] = BitmapFactory.decodeResource(resources, it)

        }
    }

    private fun drawPiecesInSquares(canvas: Canvas?, col: Int, row: Int, resID: Int) {
        val bitmap = bitmaps[resID]!!
        canvas?.drawBitmap(
            bitmap,
            null,
            RectF(
                originX + col * cellSide,
                originY + (7 - row) * cellSide,
                originX + (col + 1) * cellSide,
                originY + ((7 - row) + 1) * cellSide
            ),
            paint
        )
    }

    private fun drawPieces(canvas: Canvas?) {
        for (row in 0..7) {
            for (col in 0..7) {
                chessDelegate?.isPieceAt(col, row)?.let {
                    if (it != movingPiece) {
                        drawPiecesInSquares(canvas, col, row, it.resID)
                    }
                }

            }
        }
        movingPieceBitmap?.let {
            canvas?.drawBitmap(
                it,
                null,
                RectF(
                    movingPieceX - cellSide / 2,
                    movingPieceY - cellSide / 2,
                    movingPieceX + cellSide / 2,
                    movingPieceY + cellSide / 2
                ),
                paint
            )
        }
    }

    private val bitmaps = mutableMapOf<Int, Bitmap>()

    init {
        loadBitmaps()
    }

    //funkcja tworząca szachownice
    override fun onDraw(canvas: Canvas?) {

        //skalowanie surface'u
        canvas?.let {
            val bSide = min(width, height) * scale
            cellSide = bSide / 8f
            originX = (width - bSide) / 2f
            originY = (height - bSide) / 2f
        }
        //stworzenie szachownicy
        createChessBoard(canvas)

        // Figury na szachownicy
        drawPieces(canvas)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event ?: return false

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                fromCol = ((event.x - originX) / cellSide).toInt()
                fromRow = 7 - ((event.y - originY) / cellSide).toInt()
                chessDelegate?.isPieceAt(fromCol, fromRow)?.let {
                    movingPiece = it
                    movingPieceBitmap = bitmaps[it.resID]
                }

            }
            MotionEvent.ACTION_MOVE -> {
                movingPieceX = event.x
                movingPieceY = event.y
                invalidate()

            }
            MotionEvent.ACTION_UP -> {
                val col = ((event.x - originX) / cellSide).toInt()
                val row = 7 - ((event.y - originY) / cellSide).toInt()
                if (fromCol != col || fromRow != row) {
                    chessDelegate?.movePiece(fromCol, fromRow, col, row)
                }
                movingPieceBitmap = null
                movingPiece = null
                invalidate()
            }
        }
        return true

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val scale = min(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(scale, scale)

    }
}