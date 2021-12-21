package com.lakue.townchoresrenewal.ui.main

import com.lakue.townchoresrenewal.base.BaseViewModel
import com.lakue.townchoresrenewal.util.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userManager: UserManager
    ): BaseViewModel(userManager) {

}