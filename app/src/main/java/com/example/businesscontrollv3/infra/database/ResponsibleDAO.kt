package com.example.businesscontrollv3.infra.database

import androidx.room.*
import com.example.businesscontrollv3.model.Responsible
import kotlinx.coroutines.flow.Flow


@Dao
interface ResponsibleDAO {
    // flow - programação reativa do android
    @Query("SELECT * FROM Responsible ORDER BY  name ASC")
    fun getAllResponsibles(): Flow<List<Responsible>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(responsible:Responsible)

    @Delete
        suspend fun delete(responsible:Responsible)
}