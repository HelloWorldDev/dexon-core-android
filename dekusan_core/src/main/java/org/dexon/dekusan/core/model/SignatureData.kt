package org.dexon.dekusan.core.model

import java.math.BigInteger

data class SignatureData(
    var r: BigInteger = BigInteger.ZERO,
    var s: BigInteger = BigInteger.ZERO,
    var v: Int = 0
)
