package tads.eaj.ufrn.segundaprovacontatos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    var firstName: String,
    var lastName: String,
    var street: String,
    var numberHouse: Float,
    var relationship: String,
    var phone: String,
    var areaCode: Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}
