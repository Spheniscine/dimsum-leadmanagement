package app.salescandy.android.test.dimsum.data

import android.arch.lifecycle.LiveData
import app.salescandy.android.test.dimsum.data.model.Salesperson

interface Repository {
    val allSalespeople : LiveData<List<Salesperson>>
    fun insert(salesperson: Salesperson)
    fun update(salesperson: Salesperson)
    fun delete(salesperson: Salesperson)
    fun getSalespersonById(id: Int) : Salesperson
}
