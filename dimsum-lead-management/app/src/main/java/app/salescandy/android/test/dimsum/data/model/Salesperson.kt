package app.salescandy.android.test.dimsum.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

/**
 * Currently very threadbare, just to support login. Will add more elaborate features later
 */

@Entity(tableName = Salesperson.TABLE_NAME, indices = [
    Index(value = ["username"], unique = true),
    Index(value = ["phone"], unique = true)
])
data class Salesperson(
    var username : String,
    var phone : String
) : Model {
    companion object {
        const val TABLE_NAME = "salespeople"
    }

    @PrimaryKey(autoGenerate = true) override var id : Int = 0

    /**
     * Display name; just appends a @ in front of the username
     */
    val displayName : String get() = "@$username"
}