package com.example.doodleboard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.doodleboard.MainActivity.Companion.path
import com.example.doodleboard.MainActivity.Companion.stylusNib

class DoodleView: View {

    var params : ViewGroup.LayoutParams? = null;

    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentInk = Color.BLACK
    }

    constructor(context: Context) : this(context, null){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        stylusNib.isAntiAlias = true;
        stylusNib.color = currentInk;
        stylusNib.style = Paint.Style.STROKE;
        stylusNib.strokeJoin = Paint.Join.ROUND;
        stylusNib.strokeWidth = 8f;

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x;
        var y = event.y;

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y);
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y);
                pathList.add(path);
                colorList.add(currentInk);
            }
            else -> return false
        }
        postInvalidate();
        return false
    }

    override fun onDrawForeground(canvas: Canvas) {
        for (i in pathList.indices) {
            stylusNib.setColor(colorList[i]);
            canvas.drawPath(pathList[i], stylusNib);
            invalidate();
        }
    }



}