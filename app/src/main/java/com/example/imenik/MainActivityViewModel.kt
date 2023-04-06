package com.example.imenik

import android.app.Application
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.*
import androidx.room.util.appendPlaceholders
import com.example.imenik.database.ImenikDAO
import com.example.imenik.database.ImenikDatabase
import com.example.imenik.model.Imenik
import com.example.imenik.repository.ImenikRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application):AndroidViewModel(application) {
private val repository:ImenikRepository
val allContacts:LiveData<List<Imenik>>

init {
    val dao = ImenikDatabase.getDatabaseData(application).getImenikDao()
   repository = ImenikRepository(dao)
   allContacts = repository.getAllContacts
}

    fun insertContact(imenik: Imenik)=viewModelScope.launch(Dispatchers.IO){
    repository.insert(imenik)
    }






   }







