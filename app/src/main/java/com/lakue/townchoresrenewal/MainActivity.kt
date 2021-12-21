package com.lakue.townchoresrenewal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

enum class MainTabMenu(@IdRes val menuId: Int) {
    HOME(R.id.menu_home), MY(R.id.menu_my)
}
