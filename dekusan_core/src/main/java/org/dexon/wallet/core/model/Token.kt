package org.dexon.wallet.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val symbol: String,
    val address: Address,
    val chain: ChainId,
    val decimals: Int = 18,
    val type: String? = null,
    val name: String? = null
)