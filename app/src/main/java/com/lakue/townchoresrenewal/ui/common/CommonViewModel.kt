package com.lakue.townchoresrenewal.ui.common

import com.lakue.townchoresrenewal.base.BaseViewModel
import com.lakue.townchoresrenewal.util.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(
    private val userManager: UserManager
    ): BaseViewModel(userManager) {

}