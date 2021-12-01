package util;

import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.util.encoders.Hex;

public final class Encoder {

    private Encoder(){

    }

    public static String keccak256(String input) {
        final Keccak.Digest256 digest = new Keccak.Digest256();

        byte[] hash = digest.digest(
                input.getBytes());
        return new String(Hex.encode(hash));
    }
}
