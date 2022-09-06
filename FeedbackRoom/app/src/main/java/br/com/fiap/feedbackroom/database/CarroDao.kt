package br.com.fiap.feedbackroom.database

import androidx.room.*
import br.com.fiap.feedbackroom.database.Carro

@Dao
interface CarroDao {

    @Query("SELECT * FROM cars ORDER BY modelo ASC")
    fun getAll() : List<Carro>

    @Insert
    fun insert(vararg car: Carro)

    @Update
    fun update(car: Carro)

    @Delete
    fun delete(car: Carro)
}