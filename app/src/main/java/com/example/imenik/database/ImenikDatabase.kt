package com.example.imenik.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.imenik.model.Imenik



@Database(entities = [Imenik::class], version = 1, exportSchema = false)
abstract class ImenikDatabase: RoomDatabase() {
abstract fun getImenikDao(): ImenikDAO
    companion object{
        @Volatile
        private var INSTANCE:ImenikDatabase? = null

        fun getDatabaseData(context:Context) : ImenikDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ImenikDatabase::class.java,
                    "imenik_database"
                ).build()
                INSTANCE = instance
                instance
            }
    }

}
}