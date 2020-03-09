package com.example.laboratorio7.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_table")

data class QuestEnti(

    @PrimaryKey(autoGenerate = true)
    var id:Int=0,

    @ColumnInfo(name = "name")
    var name:String="",

    @ColumnInfo(name = "type") //evalua si es texto o numero
    var tipoPregunta:String="",

    @ColumnInfo(name= "default")  //evalua si la pregunta es establecida o no
    var defect:Int=1

)