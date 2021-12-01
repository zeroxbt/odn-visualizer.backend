package contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class Identity extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/Identity.txt");

    public static final String FUNC_OTVERSION = "otVersion";

    public static final String FUNC_ADDKEY = "addKey";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_EXECUTE = "execute";

    public static final String FUNC_REMOVEKEY = "removeKey";

    public static final String FUNC_GETKEY = "getKey";

    public static final String FUNC_GETKEYPURPOSES = "getKeyPurposes";

    public static final String FUNC_GETKEYSBYPURPOSE = "getKeysByPurpose";

    public static final String FUNC_KEYHASPURPOSE = "keyHasPurpose";

    public static final Event KEYADDED_EVENT = new Event("KeyAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event KEYREMOVED_EVENT = new Event("KeyRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event EXECUTIONREQUESTED_EVENT = new Event("ExecutionRequested", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event EXECUTED_EVENT = new Event("Executed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event APPROVED_EVENT = new Event("Approved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Bool>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Identity(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Identity(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Identity(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Identity(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> otVersion() {
        final Function function = new Function(FUNC_OTVERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public List<KeyAddedEventResponse> getKeyAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(KEYADDED_EVENT, transactionReceipt);
        ArrayList<KeyAddedEventResponse> responses = new ArrayList<KeyAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            KeyAddedEventResponse typedResponse = new KeyAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.key = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.keyType = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.purposes = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<KeyAddedEventResponse> keyAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, KeyAddedEventResponse>() {
            @Override
            public KeyAddedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(KEYADDED_EVENT, log);
                KeyAddedEventResponse typedResponse = new KeyAddedEventResponse();
                typedResponse.log = log;
                typedResponse.key = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.keyType = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.purposes = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<KeyAddedEventResponse> keyAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(KEYADDED_EVENT));
        return keyAddedEventFlowable(filter);
    }

    public List<KeyRemovedEventResponse> getKeyRemovedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(KEYREMOVED_EVENT, transactionReceipt);
        ArrayList<KeyRemovedEventResponse> responses = new ArrayList<KeyRemovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            KeyRemovedEventResponse typedResponse = new KeyRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.key = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.keyType = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.purposes = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<KeyRemovedEventResponse> keyRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, KeyRemovedEventResponse>() {
            @Override
            public KeyRemovedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(KEYREMOVED_EVENT, log);
                KeyRemovedEventResponse typedResponse = new KeyRemovedEventResponse();
                typedResponse.log = log;
                typedResponse.key = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.keyType = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.purposes = (List<BigInteger>) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<KeyRemovedEventResponse> keyRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(KEYREMOVED_EVENT));
        return keyRemovedEventFlowable(filter);
    }

    public List<ExecutionRequestedEventResponse> getExecutionRequestedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTIONREQUESTED_EVENT, transactionReceipt);
        ArrayList<ExecutionRequestedEventResponse> responses = new ArrayList<ExecutionRequestedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecutionRequestedEventResponse typedResponse = new ExecutionRequestedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.executionId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutionRequestedEventResponse> executionRequestedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ExecutionRequestedEventResponse>() {
            @Override
            public ExecutionRequestedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTIONREQUESTED_EVENT, log);
                ExecutionRequestedEventResponse typedResponse = new ExecutionRequestedEventResponse();
                typedResponse.log = log;
                typedResponse.executionId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutionRequestedEventResponse> executionRequestedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTIONREQUESTED_EVENT));
        return executionRequestedEventFlowable(filter);
    }

    public List<ExecutedEventResponse> getExecutedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTED_EVENT, transactionReceipt);
        ArrayList<ExecutedEventResponse> responses = new ArrayList<ExecutedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecutedEventResponse typedResponse = new ExecutedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.executionId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecutedEventResponse> executedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ExecutedEventResponse>() {
            @Override
            public ExecutedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTED_EVENT, log);
                ExecutedEventResponse typedResponse = new ExecutedEventResponse();
                typedResponse.log = log;
                typedResponse.executionId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecutedEventResponse> executedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTED_EVENT));
        return executedEventFlowable(filter);
    }

    public List<ApprovedEventResponse> getApprovedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVED_EVENT, transactionReceipt);
        ArrayList<ApprovedEventResponse> responses = new ArrayList<ApprovedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovedEventResponse typedResponse = new ApprovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.executionId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovedEventResponse> approvedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovedEventResponse>() {
            @Override
            public ApprovedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVED_EVENT, log);
                ApprovedEventResponse typedResponse = new ApprovedEventResponse();
                typedResponse.log = log;
                typedResponse.executionId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovedEventResponse> approvedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVED_EVENT));
        return approvedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addKey(byte[] _key, List<BigInteger> _purposes, BigInteger _type) {
        final Function function = new Function(
                FUNC_ADDKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_key), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_purposes, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_type)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(BigInteger _id, Boolean _approve) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.Bool(_approve)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> execute(String _to, BigInteger _value, byte[] _data) {
        final Function function = new Function(
                FUNC_EXECUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeKey(byte[] _key) {
        final Function function = new Function(
                FUNC_REMOVEKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<List<BigInteger>, BigInteger, byte[]>> getKey(byte[] _key) {
        final Function function = new Function(FUNC_GETKEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple3<List<BigInteger>, BigInteger, byte[]>>(function,
                new Callable<Tuple3<List<BigInteger>, BigInteger, byte[]>>() {
                    @Override
                    public Tuple3<List<BigInteger>, BigInteger, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<BigInteger>, BigInteger, byte[]>(
                                convertToNative((List<Uint256>) results.get(0).getValue()), 
                                (BigInteger) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<List> getKeyPurposes(byte[] _key) {
        final Function function = new Function(FUNC_GETKEYPURPOSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
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

    public RemoteFunctionCall<List> getKeysByPurpose(BigInteger _purpose) {
        final Function function = new Function(FUNC_GETKEYSBYPURPOSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_purpose)), 
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

    public RemoteFunctionCall<Boolean> keyHasPurpose(byte[] _key, BigInteger _purpose) {
        final Function function = new Function(FUNC_KEYHASPURPOSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_key), 
                new org.web3j.abi.datatypes.generated.Uint256(_purpose)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static Identity load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Identity(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Identity load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Identity(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Identity load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Identity(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Identity load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Identity(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Identity> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String operational, String management) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operational), 
                new org.web3j.abi.datatypes.Address(management)));
        return deployRemoteCall(Identity.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Identity> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String operational, String management) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operational), 
                new org.web3j.abi.datatypes.Address(management)));
        return deployRemoteCall(Identity.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Identity> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String operational, String management) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operational), 
                new org.web3j.abi.datatypes.Address(management)));
        return deployRemoteCall(Identity.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Identity> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String operational, String management) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(operational), 
                new org.web3j.abi.datatypes.Address(management)));
        return deployRemoteCall(Identity.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class KeyAddedEventResponse extends BaseEventResponse {
        public byte[] key;

        public BigInteger keyType;

        public List<BigInteger> purposes;
    }

    public static class KeyRemovedEventResponse extends BaseEventResponse {
        public byte[] key;

        public BigInteger keyType;

        public List<BigInteger> purposes;
    }

    public static class ExecutionRequestedEventResponse extends BaseEventResponse {
        public BigInteger executionId;

        public String to;

        public BigInteger value;

        public byte[] data;
    }

    public static class ExecutedEventResponse extends BaseEventResponse {
        public BigInteger executionId;

        public String to;

        public BigInteger value;

        public byte[] data;
    }

    public static class ApprovedEventResponse extends BaseEventResponse {
        public BigInteger executionId;

        public Boolean approved;
    }
}
