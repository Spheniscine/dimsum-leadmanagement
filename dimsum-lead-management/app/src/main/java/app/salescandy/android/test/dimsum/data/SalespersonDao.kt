package app.salescandy.android.test.dimsum.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import app.salescandy.android.test.dimsum.data.model.Salesperson

@Dao
interface SalespersonDao {
    @Insert
    fun insert(salesperson: Salesperson)

    @Update
    fun update(salesperson: Salesperson)

    @Delete
    fun delete(salesperson: Salesperson)

    @get:Query("SELECT * FROM ${Salesperson.TABLE_NAME}")
    val allSalespeople : LiveData<List<Salesperson>>

    @Query("SELECT * FROM ${Salesperson.TABLE_NAME}  WHERE id = :id ")
    fun getById(id : Int) : Salesperson
}