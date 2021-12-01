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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
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
public class ProfileStorage extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/ProfileStorage.txt");

    public static final String FUNC_ACTIVENODES = "activeNodes";

    public static final String FUNC_HUB = "hub";

    public static final String FUNC_PROFILE = "profile";

    public static final String FUNC_SETHUBADDRESS = "setHubAddress";

    public static final String FUNC_SETACTIVENODES = "setActiveNodes";

    public static final String FUNC_GETSTAKE = "getStake";

    public static final String FUNC_GETSTAKERESERVED = "getStakeReserved";

    public static final String FUNC_GETREPUTATION = "getReputation";

    public static final String FUNC_GETWITHDRAWALPENDING = "getWithdrawalPending";

    public static final String FUNC_GETWITHDRAWALTIMESTAMP = "getWithdrawalTimestamp";

    public static final String FUNC_GETWITHDRAWALAMOUNT = "getWithdrawalAmount";

    public static final String FUNC_GETNODEID = "getNodeId";

    public static final String FUNC_SETSTAKE = "setStake";

    public static final String FUNC_SETSTAKERESERVED = "setStakeReserved";

    public static final String FUNC_SETREPUTATION = "setReputation";

    public static final String FUNC_SETWITHDRAWALPENDING = "setWithdrawalPending";

    public static final String FUNC_SETWITHDRAWALTIMESTAMP = "setWithdrawalTimestamp";

    public static final String FUNC_SETWITHDRAWALAMOUNT = "setWithdrawalAmount";

    public static final String FUNC_SETNODEID = "setNodeId";

    public static final String FUNC_INCREASESTAKESRESERVED = "increaseStakesReserved";

    public static final String FUNC_TRANSFERTOKENS = "transferTokens";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected ProfileStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProfileStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ProfileStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ProfileStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> activeNodes() {
        final Function function = new Function(FUNC_ACTIVENODES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> hub() {
        final Function function = new Function(FUNC_HUB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple7<BigInteger, BigInteger, BigInteger, Boolean, BigInteger, BigInteger, byte[]>> profile(String param0) {
        final Function function = new Function(FUNC_PROFILE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple7<BigInteger, BigInteger, BigInteger, Boolean, BigInteger, BigInteger, byte[]>>(function,
                new Callable<Tuple7<BigInteger, BigInteger, BigInteger, Boolean, BigInteger, BigInteger, byte[]>>() {
                    @Override
                    public Tuple7<BigInteger, BigInteger, BigInteger, Boolean, BigInteger, BigInteger, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<BigInteger, BigInteger, BigInteger, Boolean, BigInteger, BigInteger, byte[]>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (byte[]) results.get(6).getValue());
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

    public RemoteFunctionCall<TransactionReceipt> setActiveNodes(BigInteger newActiveNodes) {
        final Function function = new Function(
                FUNC_SETACTIVENODES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newActiveNodes)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getStake(String identity) {
        final Function function = new Function(FUNC_GETSTAKE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getStakeReserved(String identity) {
        final Function function = new Function(FUNC_GETSTAKERESERVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getReputation(String identity) {
        final Function function = new Function(FUNC_GETREPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> getWithdrawalPending(String identity) {
        final Function function = new Function(FUNC_GETWITHDRAWALPENDING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> getWithdrawalTimestamp(String identity) {
        final Function function = new Function(FUNC_GETWITHDRAWALTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getWithdrawalAmount(String identity) {
        final Function function = new Function(FUNC_GETWITHDRAWALAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getNodeId(String identity) {
        final Function function = new Function(FUNC_GETNODEID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> setStake(String identity, BigInteger stake) {
        final Function function = new Function(
                FUNC_SETSTAKE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(stake)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setStakeReserved(String identity, BigInteger stakeReserved) {
        final Function function = new Function(
                FUNC_SETSTAKERESERVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(stakeReserved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setReputation(String identity, BigInteger reputation) {
        final Function function = new Function(
                FUNC_SETREPUTATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(reputation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setWithdrawalPending(String identity, Boolean withdrawalPending) {
        final Function function = new Function(
                FUNC_SETWITHDRAWALPENDING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.Bool(withdrawalPending)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setWithdrawalTimestamp(String identity, BigInteger withdrawalTimestamp) {
        final Function function = new Function(
                FUNC_SETWITHDRAWALTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(withdrawalTimestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setWithdrawalAmount(String identity, BigInteger withdrawalAmount) {
        final Function function = new Function(
                FUNC_SETWITHDRAWALAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(withdrawalAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setNodeId(String identity, byte[] nodeId) {
        final Function function = new Function(
                FUNC_SETNODEID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Bytes32(nodeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseStakesReserved(String payer, String identity1, String identity2, String identity3, BigInteger amount) {
        final Function function = new Function(
                FUNC_INCREASESTAKESRESERVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(payer), 
                new org.web3j.abi.datatypes.Address(identity1), 
                new org.web3j.abi.datatypes.Address(identity2), 
                new org.web3j.abi.datatypes.Address(identity3), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferTokens(String wallet, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFERTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(wallet), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ProfileStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProfileStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ProfileStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProfileStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ProfileStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ProfileStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ProfileStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ProfileStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ProfileStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(ProfileStorage.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ProfileStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(ProfileStorage.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProfileStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(ProfileStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ProfileStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(ProfileStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
