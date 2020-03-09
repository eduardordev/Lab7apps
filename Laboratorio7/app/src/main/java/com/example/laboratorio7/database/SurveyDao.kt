package com.example.laboratorio7.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SurveyDao{

    @Insert
    fun insertPregunta(pregunta:QuestEnti)

    @Insert
    fun createEncuesta(encuesta: EnqEntity)



    @Insert
    fun insertRespuesta(respuesta:AnswEntity)

    @Query("SELECT * FROM poll_table WHERE id=:key")
    fun  getEncuesta(key:Int):EnqEntity?

    @Query("SELECT*FROM answer_table ")
    fun getAllResponses():LiveData<List<AnswEntity>>

    @Query("SELECT * FROM question_table ")
    fun getAllPreguntas():LiveData<List<PreguntaEntity>>

    @Query("SELECT * FROM poll_table")
    fun getNumberOfSurveys():LiveData<List<EnqEntity>>

    @Query("DELETE FROM poll_table")
    fun clearSurveys()

    @Query("DELETE FROM answer_table")
    fun clearResults()

    @Query("DELETE FROM question_table WHERE `default`=:key")
    fun clearPreguntas(key:Int)

    @Query("SELECT * FROM question_table WHERE id=:key")
    fun  getPregunta(key:Int):QuestEnti?

    @Query("SELECT COUNT(id) FROM question_table")
    fun getCantidadPreguntas():Int

    @Query("SELECT type FROM question_table")
    fun getTypeQuestion():String


}