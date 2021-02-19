package com.example.businesscontrollv3.infra.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Responsible

@Database(entities =[Responsible::class, Account::class], version = 1, exportSchema = false)
    abstract class BCDatabase: RoomDatabase() {

        abstract fun responsibleDao(): ResponsibleDAO
        abstract fun accountDao(): AccountDAO

        companion object{
            @Volatile
            private var INSTANCE: BCDatabase? = null;

            fun getDatabase (context: Context): BCDatabase {
                return INSTANCE ?: synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                    BCDatabase::class.java,
                        "BCDatabase"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }
}