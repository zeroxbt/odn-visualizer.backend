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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
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
import org.web3j.tuples.generated.Tuple6;
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
public class Reading extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/Reading.txt");

    public static final String FUNC_PURCHASED_DATA = "purchased_data";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PURCHASE = "purchase";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETBIDDING = "setBidding";

    public static final String FUNC_ADDREADDATA = "addReadData";

    public static final String FUNC_REMOVEREADDATA = "removeReadData";

    public static final String FUNC_INITIATEPURCHASE = "initiatePurchase";

    public static final String FUNC_SENDCOMMITMENT = "sendCommitment";

    public static final String FUNC_CONFIRMPURCHASE = "confirmPurchase";

    public static final String FUNC_CANCELPURCHASE = "cancelPurchase";

    public static final String FUNC_SENDENCRYPTEDBLOCK = "sendEncryptedBlock";

    public static final String FUNC_PAYOUT = "payOut";

    public static final String FUNC_INITIATEDISPUTE = "initiateDispute";

    public static final String FUNC_SENDPROOFDATA = "sendProofData";

    public static final Event PURCHASEINITIATED_EVENT = new Event("PurchaseInitiated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event COMMITMENTSENT_EVENT = new Event("CommitmentSent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event PURCHASECONFIRMED_EVENT = new Event("PurchaseConfirmed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event PURCHASECANCELLED_EVENT = new Event("PurchaseCancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event ENCRYPTEDBLOCKSENT_EVENT = new Event("EncryptedBlockSent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event PURCHASEDISPUTED_EVENT = new Event("PurchaseDisputed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event PURCHASEDISPUTECOMPLETED_EVENT = new Event("PurchaseDisputeCompleted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event PURCHASEPAYMENT_EVENT = new Event("PurchasePayment", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Reading(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Reading(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Reading(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Reading(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple3<String, byte[], BigInteger>> purchased_data(byte[] param0, String param1) {
        final Function function = new Function(FUNC_PURCHASED_DATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, byte[], BigInteger>>(function,
                new Callable<Tuple3<String, byte[], BigInteger>>() {
                    @Override
                    public Tuple3<String, byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, byte[], BigInteger>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple6<BigInteger, BigInteger, byte[], BigInteger, BigInteger, BigInteger>> purchase(String param0, String param1, byte[] param2) {
        final Function function = new Function(FUNC_PURCHASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1), 
                new org.web3j.abi.datatypes.generated.Bytes32(param2)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple6<BigInteger, BigInteger, byte[], BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple6<BigInteger, BigInteger, byte[], BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple6<BigInteger, BigInteger, byte[], BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<BigInteger, BigInteger, byte[], BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<PurchaseInitiatedEventResponse> getPurchaseInitiatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASEINITIATED_EVENT, transactionReceipt);
        ArrayList<PurchaseInitiatedEventResponse> responses = new ArrayList<PurchaseInitiatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchaseInitiatedEventResponse typedResponse = new PurchaseInitiatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchaseInitiatedEventResponse> purchaseInitiatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PurchaseInitiatedEventResponse>() {
            @Override
            public PurchaseInitiatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASEINITIATED_EVENT, log);
                PurchaseInitiatedEventResponse typedResponse = new PurchaseInitiatedEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PurchaseInitiatedEventResponse> purchaseInitiatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASEINITIATED_EVENT));
        return purchaseInitiatedEventFlowable(filter);
    }

    public List<CommitmentSentEventResponse> getCommitmentSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(COMMITMENTSENT_EVENT, transactionReceipt);
        ArrayList<CommitmentSentEventResponse> responses = new ArrayList<CommitmentSentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CommitmentSentEventResponse typedResponse = new CommitmentSentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CommitmentSentEventResponse> commitmentSentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, CommitmentSentEventResponse>() {
            @Override
            public CommitmentSentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(COMMITMENTSENT_EVENT, log);
                CommitmentSentEventResponse typedResponse = new CommitmentSentEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CommitmentSentEventResponse> commitmentSentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(COMMITMENTSENT_EVENT));
        return commitmentSentEventFlowable(filter);
    }

    public List<PurchaseConfirmedEventResponse> getPurchaseConfirmedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASECONFIRMED_EVENT, transactionReceipt);
        ArrayList<PurchaseConfirmedEventResponse> responses = new ArrayList<PurchaseConfirmedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchaseConfirmedEventResponse typedResponse = new PurchaseConfirmedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchaseConfirmedEventResponse> purchaseConfirmedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PurchaseConfirmedEventResponse>() {
            @Override
            public PurchaseConfirmedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASECONFIRMED_EVENT, log);
                PurchaseConfirmedEventResponse typedResponse = new PurchaseConfirmedEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PurchaseConfirmedEventResponse> purchaseConfirmedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASECONFIRMED_EVENT));
        return purchaseConfirmedEventFlowable(filter);
    }

    public List<PurchaseCancelledEventResponse> getPurchaseCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASECANCELLED_EVENT, transactionReceipt);
        ArrayList<PurchaseCancelledEventResponse> responses = new ArrayList<PurchaseCancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchaseCancelledEventResponse typedResponse = new PurchaseCancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchaseCancelledEventResponse> purchaseCancelledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PurchaseCancelledEventResponse>() {
            @Override
            public PurchaseCancelledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASECANCELLED_EVENT, log);
                PurchaseCancelledEventResponse typedResponse = new PurchaseCancelledEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PurchaseCancelledEventResponse> purchaseCancelledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASECANCELLED_EVENT));
        return purchaseCancelledEventFlowable(filter);
    }

    public List<EncryptedBlockSentEventResponse> getEncryptedBlockSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ENCRYPTEDBLOCKSENT_EVENT, transactionReceipt);
        ArrayList<EncryptedBlockSentEventResponse> responses = new ArrayList<EncryptedBlockSentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EncryptedBlockSentEventResponse typedResponse = new EncryptedBlockSentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EncryptedBlockSentEventResponse> encryptedBlockSentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, EncryptedBlockSentEventResponse>() {
            @Override
            public EncryptedBlockSentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ENCRYPTEDBLOCKSENT_EVENT, log);
                EncryptedBlockSentEventResponse typedResponse = new EncryptedBlockSentEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EncryptedBlockSentEventResponse> encryptedBlockSentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ENCRYPTEDBLOCKSENT_EVENT));
        return encryptedBlockSentEventFlowable(filter);
    }

    public List<PurchaseDisputedEventResponse> getPurchaseDisputedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASEDISPUTED_EVENT, transactionReceipt);
        ArrayList<PurchaseDisputedEventResponse> responses = new ArrayList<PurchaseDisputedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchaseDisputedEventResponse typedResponse = new PurchaseDisputedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchaseDisputedEventResponse> purchaseDisputedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PurchaseDisputedEventResponse>() {
            @Override
            public PurchaseDisputedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASEDISPUTED_EVENT, log);
                PurchaseDisputedEventResponse typedResponse = new PurchaseDisputedEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PurchaseDisputedEventResponse> purchaseDisputedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASEDISPUTED_EVENT));
        return purchaseDisputedEventFlowable(filter);
    }

    public List<PurchaseDisputeCompletedEventResponse> getPurchaseDisputeCompletedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASEDISPUTECOMPLETED_EVENT, transactionReceipt);
        ArrayList<PurchaseDisputeCompletedEventResponse> responses = new ArrayList<PurchaseDisputeCompletedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchaseDisputeCompletedEventResponse typedResponse = new PurchaseDisputeCompletedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.proof_was_correct = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchaseDisputeCompletedEventResponse> purchaseDisputeCompletedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PurchaseDisputeCompletedEventResponse>() {
            @Override
            public PurchaseDisputeCompletedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASEDISPUTECOMPLETED_EVENT, log);
                PurchaseDisputeCompletedEventResponse typedResponse = new PurchaseDisputeCompletedEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.proof_was_correct = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PurchaseDisputeCompletedEventResponse> purchaseDisputeCompletedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASEDISPUTECOMPLETED_EVENT));
        return purchaseDisputeCompletedEventFlowable(filter);
    }

    public List<PurchasePaymentEventResponse> getPurchasePaymentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PURCHASEPAYMENT_EVENT, transactionReceipt);
        ArrayList<PurchasePaymentEventResponse> responses = new ArrayList<PurchasePaymentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PurchasePaymentEventResponse typedResponse = new PurchasePaymentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PurchasePaymentEventResponse> purchasePaymentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, PurchasePaymentEventResponse>() {
            @Override
            public PurchasePaymentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PURCHASEPAYMENT_EVENT, log);
                PurchasePaymentEventResponse typedResponse = new PurchasePaymentEventResponse();
                typedResponse.log = log;
                typedResponse.import_id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.DH_wallet = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.DV_wallet = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PurchasePaymentEventResponse> purchasePaymentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PURCHASEPAYMENT_EVENT));
        return purchasePaymentEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> setBidding(String bidding_address) {
        final Function function = new Function(
                FUNC_SETBIDDING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(bidding_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addReadData(byte[] import_id, String DH_wallet, String DC_wallet, byte[] distribution_root_hash, BigInteger checksum) {
        final Function function = new Function(
                FUNC_ADDREADDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DH_wallet), 
                new org.web3j.abi.datatypes.Address(DC_wallet), 
                new org.web3j.abi.datatypes.generated.Bytes32(distribution_root_hash), 
                new org.web3j.abi.datatypes.generated.Uint256(checksum)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> removeReadData(byte[] import_id, String DH_wallet) {
        final Function function = new Function(
                FUNC_REMOVEREADDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DH_wallet)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initiatePurchase(byte[] import_id, String DH_wallet, BigInteger token_amount, BigInteger stake_factor) {
        final Function function = new Function(
                FUNC_INITIATEPURCHASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DH_wallet), 
                new org.web3j.abi.datatypes.generated.Uint256(token_amount), 
                new org.web3j.abi.datatypes.generated.Uint256(stake_factor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendCommitment(byte[] import_id, String DV_wallet, byte[] commitment) {
        final Function function = new Function(
                FUNC_SENDCOMMITMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DV_wallet), 
                new org.web3j.abi.datatypes.generated.Bytes32(commitment)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> confirmPurchase(byte[] import_id, String DH_wallet) {
        final Function function = new Function(
                FUNC_CONFIRMPURCHASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DH_wallet)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelPurchase(byte[] import_id, String correspondent_wallet, Boolean sender_is_DH) {
        final Function function = new Function(
                FUNC_CANCELPURCHASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(correspondent_wallet), 
                new org.web3j.abi.datatypes.Bool(sender_is_DH)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendEncryptedBlock(byte[] import_id, String DV_wallet, BigInteger encrypted_block) {
        final Function function = new Function(
                FUNC_SENDENCRYPTEDBLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DV_wallet), 
                new org.web3j.abi.datatypes.generated.Uint256(encrypted_block)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> payOut(byte[] import_id, String DV_wallet) {
        final Function function = new Function(
                FUNC_PAYOUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DV_wallet)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initiateDispute(byte[] import_id, String DH_wallet) {
        final Function function = new Function(
                FUNC_INITIATEDISPUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DH_wallet)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sendProofData(byte[] import_id, String DV_wallet, BigInteger checksum_left, BigInteger checksum_right, byte[] checksum_hash, BigInteger random_number_1, BigInteger random_number_2, BigInteger decryption_key, BigInteger block_index) {
        final Function function = new Function(
                FUNC_SENDPROOFDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(import_id), 
                new org.web3j.abi.datatypes.Address(DV_wallet), 
                new org.web3j.abi.datatypes.generated.Uint256(checksum_left), 
                new org.web3j.abi.datatypes.generated.Uint256(checksum_right), 
                new org.web3j.abi.datatypes.generated.Bytes32(checksum_hash), 
                new org.web3j.abi.datatypes.generated.Uint256(random_number_1), 
                new org.web3j.abi.datatypes.generated.Uint256(random_number_2), 
                new org.web3j.abi.datatypes.generated.Uint256(decryption_key), 
                new org.web3j.abi.datatypes.generated.Uint256(block_index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Reading load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Reading(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Reading load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Reading(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Reading load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Reading(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Reading load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Reading(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Reading> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String escrow_address) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(escrow_address)));
        return deployRemoteCall(Reading.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Reading> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String escrow_address) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(escrow_address)));
        return deployRemoteCall(Reading.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Reading> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String escrow_address) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(escrow_address)));
        return deployRemoteCall(Reading.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Reading> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String escrow_address) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(escrow_address)));
        return deployRemoteCall(Reading.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class PurchaseInitiatedEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;
    }

    public static class CommitmentSentEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;
    }

    public static class PurchaseConfirmedEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;
    }

    public static class PurchaseCancelledEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;
    }

    public static class EncryptedBlockSentEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;
    }

    public static class PurchaseDisputedEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;
    }

    public static class PurchaseDisputeCompletedEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;

        public Boolean proof_was_correct;
    }

    public static class PurchasePaymentEventResponse extends BaseEventResponse {
        public byte[] import_id;

        public String DH_wallet;

        public String DV_wallet;

        public BigInteger amount;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
