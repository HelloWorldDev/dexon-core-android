package org.dexon.wallet.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChainDefinition(
    val id: Long,
    private val prefix: String = "ETH"
) : Parcelable {
    override fun toString() = "$prefix:$id"
}
