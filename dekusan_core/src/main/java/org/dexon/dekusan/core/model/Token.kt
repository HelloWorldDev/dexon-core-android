package org.dexon.dekusan.core.model

import org.kethereum.model.ChainId

data class Token(
    val symbol: String,
    val address: Address,
    val chain: ChainId,
    val decimals: Int = 18,
    val type: String? = null,
    val name: String? = null
)