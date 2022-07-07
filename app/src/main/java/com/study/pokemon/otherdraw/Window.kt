package com.study.pokemon.otherdraw

import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.graphics.PixelFormat
import android.os.Build
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import com.study.pokemon.R
import com.study.pokemon.model.PokemonData
import com.study.pokemon.util.imgShow

class Window(context: Context, pokemonData: PokemonData) {

    private val context: Context
    private val mView: View
    private var mParams: WindowManager.LayoutParams? = null
    private val mWindowManager: WindowManager
    private val layoutInflater: LayoutInflater
    fun open() {
        try {
            if (mView.windowToken == null) {
                if (mView.parent == null) {
                    mWindowManager.addView(mView, mParams)
                }
            }
        } catch (e: Exception) {
            Log.d("Error1", e.toString())
        }
    }

    fun close() {
        try {
            (context.getSystemService(WINDOW_SERVICE) as WindowManager).removeView(mView)
            mView.invalidate()
            (mView.parent as ViewGroup).removeAllViews()

        } catch (e: Exception) {
            Log.d("Error2", e.toString())
        }
    }

    init {
        this.context = context
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mParams = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,

                PixelFormat.TRANSLUCENT
            )
        }
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mView = layoutInflater.inflate(R.layout.popup_window, null);

        context.imgShow(pokemonData.leftImage, mView.findViewById(R.id.iv_pokemon_left))
        context.imgShow(pokemonData.rightImage, mView.findViewById(R.id.iv_pokemon_right))
        val titleText: TextView = mView.findViewById(R.id.titleText)
        titleText.text = pokemonData.name
        val buttonClose: Button = mView.findViewById(R.id.window_close)
        //İnit olduktan sonra tetiklenmiyor. Custom drawda invalidate() edilmeli.
         buttonClose.setOnClickListener {
            close()
        }

        mParams!!.gravity = Gravity.CENTER
        mWindowManager = context.getSystemService(WINDOW_SERVICE) as WindowManager
    }
}