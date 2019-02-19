package org.dexon.dekusan.core.model

data class SignedTransaction(
    var transaction: Transaction,
    var signatureData: SignatureData
)