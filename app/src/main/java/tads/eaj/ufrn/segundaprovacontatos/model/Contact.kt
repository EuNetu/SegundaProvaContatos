package tads.eaj.ufrn.segundaprovacontatos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    var firstName: String,
    var lastName: String,
    var address: String,
    var relationship: String,
    var national: Boolean,
    var mainPhone: String,
    var secondPhone: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}
