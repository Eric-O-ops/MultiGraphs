package com.geektech.multigraphs.data.locale.preferences.userdata

import com.geektech.multigraphs.data.locale.preferences.PreferencesConstants
import com.geektech.multigraphs.data.locale.preferences.PreferencesHelper

class UserPreferencesData(
    private val preferences: PreferencesHelper
) {
    var isAuthorized: Boolean
        get() = preferences().getBoolean(
            PreferencesConstants.PREF_IS_AUTHORIZED, false
        )
        set(value) = preferences()
            .edit().putBoolean(
                PreferencesConstants.PREF_IS_AUTHORIZED, value
            ).apply()
}