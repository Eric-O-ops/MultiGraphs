package com.geektech.multigraphs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
class DataStore() {

    private lateinit var context: Context
    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().context
    }


    @Test
    fun dataStorePreferenceSaveData(): Unit = runBlocking{
        context.dataStore.edit { pref ->
            pref[booleanPreferencesKey("onboard")] = true

        }
        val data: Flow<Boolean> = context.dataStore.data.map {
            it[booleanPreferencesKey("onboard")] ?: false
        }
        assertEquals(true, data)
    }

    @Test
    fun dataStorePreferenceGetData() {
        assertEquals(4, 2 + 2)
    }
}