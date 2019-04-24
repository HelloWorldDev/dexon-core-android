package org.dexon.wallet.core.model

data class SignedTransaction(
    var transaction: Transaction,
    var signatureData: SignatureData
)