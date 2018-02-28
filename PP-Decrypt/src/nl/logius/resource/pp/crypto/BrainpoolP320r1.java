/*
 * This source code is protected by the EUPL version 1.2 and is part of the "PP Decrypt" library.
 * 
 * Copyright: Logius (2018)
 * @author: Bram van Pelt 
 */
package nl.logius.resource.pp.crypto;

import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/**
 * BrainpoolP320r1 conform RFC 5639
 */
public final class BrainpoolP320r1 {
    public static final ASN1ObjectIdentifier OID = TeleTrusTObjectIdentifiers.brainpoolP320r1;

    /**
     * Elliptic curve
     */
    public static final ECCurve CURVE;

    /**
      * Base point
      */
    public static final ECPoint G;

    /**
      * Prime order of the group generated by G
      */
    public static final BigInteger Q;

    static {
        final X9ECParameters ecp = TeleTrusTNamedCurves.getByOID(OID);
        CURVE = ecp.getCurve();
        G = ecp.getG();
        Q = ecp.getN();
    }

    private BrainpoolP320r1() {}
}