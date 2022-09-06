package br.com.fiap.feedbackroom.database



import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// var = variavel comum
// val = variavel constante
//@NonNull = nao pode ser nulo
//  @NonNull @ColumnInfo(name = "name") = deixar como nome na tabela/banco
@Entity(tableName = "cars")
data class Carro(@PrimaryKey(autoGenerate = true) var id: Int,
                 @NonNull @ColumnInfo(name = "modelo") var modelo: String,
                 @NonNull @ColumnInfo(name = "fabricante") var fabricante: String,
                 @NonNull @ColumnInfo(name = "placa ") var placa: String,
                 @NonNull @ColumnInfo(name = "preço")var preco:String,
                 @NonNull @ColumnInfo(name = "ano ")var ano: String)

