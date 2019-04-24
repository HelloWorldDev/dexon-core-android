package org.dexon.wallet.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Address(private val input: String) : Parcelable {

    val cleanHex = input.removePrefix("0x")

    @Transient
    val hex = "0x$cleanHex"

    override fun toString() = hex

    override fun equals(other: Any?) =
        other is Address && other.cleanHex.toUpperCase() == cleanHex.toUpperCase()

    override fun hashCode() = cleanHex.toUpperCase().hashCode()
}
