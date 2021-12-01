package util;

import static util.Encoder.keccak256;

public class Decoder {
    public static final int FUNCTION_NAME_HEX = 8;
    public static final int FUNCTION_ARGUMENT_HEX = 64;
    public static final int ADDRESS_HEX = 40;
    public static final int ADDRESS_PADDING_HEX = FUNCTION_ARGUMENT_HEX - ADDRESS_HEX;

    private Decoder(){

    }

    public static String getFunction(String inputData) {
        return inputData.substring(2, 2 + FUNCTION_NAME_HEX);
    }

    public static String getArgs(String inputData, int argNumber){
        int offset = 2 + FUNCTION_NAME_HEX + argNumber * FUNCTION_ARGUMENT_HEX;
        return inputData.substring(offset, offset + FUNCTION_ARGUMENT_HEX);
    }

    public static String decodeAddress(String inputData) {
        String address = inputData.substring(ADDRESS_PADDING_HEX);
        return "0x" + address;
    }

    public static String removeAddressPadding(String data){
        return data.substring(ADDRESS_PADDING_HEX);
    }


}
