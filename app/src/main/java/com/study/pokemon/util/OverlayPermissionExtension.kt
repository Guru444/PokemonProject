package com.study.pokemon.util

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.provider.Settings
import androidx.core.content.ContextCompat.getSystemService
import com.study.pokemon.model.PokemonData
import com.study.pokemon.otherdraw.ForegroundService

//Notification Server Start
fun Context.startService(pokemonData: PokemonData) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (Settings.canDrawOverlays(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this, ForegroundService::class.java).putExtra(Constant.OVERLAY_POKEMON_DATA, pokemonData))
            } else {
                startService(Intent(this, ForegroundService::class.java).putExtra(Constant.OVERLAY_POKEMON_DATA, pokemonData))
            }
        }
    } else {
        startService(Intent(this, ForegroundService::class.java).putExtra(Constant.OVERLAY_POKEMON_DATA, pokemonData))
    }
}

fun Context.checkOverlayPermission(isOverlay: (Boolean) -> Unit = {_->}) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (!Settings.canDrawOverlays(this)) {
            isOverlay(true)
        }else {
            isOverlay(false)
        }
    }
}

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}