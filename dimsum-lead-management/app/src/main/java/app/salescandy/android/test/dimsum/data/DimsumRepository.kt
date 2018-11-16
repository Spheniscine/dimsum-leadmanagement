package app.salescandy.android.test.dimsum.data

import app.salescandy.android.test.dimsum.data.model.Salesperson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult

class DimsumRepository(val salespersonDao : SalespersonDao) : Repository {
    override val allSalespeople = salespersonDao.allSalespeople

    override fun insert(salesperson: Salesperson) {
        doAsync { salespersonDao.insert(salesperson) }
    }

    override fun update(salesperson: Salesperson) {
        doAsync { salespersonDao.update(salesperson) }
    }

    override fun delete(salesperson: Salesperson) {
        doAsync { salespersonDao.delete(salesperson) }
    }

    override fun getSalespersonById(id: Int) : Salesperson {
        return doAsyncResult { salespersonDao.getById(id) }.get()
    }
}