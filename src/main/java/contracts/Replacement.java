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
public class Replacement extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/Replacement.txt");

    public static final String FUNC_HUB = "hub";

    public static final String FUNC_REPLACEHOLDER = "replaceHolder";

    public static final Event REPLACEMENTCOMPLETED_EVENT = new Event("ReplacementCompleted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Replacement(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Replacement(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Replacement(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Replacement(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> hub() {
        final Function function = new Function(FUNC_HUB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public List<ReplacementCompletedEventResponse> getReplacementCompletedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REPLACEMENTCOMPLETED_EVENT, transactionReceipt);
        ArrayList<ReplacementCompletedEventResponse> responses = new ArrayList<ReplacementCompletedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReplacementCompletedEventResponse typedResponse = new ReplacementCompletedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.challengerIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.chosenHolder = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReplacementCompletedEventResponse> replacementCompletedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReplacementCompletedEventResponse>() {
            @Override
            public ReplacementCompletedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REPLACEMENTCOMPLETED_EVENT, log);
                ReplacementCompletedEventResponse typedResponse = new ReplacementCompletedEventResponse();
                typedResponse.log = log;
                typedResponse.offerId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.challengerIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.chosenHolder = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReplacementCompletedEventResponse> replacementCompletedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REPLACEMENTCOMPLETED_EVENT));
        return replacementCompletedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> replaceHolder(byte[] offerId, String holderIdentity, String litigatorIdentity, BigInteger shift, byte[] confirmation1, byte[] confirmation2, byte[] confirmation3, List<String> replacementHolderIdentity) {
        final Function function = new Function(
                FUNC_REPLACEHOLDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(holderIdentity), 
                new org.web3j.abi.datatypes.Address(litigatorIdentity), 
                new org.web3j.abi.datatypes.generated.Uint256(shift), 
                new org.web3j.abi.datatypes.DynamicBytes(confirmation1), 
                new org.web3j.abi.datatypes.DynamicBytes(confirmation2), 
                new org.web3j.abi.datatypes.DynamicBytes(confirmation3), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(replacementHolderIdentity, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Replacement load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Replacement(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Replacement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Replacement(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Replacement load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Replacement(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Replacement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Replacement(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Replacement> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Replacement.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Replacement> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Replacement.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Replacement> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Replacement.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Replacement> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Replacement.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ReplacementCompletedEventResponse extends BaseEventResponse {
        public byte[] offerId;

        public String challengerIdentity;

        public String chosenHolder;
    }
}
