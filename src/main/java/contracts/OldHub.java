package contracts;

import database.models.SmartContract;
import io.reactivex.Flowable;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import util.BinLoader;

import static util.Decoder.*;
import static util.Encoder.keccak256;

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
public class OldHub extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/OldHub.txt");

    public static final String FUNC_READINGSTORAGEADDRESS = "readingStorageAddress";

    public static final String FUNC_READINGADDRESS = "readingAddress";

    public static final String FUNC_PROFILEADDRESS = "profileAddress";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TOKENADDRESS = "tokenAddress";

    public static final String FUNC_HOLDINGSTORAGEADDRESS = "holdingStorageAddress";

    public static final String FUNC_HOLDINGADDRESS = "holdingAddress";

    public static final String FUNC_APPROVALADDRESS = "approvalAddress";

    public static final String FUNC_PROFILESTORAGEADDRESS = "profileStorageAddress";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETTOKENADDRESS = "setTokenAddress";

    public static final String FUNC_SETPROFILEADDRESS = "setProfileAddress";

    public static final String FUNC_SETHOLDINGADDRESS = "setHoldingAddress";

    public static final String FUNC_SETREADINGADDRESS = "setReadingAddress";

    public static final String FUNC_SETAPPROVALADDRESS = "setApprovalAddress";

    public static final String FUNC_SETPROFILESTORAGEADDRESS = "setProfileStorageAddress";

    public static final String FUNC_SETHOLDINGSTORAGEADDRESS = "setHoldingStorageAddress";

    public static final String FUNC_SETREADINGSTORAGEADDRESS = "setReadingStorageAddress";

    public static final String FUNC_ISCONTRACT = "isContract";

    public static final Event CONTRACTSCHANGED_EVENT = new Event("ContractsChanged",
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {
            }, new TypeReference<Address>(true) {
            }));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected OldHub(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected OldHub(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected OldHub(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected OldHub(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> readingStorageAddress() {
        final Function function = new Function(FUNC_READINGSTORAGEADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> readingAddress() {
        final Function function = new Function(FUNC_READINGADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> profileAddress() {
        final Function function = new Function(FUNC_PROFILEADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenAddress() {
        final Function function = new Function(FUNC_TOKENADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> holdingStorageAddress() {
        final Function function = new Function(FUNC_HOLDINGSTORAGEADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> holdingAddress() {
        final Function function = new Function(FUNC_HOLDINGADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> approvalAddress() {
        final Function function = new Function(FUNC_APPROVALADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> profileStorageAddress() {
        final Function function = new Function(FUNC_PROFILESTORAGEADDRESS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ContractsChangedEventResponse> getContractsChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONTRACTSCHANGED_EVENT, transactionReceipt);
        ArrayList<ContractsChangedEventResponse> responses = new ArrayList<ContractsChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContractsChangedEventResponse typedResponse = new ContractsChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ContractsChangedEventResponse> contractsChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ContractsChangedEventResponse>() {
            @Override
            public ContractsChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONTRACTSCHANGED_EVENT, log);
                ContractsChangedEventResponse typedResponse = new ContractsChangedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<ContractsChangedEventResponse> contractsChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTRACTSCHANGED_EVENT));
        return contractsChangedEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> setTokenAddress(String newTokenAddress) {
        final Function function = new Function(
                FUNC_SETTOKENADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newTokenAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setProfileAddress(String newProfileAddress) {
        final Function function = new Function(
                FUNC_SETPROFILEADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newProfileAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setHoldingAddress(String newHoldingAddress) {
        final Function function = new Function(
                FUNC_SETHOLDINGADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newHoldingAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setReadingAddress(String newReadingAddress) {
        final Function function = new Function(
                FUNC_SETREADINGADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newReadingAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalAddress(String newApprovalAddress) {
        final Function function = new Function(
                FUNC_SETAPPROVALADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newApprovalAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setProfileStorageAddress(String newpPofileStorageAddress) {
        final Function function = new Function(
                FUNC_SETPROFILESTORAGEADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newpPofileStorageAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setHoldingStorageAddress(String newHoldingStorageAddress) {
        final Function function = new Function(
                FUNC_SETHOLDINGSTORAGEADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newHoldingStorageAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setReadingStorageAddress(String newReadingStorageAddress) {
        final Function function = new Function(
                FUNC_SETREADINGSTORAGEADDRESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newReadingStorageAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isContract(String sender) {
        final Function function = new Function(FUNC_ISCONTRACT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
                }));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static OldHub load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new OldHub(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static OldHub load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new OldHub(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static OldHub load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new OldHub(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static OldHub load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new OldHub(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<OldHub> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(OldHub.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<OldHub> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(OldHub.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<OldHub> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(OldHub.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<OldHub> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(OldHub.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ContractsChangedEventResponse extends BaseEventResponse {
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    private static String decodeFunction(String hashedDeclaration) {
        String contractName = "";
        if (keccak256("setApprovalAddress(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "Approval";
        } else if (keccak256("setHoldingAddress(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "Holding";
        } else if (keccak256("setHoldingStorageAddress(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "HoldingStorage";
        } else if (keccak256("setIdentity(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "Identity";
        } else if (keccak256("setProfileAddress(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "Profile";
        } else if (keccak256("setProfileStorageAddress(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "ProfileStorage";
        } else if (keccak256("setReadingAddress(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "Reading";
        } else if (keccak256("setTokenAddress(address)").substring(0, FUNCTION_NAME_HEX).equals(hashedDeclaration)) {
            contractName = "TracToken";
        }
        return contractName;
    }

    public static void loadHubAndContracts(Connection connection, String contractAddress, Web3j web3, Credentials credentials) throws IOException {
        OldHub ethOldHub = OldHub.load(contractAddress, web3, credentials, new DefaultGasProvider());
        int chainId = web3.ethChainId().send().getChainId().intValue();
        ethOldHub.contractsChangedEventFlowable(new DefaultBlockParameterNumber(6649189), new DefaultBlockParameterNumber(9161133)).subscribe(
                response -> {
                    Transaction transaction = web3.ethGetTransactionByHash(response.log.getTransactionHash()).send().getTransaction().get();
                    String inputData = transaction.getInput();

                    SmartContract smartContract = new SmartContract(
                            decodeFunction(getFunction(inputData)),
                            decodeAddress(getArgs(inputData, 0)),
                            chainId,
                            transaction.getBlockNumber(),
                            new BigInteger("-1")
                    );

                    SmartContract.insertIfNotExist(connection, smartContract);
                    SmartContract.updateExpirationBlock(connection, smartContract, transaction.getBlockNumber());
                }
        );
    }
}
