package com.example.businesscontrollv3.infra.database

import androidx.room.*
import com.example.businesscontrollv3.model.Account
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDAO {

    @Query("SELECT * FROM Account ORDER BY  name ASC")
    fun getAllAccounts(): Flow<List<Account>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(account: Account)

    @Delete
    suspend fun delete(account: Account)
}