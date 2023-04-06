package com.example.imenik.repository

import androidx.lifecycle.LiveData
import com.example.imenik.database.ImenikDAO
import com.example.imenik.database.ImenikDatabase
import com.example.imenik.model.Imenik
import kotlinx.coroutines.flow.Flow


class ImenikRepository(private val dao: ImenikDAO) {

    val getAllContacts: LiveData<List<Imenik>> = dao.getAll()

    suspend fun insert(imenik: Imenik){
        dao.insert(imenik)
    }








}