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
import org.web3j.abi.datatypes.generated.Bytes20;
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
public class Profile extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/Profile.txt");

    public static final String FUNC_HUB = "hub";

    public static final String FUNC_WITHDRAWALTIME = "withdrawalTime";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_MINIMALSTAKE = "minimalStake";

    public static final String FUNC_CREATEPROFILE = "createProfile";

    public static final String FUNC_TRANSFERPROFILE = "transferProfile";

    public static final String FUNC_DEPOSITTOKENS = "depositTokens";

    public static final String FUNC_STARTTOKENWITHDRAWAL = "startTokenWithdrawal";

    public static final String FUNC_WITHDRAWTOKENS = "withdrawTokens";

    public static final String FUNC_SETNODEID = "setNodeId";

    public static final String FUNC_RELEASETOKENS = "releaseTokens";

    public static final String FUNC_TRANSFERTOKENS = "transferTokens";

    public static final String FUNC_SETMINIMALSTAKE = "setMinimalStake";

    public static final String FUNC_SETWITHDRAWALTIME = "setWithdrawalTime";

    public static final Event PROFILECREATED_EVENT = new Event("ProfileCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event IDENTITYCREATED_EVENT = new Event("IdentityCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event IDENTITYTRANSFERRED_EVENT = new Event("IdentityTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes20>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event TOKENDEPOSIT_EVENT = new Event("TokenDeposit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENSDEPOSITED_EVENT = new Event("TokensDeposited", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENSRESERVED_EVENT = new Event("TokensReserved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WITHDRAWALINITIATED_EVENT = new Event("WithdrawalInitiated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENWITHDRAWALCANCELLED_EVENT = new Event("TokenWithdrawalCancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event TOKENSWITHDRAWN_EVENT = new Event("TokensWithdrawn", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENSRELEASED_EVENT = new Event("TokensReleased", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENSTRANSFERRED_EVENT = new Event("TokensTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Profile(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Profile(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Profile(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Profile(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> hub() {
        final Function function = new Function(FUNC_HUB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> withdrawalTime() {
        final Function function = new Function(FUNC_WITHDRAWALTIME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> minimalStake() {
        final Function function = new Function(FUNC_MINIMALSTAKE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public List<ProfileCreatedEventResponse> getProfileCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROFILECREATED_EVENT, transactionReceipt);
        ArrayList<ProfileCreatedEventResponse> responses = new ArrayList<ProfileCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProfileCreatedEventResponse typedResponse = new ProfileCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.initialBalance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProfileCreatedEventResponse> profileCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ProfileCreatedEventResponse>() {
            @Override
            public ProfileCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROFILECREATED_EVENT, log);
                ProfileCreatedEventResponse typedResponse = new ProfileCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.initialBalance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProfileCreatedEventResponse> profileCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROFILECREATED_EVENT));
        return profileCreatedEventFlowable(filter);
    }

    public List<IdentityCreatedEventResponse> getIdentityCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(IDENTITYCREATED_EVENT, transactionReceipt);
        ArrayList<IdentityCreatedEventResponse> responses = new ArrayList<IdentityCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            IdentityCreatedEventResponse typedResponse = new IdentityCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<IdentityCreatedEventResponse> identityCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, IdentityCreatedEventResponse>() {
            @Override
            public IdentityCreatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(IDENTITYCREATED_EVENT, log);
                IdentityCreatedEventResponse typedResponse = new IdentityCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<IdentityCreatedEventResponse> identityCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(IDENTITYCREATED_EVENT));
        return identityCreatedEventFlowable(filter);
    }

    public List<IdentityTransferredEventResponse> getIdentityTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(IDENTITYTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<IdentityTransferredEventResponse> responses = new ArrayList<IdentityTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            IdentityTransferredEventResponse typedResponse = new IdentityTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.nodeId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.oldIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.newIdentity = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<IdentityTransferredEventResponse> identityTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, IdentityTransferredEventResponse>() {
            @Override
            public IdentityTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(IDENTITYTRANSFERRED_EVENT, log);
                IdentityTransferredEventResponse typedResponse = new IdentityTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.nodeId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.oldIdentity = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.newIdentity = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<IdentityTransferredEventResponse> identityTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(IDENTITYTRANSFERRED_EVENT));
        return identityTransferredEventFlowable(filter);
    }

    public List<TokenDepositEventResponse> getTokenDepositEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENDEPOSIT_EVENT, transactionReceipt);
        ArrayList<TokenDepositEventResponse> responses = new ArrayList<TokenDepositEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokenDepositEventResponse typedResponse = new TokenDepositEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokenDepositEventResponse> tokenDepositEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokenDepositEventResponse>() {
            @Override
            public TokenDepositEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENDEPOSIT_EVENT, log);
                TokenDepositEventResponse typedResponse = new TokenDepositEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokenDepositEventResponse> tokenDepositEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENDEPOSIT_EVENT));
        return tokenDepositEventFlowable(filter);
    }

    public List<TokensDepositedEventResponse> getTokensDepositedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENSDEPOSITED_EVENT, transactionReceipt);
        ArrayList<TokensDepositedEventResponse> responses = new ArrayList<TokensDepositedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensDepositedEventResponse typedResponse = new TokensDepositedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amountDeposited = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokensDepositedEventResponse> tokensDepositedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokensDepositedEventResponse>() {
            @Override
            public TokensDepositedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENSDEPOSITED_EVENT, log);
                TokensDepositedEventResponse typedResponse = new TokensDepositedEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amountDeposited = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokensDepositedEventResponse> tokensDepositedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSDEPOSITED_EVENT));
        return tokensDepositedEventFlowable(filter);
    }

    public List<TokensReservedEventResponse> getTokensReservedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENSRESERVED_EVENT, transactionReceipt);
        ArrayList<TokensReservedEventResponse> responses = new ArrayList<TokensReservedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensReservedEventResponse typedResponse = new TokensReservedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amountReserved = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokensReservedEventResponse> tokensReservedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokensReservedEventResponse>() {
            @Override
            public TokensReservedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENSRESERVED_EVENT, log);
                TokensReservedEventResponse typedResponse = new TokensReservedEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amountReserved = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokensReservedEventResponse> tokensReservedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSRESERVED_EVENT));
        return tokensReservedEventFlowable(filter);
    }

    public List<WithdrawalInitiatedEventResponse> getWithdrawalInitiatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAWALINITIATED_EVENT, transactionReceipt);
        ArrayList<WithdrawalInitiatedEventResponse> responses = new ArrayList<WithdrawalInitiatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawalInitiatedEventResponse typedResponse = new WithdrawalInitiatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.withdrawalDelayInSeconds = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WithdrawalInitiatedEventResponse> withdrawalInitiatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, WithdrawalInitiatedEventResponse>() {
            @Override
            public WithdrawalInitiatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAWALINITIATED_EVENT, log);
                WithdrawalInitiatedEventResponse typedResponse = new WithdrawalInitiatedEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.withdrawalDelayInSeconds = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WithdrawalInitiatedEventResponse> withdrawalInitiatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWALINITIATED_EVENT));
        return withdrawalInitiatedEventFlowable(filter);
    }

    public List<TokenWithdrawalCancelledEventResponse> getTokenWithdrawalCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENWITHDRAWALCANCELLED_EVENT, transactionReceipt);
        ArrayList<TokenWithdrawalCancelledEventResponse> responses = new ArrayList<TokenWithdrawalCancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokenWithdrawalCancelledEventResponse typedResponse = new TokenWithdrawalCancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokenWithdrawalCancelledEventResponse> tokenWithdrawalCancelledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokenWithdrawalCancelledEventResponse>() {
            @Override
            public TokenWithdrawalCancelledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENWITHDRAWALCANCELLED_EVENT, log);
                TokenWithdrawalCancelledEventResponse typedResponse = new TokenWithdrawalCancelledEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokenWithdrawalCancelledEventResponse> tokenWithdrawalCancelledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENWITHDRAWALCANCELLED_EVENT));
        return tokenWithdrawalCancelledEventFlowable(filter);
    }

    public List<TokensWithdrawnEventResponse> getTokensWithdrawnEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENSWITHDRAWN_EVENT, transactionReceipt);
        ArrayList<TokensWithdrawnEventResponse> responses = new ArrayList<TokensWithdrawnEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensWithdrawnEventResponse typedResponse = new TokensWithdrawnEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amountWithdrawn = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokensWithdrawnEventResponse> tokensWithdrawnEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokensWithdrawnEventResponse>() {
            @Override
            public TokensWithdrawnEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENSWITHDRAWN_EVENT, log);
                TokensWithdrawnEventResponse typedResponse = new TokensWithdrawnEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amountWithdrawn = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokensWithdrawnEventResponse> tokensWithdrawnEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSWITHDRAWN_EVENT));
        return tokensWithdrawnEventFlowable(filter);
    }

    public List<TokensReleasedEventResponse> getTokensReleasedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENSRELEASED_EVENT, transactionReceipt);
        ArrayList<TokensReleasedEventResponse> responses = new ArrayList<TokensReleasedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensReleasedEventResponse typedResponse = new TokensReleasedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokensReleasedEventResponse> tokensReleasedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokensReleasedEventResponse>() {
            @Override
            public TokensReleasedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENSRELEASED_EVENT, log);
                TokensReleasedEventResponse typedResponse = new TokensReleasedEventResponse();
                typedResponse.log = log;
                typedResponse.profile = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokensReleasedEventResponse> tokensReleasedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSRELEASED_EVENT));
        return tokensReleasedEventFlowable(filter);
    }

    public List<TokensTransferredEventResponse> getTokensTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENSTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<TokensTransferredEventResponse> responses = new ArrayList<TokensTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensTransferredEventResponse typedResponse = new TokensTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokensTransferredEventResponse> tokensTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokensTransferredEventResponse>() {
            @Override
            public TokensTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENSTRANSFERRED_EVENT, log);
                TokensTransferredEventResponse typedResponse = new TokensTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.receiver = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokensTransferredEventResponse> tokensTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSTRANSFERRED_EVENT));
        return tokensTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> createProfile(String managementWallet, byte[] profileNodeId, BigInteger initialBalance, Boolean senderHas725, String identity) {
        final Function function = new Function(
                FUNC_CREATEPROFILE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(managementWallet), 
                new org.web3j.abi.datatypes.generated.Bytes32(profileNodeId), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance), 
                new org.web3j.abi.datatypes.Bool(senderHas725), 
                new org.web3j.abi.datatypes.Address(identity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferProfile(String oldIdentity, String managementWallet) {
        final Function function = new Function(
                FUNC_TRANSFERPROFILE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(oldIdentity), 
                new org.web3j.abi.datatypes.Address(managementWallet)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> depositTokens(String identity, BigInteger amount) {
        final Function function = new Function(
                FUNC_DEPOSITTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> startTokenWithdrawal(String identity, BigInteger amount) {
        final Function function = new Function(
                FUNC_STARTTOKENWITHDRAWAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawTokens(String identity) {
        final Function function = new Function(
                FUNC_WITHDRAWTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setNodeId(String identity, byte[] newNodeId) {
        final Function function = new Function(
                FUNC_SETNODEID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Bytes32(newNodeId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> releaseTokens(String profile, BigInteger amount) {
        final Function function = new Function(
                FUNC_RELEASETOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(profile), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferTokens(String sender, String receiver, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFERTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(sender), 
                new org.web3j.abi.datatypes.Address(receiver), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setMinimalStake(BigInteger newMinimalStake) {
        final Function function = new Function(
                FUNC_SETMINIMALSTAKE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newMinimalStake)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setWithdrawalTime(BigInteger newWithdrawalTime) {
        final Function function = new Function(
                FUNC_SETWITHDRAWALTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newWithdrawalTime)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Profile load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Profile(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Profile load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Profile(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Profile load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Profile(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Profile load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Profile(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Profile> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Profile.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Profile> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Profile.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Profile> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Profile.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Profile> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(Profile.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class ProfileCreatedEventResponse extends BaseEventResponse {
        public String profile;

        public BigInteger initialBalance;
    }

    public static class IdentityCreatedEventResponse extends BaseEventResponse {
        public String profile;

        public String newIdentity;
    }

    public static class IdentityTransferredEventResponse extends BaseEventResponse {
        public byte[] nodeId;

        public String oldIdentity;

        public String newIdentity;
    }

    public static class TokenDepositEventResponse extends BaseEventResponse {
        public String profile;

        public BigInteger amount;
    }

    public static class TokensDepositedEventResponse extends BaseEventResponse {
        public String profile;

        public BigInteger amountDeposited;

        public BigInteger newBalance;
    }

    public static class TokensReservedEventResponse extends BaseEventResponse {
        public String profile;

        public BigInteger amountReserved;
    }

    public static class WithdrawalInitiatedEventResponse extends BaseEventResponse {
        public String profile;

        public BigInteger amount;

        public BigInteger withdrawalDelayInSeconds;
    }

    public static class TokenWithdrawalCancelledEventResponse extends BaseEventResponse {
        public String profile;
    }

    public static class TokensWithdrawnEventResponse extends BaseEventResponse {
        public String profile;

        public BigInteger amountWithdrawn;

        public BigInteger newBalance;
    }

    public static class TokensReleasedEventResponse extends BaseEventResponse {
        public String profile;

        public BigInteger amount;
    }

    public static class TokensTransferredEventResponse extends BaseEventResponse {
        public String sender;

        public String receiver;

        public BigInteger amount;
    }
}
