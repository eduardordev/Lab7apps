package com.example.laboratorio7.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laboratorio7.database.EncuestaEntity
import com.example.laboratorio7.database.PreguntaEntity
import com.example.laboratorio7.database.RespuestaEntity
import com.example.laboratorio7.database.SurveyDao
import kotlinx.coroutines.*

class EncuestaViewModel (val database: SurveyDao, application: Application): AndroidViewModel(application) {

    private var viewModelJob= Job()
    private val  uiScope= CoroutineScope(Dispatchers.Main+viewModelJob)
    private  var _pregunta= MutableLiveData<String>()
    var todas = database.getAllPreguntas()


    val preguntas: MutableLiveData<String>

        get() = _pregunta


    init {
        pregunta()
    }

    fun pregunta(){
        uiScope.launch {

            getPreguntas()
        }
    }

    suspend fun getPreguntas(){

        withContext(Dispatchers.IO){

            var listss=database.getAllPreguntas()
            listss=todas
        }
    }


    fun createEncuesta(){

        uiScope.launch {

            val encuesta=EnqEntity()
            agregarEncuesta(encuesta)
        }
    }

    suspend fun agregarEncuesta(encuesta: EnqEntity){

        withContext(Dispatchers.IO){
            database.createEncuesta(encuesta)
        }
    }


    fun onAddQuestionRequested(pregunta: String,tipo:String){
        uiScope.launch {

            var preguntad=QuestEnti()
            preguntad.name= pregunta.toString()
            preguntad.tipoPregunta=tipo.toString()
            addPregunta(preguntad)

        }
    }

    private suspend fun addPregunta(pregunta:QuestEnti){
        withContext(Dispatchers.IO){
            database.insertPregunta(pregunta)
        }

    }

    fun deleteAllPreguntas(){
        uiScope.launch {

            deletePreguntas()


        }
    }

    private suspend fun deletePreguntas(){
        withContext(Dispatchers.IO){
            database.clearPreguntas(1)
        }

    }


    override fun onCleared() {
        super.onCleared()
        Log.i("EncuestaViewModel","OnCleared Model")
        viewModelJob.cancel()
    }

}
