package com.acg.manzhai.views.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

class GlideView

@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {
    private val TAG: String = "GlideView"
    private lateinit var mGlide: RequestManager

    init {
        initGlide()
    }


    override fun onDetachedFromWindow() {
        clearGlide()
        super.onDetachedFromWindow()
    }


    fun initGlide(){
        mGlide = Glide.with(context)
    }

    fun loadImage(url: String){
        Log.d(TAG,"loadImageUrl: $url, context: ${context.javaClass}")
        mGlide.asBitmap().load(url).into(this)
    }

    fun clearGlide(){
        mGlide.clear(this)
    }
}
