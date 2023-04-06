package com.example.imenik.database


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.imenik.model.Imenik


@Dao
interface ImenikDAO {

    //povuci sve kontakte iz baze i spremi u listu
    @Query("SELECT * FROM kontakti")
     fun getAll(): LiveData<List<Imenik>>

    //spremi novog korisnika

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(imenik: Imenik)

   // obrisi korisnika iz baze
    @Delete
    suspend fun delete(imenik: Imenik)
}