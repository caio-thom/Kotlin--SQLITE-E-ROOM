package br.com.fiap.feedbackroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Carro::class), version = 1)
abstract  class AppCarsDatabase : RoomDatabase() {

    abstract fun CarroDao(): CarroDao

    companion object {
        @Volatile
        private var INSTANCE: AppCarsDatabase? = null

        fun getDatabase(context: Context): AppCarsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppCarsDatabase::class.java,
                    "app_cars_database") //nome do banco
                    .allowMainThreadQueries()  // nao recomentado para app reais,Possibilita execução de operações de banco de dados na MainThread, não deve ser executado em produção
                    .fallbackToDestructiveMigration()// // nao recomentado para app reais,Habilita destruição do banco e criação de um novo a cada upgrade do modelo
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}