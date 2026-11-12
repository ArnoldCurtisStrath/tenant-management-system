package com.example.tenantmanagementsystem.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tenants")
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String,

    // room fills this in, 0 means it has not been saved yet
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) : Serializable {

    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}
