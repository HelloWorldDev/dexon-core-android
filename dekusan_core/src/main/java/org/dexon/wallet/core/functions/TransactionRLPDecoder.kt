package org.dexon.wallet.core.functions

import org.dexon.wallet.core.model.Address
import org.dexon.wallet.core.model.SignatureData
import org.dexon.wallet.core.model.Transaction
import org.kethereum.functions.rlp.RLPElement
import org.kethereum.functions.rlp.RLPList
import org.kethereum.functions.rlp.toIntFromRLP
import org.kethereum.functions.rlp.toUnsignedBigIntegerFromRLP
import org.walleth.khex.toHexString

fun RLPList.toTransaction(): Transaction? {
    if (element.size != 6 && element.size != 9) {
        throw IllegalArgumentException("RLPList for transaction must have 6(unsigned) or 9(signed) elements - but has " + element.size)
    }

    val elements: List<RLPElement> = element.map {
        it as? RLPElement
            ?: throw IllegalArgumentException("RLPList to make transaction must consist only of elements - no list ")
    }

    return Transaction(
        chain = null,
        creationEpochSecond = System.currentTimeMillis(),
        from = null,
        nonce = elements[0].toUnsignedBigIntegerFromRLP(),
        gasPrice = elements[1].toUnsignedBigIntegerFromRLP(),
        gasLimit = elements[2].toUnsignedBigIntegerFromRLP(),
        to = Address(elements[3].bytes.toHexString()),
        value = elements[4].toUnsignedBigIntegerFromRLP(),
        input = elements[5].bytes.toList(),
        txHash = null,
        leafPosition = null
    )
}

fun RLPList.toTransactionSignatureData(): SignatureData {
    val elements: List<RLPElement> = element.map {
        it as? RLPElement
            ?: throw IllegalArgumentException("RLPList to make transaction must consist only of elements - no list ")
    }

    return SignatureData(
        v = elements[6].toIntFromRLP(),
        r = elements[7].toUnsignedBigIntegerFromRLP(),
        s = elements[8].toUnsignedBigIntegerFromRLP()
    )

}