package com.lakue.townchoresrenewal.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lakue.townchoresrenewal.R
import com.lakue.townchoresrenewal.base.BaseActivity
import com.lakue.townchoresrenewal.databinding.ActivityMainBinding
import com.lakue.townchoresrenewal.util.event.MenuChangeEventBus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity(
    private val menuChangeEventBus: MenuChangeEventBus
) : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initState() {
        super.initState()
        lifecycleScope.launch {
            menuChangeEventBus.changeMenu(MainTabMenu.HOME)
        }
    }

    override fun initViews() = with(binding) {
        bottomNavigationView.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> {
//                        showFragment(HomeFragment.newInstance(), HomeFragment.TAG)
                        true
                    }
                    R.id.menu_search -> {
//                        showFragment(HomeFragment.newInstance(), HomeFragment.TAG)
                        true
                    }
                    R.id.menu_upload -> {
//                        startActivity<PheedUploadActivity>()
                        false
                    }
                    R.id.menu_alarm -> {
//                        showFragment(HomeFragment.newInstance(), HomeFragment.TAG)
                        true
                    }
                    R.id.menu_mypage -> {
//                        showFragment(HomeFragment.newInstance(), HomeFragment.TAG)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    fun goToTab(mainTabMenu: MainTabMenu) {
        binding.bottomNavigationView.selectedItemId = mainTabMenu.menuId
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        val findFragment = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.fragments.forEach { fm ->
            supportFragmentManager.beginTransaction().hide(fm).commitAllowingStateLoss()
        }
        findFragment?.let {
            supportFragmentManager.beginTransaction().show(it).commitAllowingStateLoss()
        } ?: kotlin.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcvMain, fragment, tag)
                .commitAllowingStateLoss()
        }
    }

    override fun observeData() {
        lifecycleScope.launch {
            menuChangeEventBus.mainTabMenuFlow.collect {
                goToTab(it)
            }
        }
    }
}

enum class MainTabMenu(@IdRes val menuId: Int) {
    HOME(R.id.menu_home),
    SEARCH(R.id.menu_search),
    UPLOAD(R.id.menu_upload),
    ALRAM(R.id.menu_alarm),
    MYPAGE(R.id.menu_mypage)
}
