package com.example.movieapp.data.repository

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.movieapp.domain.repository.DataStoreOperations
import com.example.movieapp.util.Constants.PREFERENCE_DATA_STORE
import com.example.movieapp.util.Constants.PREFERENCE_ONBOARD_COMPLETE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_DATA_STORE)

class DataStoreOperationImpl(context: Context) : DataStoreOperations {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCE_ONBOARD_COMPLETE)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.edit { it ->
            Log.e("MovieApp","saveOnBoardingState ${completed}")
            it[PreferencesKey.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { prefereces ->
            Log.e("MovieApp"," ${prefereces}")
            val onBoardingState = prefereces[PreferencesKey.onBoardingKey] ?: false
            onBoardingState
        }
    }
}