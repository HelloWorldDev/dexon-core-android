package org.dexon.dekusan.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Message<V>(
    @JvmField val value: @RawValue V,
    @JvmField val url: String?,
    @JvmField val leafPosition: Long?
) : Parcelable