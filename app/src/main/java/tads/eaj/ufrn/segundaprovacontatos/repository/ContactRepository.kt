package tads.eaj.ufrn.segundaprovacontatos.repository

import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.segundaprovacontatos.dao.ContactDao
import tads.eaj.ufrn.segundaprovacontatos.model.Contact
import javax.inject.Inject

class ContactRepository @Inject constructor(private var dao:ContactDao) : IContactRepository {
    override fun listAll(): Flow<List<Contact>> {
        return dao.listAll()
    }

    override fun create(c: Contact) {
        dao.create(c)
    }

    override fun findById(id:Long):Contact?{
        return dao.findById(id)
    }

    override fun update(c:Contact){
        return dao.update(c)
    }
}