package contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class Litigation extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/Litigation.txt");

    public static final String FUNC_HUB = "hub";

    public static final String FUNC_SETHUBADDRESS = "setHubAddress";

    public static final String FUNC_INITIATELITIGATION = "initiateLitigation";

    public static final String FUNC_ANSWERLITIGATION = "answerLitigation";

    public static final String FUNC_COMPLETELITIGATION = "completeLitigation";

    public static final Event LITIGATIONINITIATED_EVENT = new Event("LitigationInitiated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event LITIGATIONANSWERED_EVENT = new Event("LitigationAnswered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event LITIGATIONTIMEDOUT_EVENT = new Event("LitigationTimedOut", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event LITIGATIONCOMPLETED_EVENT = new Event("LitigationCompleted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event REPLACEMENTSTARTED_EVENT = new Event("ReplacementStarted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Litigation(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Litigation(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Litigation(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Litigation(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> hub() {
        final Function function = new Function(FUNC_HUB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public List<LitigationInitiatedEventResponse> getLitigationInitiatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LITIGATIONINITIATED_EVENT, transactionReceipt);
        ArrayList<LitigationInitiatedEventResponse> responses = new ArrayList<LitigationInitiatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LitigationInitiatedEventResponse typedResponse = new LitigationInitiatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.requestedObjectIndex = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.requestedBlockIndex = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LitigationInitiatedEventResponse> litigationInitiatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LitigationInitiatedEventResponse>() {
            @Override
            public LitigationInitiatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LITIGATIONINITIATED_EVENT, log);
                LitigationInitiatedEventResponse typedResponse = new LitigationInitiatedEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.requestedObjectIndex = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.requestedBlockIndex = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LitigationInitiatedEventResponse> litigationInitiatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LITIGATIONINITIATED_EVENT));
        return litigationInitiatedEventFlowable(filter);
    }

    public List<LitigationAnsweredEventResponse> getLitigationAnsweredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LITIGATIONANSWERED_EVENT, transactionReceipt);
        ArrayList<LitigationAnsweredEventResponse> responses = new ArrayList<LitigationAnsweredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LitigationAnsweredEventResponse typedResponse = new LitigationAnsweredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LitigationAnsweredEventResponse> litigationAnsweredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LitigationAnsweredEventResponse>() {
            @Override
            public LitigationAnsweredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LITIGATIONANSWERED_EVENT, log);
                LitigationAnsweredEventResponse typedResponse = new LitigationAnsweredEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LitigationAnsweredEventResponse> litigationAnsweredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LITIGATIONANSWERED_EVENT));
        return litigationAnsweredEventFlowable(filter);
    }

    public List<LitigationTimedOutEventResponse> getLitigationTimedOutEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LITIGATIONTIMEDOUT_EVENT, transactionReceipt);
        ArrayList<LitigationTimedOutEventResponse> responses = new ArrayList<LitigationTimedOutEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LitigationTimedOutEventResponse typedResponse = new LitigationTimedOutEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LitigationTimedOutEventResponse> litigationTimedOutEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LitigationTimedOutEventResponse>() {
            @Override
            public LitigationTimedOutEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LITIGATIONTIMEDOUT_EVENT, log);
                LitigationTimedOutEventResponse typedResponse = new LitigationTimedOutEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LitigationTimedOutEventResponse> litigationTimedOutEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LITIGATIONTIMEDOUT_EVENT));
        return litigationTimedOutEventFlowable(filter);
    }

    public List<LitigationCompletedEventResponse> getLitigationCompletedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LITIGATIONCOMPLETED_EVENT, transactionReceipt);
        ArrayList<LitigationCompletedEventResponse> responses = new ArrayList<LitigationCompletedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LitigationCompletedEventResponse typedResponse = new LitigationCompletedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DH_was_penalized = (Boolean) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LitigationCompletedEventResponse> litigationCompletedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LitigationCompletedEventResponse>() {
            @Override
            public LitigationCompletedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LITIGATIONCOMPLETED_EVENT, log);
                LitigationCompletedEventResponse typedResponse = new LitigationCompletedEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DH_was_penalized = (Boolean) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LitigationCompletedEventResponse> litigationCompletedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LITIGATIONCOMPLETED_EVENT));
        return litigationCompletedEventFlowable(filter);
    }

    public List<ReplacementStartedEventResponse> getReplacementStartedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REPLACEMENTSTARTED_EVENT, transactionReceipt);
        ArrayList<ReplacementStartedEventResponse> responses = new ArrayList<ReplacementStartedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReplacementStartedEventResponse typedResponse = new ReplacementStartedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.challengerIdentity = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.litigationRootHash = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReplacementStartedEventResponse> replacementStartedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReplacementStartedEventResponse>() {
            @Override
            public ReplacementStartedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REPLACEMENTSTARTED_EVENT, log);
                ReplacementStartedEventResponse typedResponse = new ReplacementStartedEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.holderIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.challengerIdentity = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.litigationRootHash = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReplacementStartedEventResponse> replacementStartedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REPLACEMENTSTARTED_EVENT));
        return replacementStartedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> setHubAddress(String newHubAddress) {
        final Function function = new Function(
                FUNC_SETHUBADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newHubAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initiateLitigation(byte[] offerId, String holderIdentity, String challengerIdentity, BigInteger requestedObjectIndex, BigInteger requestedBlockIndex, List<byte[]> hashArray) {
        final Function function = new Function(
                FUNC_INITIATELITIGATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.Address(challengerIdentity), 
                new org.web3j.abi.datatypes.generated.Uint256(requestedObjectIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(requestedBlockIndex), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(hashArray, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> answerLitigation(byte[] offerId, String holderIdentity, byte[] requestedData) {
        final Function function = new Function(
                FUNC_ANSWERLITIGATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.generated.Bytes32(requestedData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> completeLitigation(byte[] offerId, String holderIdentity, String litigatorIdentity, byte[] proofData, BigInteger leafIndex) {
        final Function function = new Function(
                FUNC_COMPLETELITIGATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.Address(litigatorIdentity), 
                new org.web3j.abi.datatypes.generated.Bytes32(proofData), 
                new org.web3j.abi.datatypes.generated.Uint256(leafIndex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Litigation load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Litigation(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Litigation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Litigation(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Litigation load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Litigation(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Litigation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Litigation(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Litigation> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Litigation.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Litigation> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Litigation.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Litigation> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Litigation.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Litigation> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Litigation.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LitigationInitiatedEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String holderIdentity;

        public BigInteger requestedObjectIndex;

        public BigInteger requestedBlockIndex;
    }

    public static class LitigationAnsweredEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String holderIdentity;
    }

    public static class LitigationTimedOutEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String holderIdentity;
    }

    public static class LitigationCompletedEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String holderIdentity;

        public Boolean DH_was_penalized;
    }

    public static class ReplacementStartedEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String holderIdentity;

        public String challengerIdentity;

        public byte[] litigationRootHash;
    }
}
