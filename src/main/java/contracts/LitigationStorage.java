package contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import util.BinLoader;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class LitigationStorage extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/LitigationStorage.txt");

    public static final String FUNC_HUB = "hub";

    public static final String FUNC_LITIGATION = "litigation";

    public static final String FUNC_SETHUBADDRESS = "setHubAddress";

    public static final String FUNC_SETLITIGATIONLITIGATORIDENTITY = "setLitigationLitigatorIdentity";

    public static final String FUNC_SETLITIGATIONREQUESTEDOBJECTINDEX = "setLitigationRequestedObjectIndex";

    public static final String FUNC_SETLITIGATIONREQUESTEDBLOCKINDEX = "setLitigationRequestedBlockIndex";

    public static final String FUNC_SETLITIGATIONREQUESTEDDATA = "setLitigationRequestedData";

    public static final String FUNC_SETLITIGATIONHASHARRAY = "setLitigationHashArray";

    public static final String FUNC_SETLITIGATIONSTATUS = "setLitigationStatus";

    public static final String FUNC_SETLITIGATIONTIMESTAMP = "setLitigationTimestamp";

    public static final String FUNC_SETLITIGATIONREPLACEMENTTASK = "setLitigationReplacementTask";

    public static final String FUNC_SETLITIGATIONREPLACEMENTDIFFICULTY = "setLitigationReplacementDifficulty";

    public static final String FUNC_GETLITIGATIONLITIGATORIDENTITY = "getLitigationLitigatorIdentity";

    public static final String FUNC_GETLITIGATIONREQUESTEDOBJECTINDEX = "getLitigationRequestedObjectIndex";

    public static final String FUNC_GETLITIGATIONREQUESTEDBLOCKINDEX = "getLitigationRequestedBlockIndex";

    public static final String FUNC_GETLITIGATIONREQUESTEDDATA = "getLitigationRequestedData";

    public static final String FUNC_GETLITIGATIONHASHARRAY = "getLitigationHashArray";

    public static final String FUNC_GETLITIGATIONSTATUS = "getLitigationStatus";

    public static final String FUNC_GETLITIGATIONTIMESTAMP = "getLitigationTimestamp";

    public static final String FUNC_GETLITIGATIONREPLACEMENTTASK = "getLitigationReplacementTask";

    public static final String FUNC_GETLITIGATIONREPLACEMENTDIFFICULTY = "getLitigationReplacementDifficulty";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected LitigationStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LitigationStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LitigationStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LitigationStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> hub() {
        final Function function = new Function(FUNC_HUB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple8<String, BigInteger, BigInteger, byte[], BigInteger, BigInteger, byte[], BigInteger>> litigation(byte[] param0, String param1) {
        final Function function = new Function(FUNC_LITIGATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple8<String, BigInteger, BigInteger, byte[], BigInteger, BigInteger, byte[], BigInteger>>(function,
                new Callable<Tuple8<String, BigInteger, BigInteger, byte[], BigInteger, BigInteger, byte[], BigInteger>>() {
                    @Override
                    public Tuple8<String, BigInteger, BigInteger, byte[], BigInteger, BigInteger, byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<String, BigInteger, BigInteger, byte[], BigInteger, BigInteger, byte[], BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (byte[]) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (byte[]) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> setHubAddress(String newHubAddress) {
        final Function function = new Function(
                FUNC_SETHUBADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newHubAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationLitigatorIdentity(byte[] offerId, String holderIdentity, String litigatorIdentity) {
        final Function function = new Function(
                FUNC_SETLITIGATIONLITIGATORIDENTITY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.Address(litigatorIdentity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationRequestedObjectIndex(byte[] offerId, String holderIdentity, BigInteger requestedObjectIndex) {
        final Function function = new Function(
                FUNC_SETLITIGATIONREQUESTEDOBJECTINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Uint256(requestedObjectIndex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationRequestedBlockIndex(byte[] offerId, String holderIdentity, BigInteger requestedBlockIndex) {
        final Function function = new Function(
                FUNC_SETLITIGATIONREQUESTEDBLOCKINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Uint256(requestedBlockIndex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationRequestedData(byte[] offerId, String holderIdentity, byte[] requestedData) {
        final Function function = new Function(
                FUNC_SETLITIGATIONREQUESTEDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Bytes32(requestedData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationHashArray(byte[] offerId, String holderIdentity, List<byte[]> hashArray) {
        final Function function = new Function(
                FUNC_SETLITIGATIONHASHARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(hashArray, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationStatus(byte[] offerId, String holderIdentity, BigInteger status) {
        final Function function = new Function(
                FUNC_SETLITIGATIONSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Uint8(status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationTimestamp(byte[] offerId, String holderIdentity, BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SETLITIGATIONTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Uint256(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationReplacementTask(byte[] offerId, String holderIdentity, byte[] replacementTask) {
        final Function function = new Function(
                FUNC_SETLITIGATIONREPLACEMENTTASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Bytes32(replacementTask)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLitigationReplacementDifficulty(byte[] offerId, String holderIdentity, BigInteger replacementDifficulty) {
        final Function function = new Function(
                FUNC_SETLITIGATIONREPLACEMENTDIFFICULTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Uint256(replacementDifficulty)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getLitigationLitigatorIdentity(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONLITIGATORIDENTITY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getLitigationRequestedObjectIndex(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONREQUESTEDOBJECTINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getLitigationRequestedBlockIndex(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONREQUESTEDBLOCKINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getLitigationRequestedData(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONREQUESTEDDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<List> getLitigationHashArray(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONHASHARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getLitigationStatus(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getLitigationTimestamp(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getLitigationReplacementTask(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONREPLACEMENTTASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getLitigationReplacementDifficulty(byte[] offerId, String holderIdentity) {
        final Function function = new Function(FUNC_GETLITIGATIONREPLACEMENTDIFFICULTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static LitigationStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LitigationStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LitigationStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LitigationStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LitigationStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LitigationStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LitigationStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LitigationStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LitigationStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(LitigationStorage.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<LitigationStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(LitigationStorage.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LitigationStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(LitigationStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LitigationStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(LitigationStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
