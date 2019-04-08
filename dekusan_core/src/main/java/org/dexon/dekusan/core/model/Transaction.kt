package org.dexon.dekusan.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.kethereum.DEFAULT_GAS_LIMIT
import org.kethereum.DEFAULT_GAS_PRICE
import org.kethereum.model.ChainId
import java.math.BigInteger

@Parcelize
data class Transaction(
    var chain: Long?,
    var creationEpochSecond: Long?,
    var from: Address?,
    var gasLimit: BigInteger,
    var gasPrice: BigInteger,
    var input: List<Byte>,
    var nonce: BigInteger?,
    var to: Address?,
    var txHash: String?,
    var value: BigInteger,
    val leafPosition: Long?
) : Parcelable {
    constructor() : this(
        chain = null,
        creationEpochSecond = null,
        from = null,
        gasLimit = DEFAULT_GAS_LIMIT,
        gasPrice = DEFAULT_GAS_PRICE,
        input = emptyList<Byte>(),
        nonce = null,
        to = null,
        txHash = null,
        value = BigInteger.ZERO,
        leafPosition = 0
    )
}

// we cannot use default values in the data class when we want to use it with room
fun createTransactionWithDefaults(
    chain: ChainId? = null,
    creationEpochSecond: Long? = null,
    from: Address?,
    gasLimit: BigInteger = DEFAULT_GAS_LIMIT,
    gasPrice: BigInteger = DEFAULT_GAS_PRICE,
    input: List<Byte> = emptyList(),
    nonce: BigInteger? = null,
    to: Address?,
    txHash: String? = null,
    value: BigInteger,
    leafPosition: Long?
) = Transaction(
    chain?.value,
    creationEpochSecond,
    from,
    gasLimit,
    gasPrice,
    input,
    nonce,
    to,
    txHash,
    value,
    leafPosition
)

