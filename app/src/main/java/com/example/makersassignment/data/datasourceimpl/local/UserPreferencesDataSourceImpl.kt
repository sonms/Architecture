package com.example.makersassignment.data.datasourceimpl.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.makersassignment.data.datasource.local.UserPreferencesDataSource
import com.example.makersassignment.data.dto.local.UserLocalDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : UserPreferencesDataSource {
    private object PreferencesKeys {
        val USER_ID = stringPreferencesKey("user_id")
        val USER_PASSWORD = stringPreferencesKey("user_password")
    }

    override suspend fun saveUserInfo(id: String, password: String) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.USER_ID] = id
            prefs[PreferencesKeys.USER_PASSWORD] = password
        }
    }

    override fun getUserInfo(): Flow<UserLocalDto> {
        return dataStore.data.map { prefs ->
            UserLocalDto(
                id = prefs[PreferencesKeys.USER_ID] ?: "",
                password = prefs[PreferencesKeys.USER_PASSWORD] ?: ""
            )
        }
    }
}