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
public class Holding extends Contract {
    public static String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/Holding.txt");

    public static final String FUNC_HUB = "hub";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_DIFFICULTYOVERRIDE = "difficultyOverride";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETHUBADDRESS = "setHubAddress";

    public static final String FUNC_CREATEOFFER = "createOffer";

    public static final String FUNC_FINALIZEOFFER = "finalizeOffer";

    public static final String FUNC_PAYOUT = "payOut";

    public static final Event OFFERTASK_EVENT = new Event("OfferTask", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event OFFERCREATED_EVENT = new Event("OfferCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OFFERFINALIZED_EVENT = new Event("OfferFinalized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event PAIDOUT_EVENT = new Event("PaidOut", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Holding(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Holding(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Holding(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Holding(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> hub() {
        final Function function = new Function(FUNC_HUB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> difficultyOverride() {
        final Function function = new Function(FUNC_DIFFICULTYOVERRIDE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<OfferTaskEventResponse> getOfferTaskEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OFFERTASK_EVENT, transactionReceipt);
        ArrayList<OfferTaskEventResponse> responses = new ArrayList<OfferTaskEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OfferTaskEventResponse typedResponse = new OfferTaskEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.dataSetId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.dcNodeId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.task = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OfferTaskEventResponse> offerTaskEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OfferTaskEventResponse>() {
            @Override
            public OfferTaskEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OFFERTASK_EVENT, log);
                OfferTaskEventResponse typedResponse = new OfferTaskEventResponse();
                typedResponse.log = log;
                typedResponse.dataSetId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.dcNodeId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.task = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OfferTaskEventResponse> offerTaskEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OFFERTASK_EVENT));
        return offerTaskEventFlowable(filter);
    }

    public List<OfferCreatedEventResponse> getOfferCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OFFERCREATED_EVENT, transactionReceipt);
        ArrayList<OfferCreatedEventResponse> responses = new ArrayList<OfferCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OfferCreatedEventResponse typedResponse = new OfferCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.dataSetId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.dcNodeId = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.holdingTimeInMinutes = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.dataSetSizeInBytes = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.tokenAmountPerHolder = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.litigationIntervalInMinutes = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OfferCreatedEventResponse> offerCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OfferCreatedEventResponse>() {
            @Override
            public OfferCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OFFERCREATED_EVENT, log);
                OfferCreatedEventResponse typedResponse = new OfferCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.dataSetId = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.dcNodeId = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.holdingTimeInMinutes = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.dataSetSizeInBytes = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.tokenAmountPerHolder = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.litigationIntervalInMinutes = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OfferCreatedEventResponse> offerCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OFFERCREATED_EVENT));
        return offerCreatedEventFlowable(filter);
    }

    public List<OfferFinalizedEventResponse> getOfferFinalizedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OFFERFINALIZED_EVENT, transactionReceipt);
        ArrayList<OfferFinalizedEventResponse> responses = new ArrayList<OfferFinalizedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OfferFinalizedEventResponse typedResponse = new OfferFinalizedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.holder1 = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.holder2 = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.holder3 = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OfferFinalizedEventResponse> offerFinalizedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OfferFinalizedEventResponse>() {
            @Override
            public OfferFinalizedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OFFERFINALIZED_EVENT, log);
                OfferFinalizedEventResponse typedResponse = new OfferFinalizedEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.holder1 = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.holder2 = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.holder3 = (String) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OfferFinalizedEventResponse> offerFinalizedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OFFERFINALIZED_EVENT));
        return offerFinalizedEventFlowable(filter);
    }

    public List<PaidOutEventResponse> getPaidOutEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAIDOUT_EVENT, transactionReceipt);
        ArrayList<PaidOutEventResponse> responses = new ArrayList<PaidOutEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PaidOutEventResponse typedResponse = new PaidOutEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.holder = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PaidOutEventResponse> paidOutEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PaidOutEventResponse>() {
            @Override
            public PaidOutEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAIDOUT_EVENT, log);
                PaidOutEventResponse typedResponse = new PaidOutEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.holder = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PaidOutEventResponse> paidOutEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAIDOUT_EVENT));
        return paidOutEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> setHubAddress(String newHubAddress) {
        final Function function = new Function(
                FUNC_SETHUBADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newHubAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createOffer(String identity, BigInteger dataSetId, BigInteger dataRootHash, BigInteger redLitigationHash, BigInteger greenLitigationHash, BigInteger blueLitigationHash, BigInteger dcNodeId, BigInteger holdingTimeInMinutes, BigInteger tokenAmountPerHolder, BigInteger dataSetSizeInBytes, BigInteger litigationIntervalInMinutes) {
        final Function function = new Function(
                FUNC_CREATEOFFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(dataSetId), 
                new org.web3j.abi.datatypes.generated.Uint256(dataRootHash), 
                new org.web3j.abi.datatypes.generated.Uint256(redLitigationHash), 
                new org.web3j.abi.datatypes.generated.Uint256(greenLitigationHash), 
                new org.web3j.abi.datatypes.generated.Uint256(blueLitigationHash), 
                new org.web3j.abi.datatypes.generated.Uint256(dcNodeId), 
                new org.web3j.abi.datatypes.generated.Uint256(holdingTimeInMinutes), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenAmountPerHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(dataSetSizeInBytes), 
                new org.web3j.abi.datatypes.generated.Uint256(litigationIntervalInMinutes)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> finalizeOffer(String identity, BigInteger offerId, BigInteger shift, byte[] confirmation1, byte[] confirmation2, byte[] confirmation3, List<BigInteger> encryptionType, List<String> holderIdentity, String parentIdentity) {
        final Function function = new Function(
                FUNC_FINALIZEOFFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(offerId), 
                new org.web3j.abi.datatypes.generated.Uint256(shift), 
                new org.web3j.abi.datatypes.DynamicBytes(confirmation1), 
                new org.web3j.abi.datatypes.DynamicBytes(confirmation2), 
                new org.web3j.abi.datatypes.DynamicBytes(confirmation3), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint8>(
                        org.web3j.abi.datatypes.generated.Uint8.class,
                        org.web3j.abi.Utils.typeMap(encryptionType, org.web3j.abi.datatypes.generated.Uint8.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(holderIdentity, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.Address(parentIdentity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> payOut(String identity, BigInteger offerId) {
        final Function function = new Function(
                FUNC_PAYOUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(offerId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Holding load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Holding(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Holding load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Holding(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Holding load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Holding(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Holding load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Holding(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Holding> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Holding.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Holding> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Holding.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Holding> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Holding.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Holding> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Holding.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class OfferTaskEventResponse extends BaseEventResponse {
        public byte[] dataSetId;

        public byte[] dcNodeId;

        public byte[] offerId;

        public byte[] task;
    }

    public static class OfferCreatedEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public byte[] dataSetId;

        public byte[] dcNodeId;

        public BigInteger holdingTimeInMinutes;

        public BigInteger dataSetSizeInBytes;

        public BigInteger tokenAmountPerHolder;

        public BigInteger litigationIntervalInMinutes;
    }

    public static class OfferFinalizedEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String holder1;

        public String holder2;

        public String holder3;
    }

    public static class PaidOutEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String holder;

        public BigInteger amount;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
