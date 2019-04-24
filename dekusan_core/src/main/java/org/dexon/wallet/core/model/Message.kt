package org.dexon.wallet.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Message<V>(
    @JvmField val value: @RawValue V,
    @JvmField val url: String?,
    @JvmField val leafPosition: Long?
) : Parcelable