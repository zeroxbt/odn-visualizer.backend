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
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
import org.web3j.tuples.generated.Tuple4;
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
public class HoldingStorage extends Contract {
    public static final String BINARY = BinLoader.loadBinary("blockchain/ethereum/bin/HoldingStorage.txt");

    public static final String FUNC_HUB = "hub";

    public static final String FUNC_DIFFICULTYOVERRIDE = "difficultyOverride";

    public static final String FUNC_FINGERPRINT = "fingerprint";

    public static final String FUNC_HOLDER = "holder";

    public static final String FUNC_OFFER = "offer";

    public static final String FUNC_GETDIFFICULTYOVERRIDE = "getDifficultyOverride";

    public static final String FUNC_SETDIFFICULTYOVERRIDE = "setDifficultyOverride";

    public static final String FUNC_SETFINGERPRINT = "setFingerprint";

    public static final String FUNC_GETOFFERCREATOR = "getOfferCreator";

    public static final String FUNC_GETOFFERDATASETID = "getOfferDataSetId";

    public static final String FUNC_GETOFFERHOLDINGTIMEINMINUTES = "getOfferHoldingTimeInMinutes";

    public static final String FUNC_GETOFFERTOKENAMOUNTPERHOLDER = "getOfferTokenAmountPerHolder";

    public static final String FUNC_GETOFFERLITIGATIONINTERVALINMINUTES = "getOfferLitigationIntervalInMinutes";

    public static final String FUNC_GETOFFERTASK = "getOfferTask";

    public static final String FUNC_GETOFFERDIFFICULTY = "getOfferDifficulty";

    public static final String FUNC_GETOFFERREDLITIGATIONHASH = "getOfferRedLitigationHash";

    public static final String FUNC_GETOFFERGREENLITIGATIONHASH = "getOfferGreenLitigationHash";

    public static final String FUNC_GETOFFERBLUELITIGATIONHASH = "getOfferBlueLitigationHash";

    public static final String FUNC_GETOFFERSTARTTIME = "getOfferStartTime";

    public static final String FUNC_SETOFFERCREATOR = "setOfferCreator";

    public static final String FUNC_SETOFFERDATASETID = "setOfferDataSetId";

    public static final String FUNC_SETOFFERHOLDINGTIMEINMINUTES = "setOfferHoldingTimeInMinutes";

    public static final String FUNC_SETOFFERTOKENAMOUNTPERHOLDER = "setOfferTokenAmountPerHolder";

    public static final String FUNC_SETOFFERLITIGATIONINTERVALINMINUTES = "setOfferLitigationIntervalInMinutes";

    public static final String FUNC_SETOFFERTASK = "setOfferTask";

    public static final String FUNC_SETOFFERDIFFICULTY = "setOfferDifficulty";

    public static final String FUNC_SETOFFERREDLITIGATIONHASH = "setOfferRedLitigationHash";

    public static final String FUNC_SETOFFERGREENLITIGATIONHASH = "setOfferGreenLitigationHash";

    public static final String FUNC_SETOFFERBLUELITIGATIONHASH = "setOfferBlueLitigationHash";

    public static final String FUNC_SETOFFERSTARTTIME = "setOfferStartTime";

    public static final String FUNC_SETOFFERPARAMETERS = "setOfferParameters";

    public static final String FUNC_SETOFFERLITIGATIONHASHES = "setOfferLitigationHashes";

    public static final String FUNC_SETHOLDERS = "setHolders";

    public static final String FUNC_SETHOLDERSTAKEDAMOUNT = "setHolderStakedAmount";

    public static final String FUNC_SETHOLDERPAIDAMOUNT = "setHolderPaidAmount";

    public static final String FUNC_SETHOLDERLITIGATIONENCRYPTIONTYPE = "setHolderLitigationEncryptionType";

    public static final String FUNC_SETHOLDERPAYMENTTIMESTAMP = "setHolderPaymentTimestamp";

    public static final String FUNC_GETHOLDERSTAKEDAMOUNT = "getHolderStakedAmount";

    public static final String FUNC_GETHOLDERPAIDAMOUNT = "getHolderPaidAmount";

    public static final String FUNC_GETHOLDERLITIGATIONENCRYPTIONTYPE = "getHolderLitigationEncryptionType";

    public static final String FUNC_GETHOLDERPAYMENTTIMESTAMP = "getHolderPaymentTimestamp";

    public static final String FUNC_SETHUBADDRESS = "setHubAddress";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected HoldingStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HoldingStorage(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected HoldingStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected HoldingStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> hub() {
        final Function function = new Function(FUNC_HUB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> difficultyOverride() {
        final Function function = new Function(FUNC_DIFFICULTYOVERRIDE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> fingerprint(byte[] param0) {
        final Function function = new Function(FUNC_FINGERPRINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>> holder(byte[] param0, String param1) {
        final Function function = new Function(FUNC_HOLDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple11<String, byte[], BigInteger, BigInteger, BigInteger, byte[], BigInteger, byte[], byte[], byte[], BigInteger>> offer(byte[] param0) {
        final Function function = new Function(FUNC_OFFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple11<String, byte[], BigInteger, BigInteger, BigInteger, byte[], BigInteger, byte[], byte[], byte[], BigInteger>>(function,
                new Callable<Tuple11<String, byte[], BigInteger, BigInteger, BigInteger, byte[], BigInteger, byte[], byte[], byte[], BigInteger>>() {
                    @Override
                    public Tuple11<String, byte[], BigInteger, BigInteger, BigInteger, byte[], BigInteger, byte[], byte[], byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple11<String, byte[], BigInteger, BigInteger, BigInteger, byte[], BigInteger, byte[], byte[], byte[], BigInteger>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (byte[]) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (byte[]) results.get(7).getValue(), 
                                (byte[]) results.get(8).getValue(), 
                                (byte[]) results.get(9).getValue(), 
                                (BigInteger) results.get(10).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getDifficultyOverride() {
        final Function function = new Function(FUNC_GETDIFFICULTYOVERRIDE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setDifficultyOverride(BigInteger new_difficulty) {
        final Function function = new Function(
                FUNC_SETDIFFICULTYOVERRIDE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(new_difficulty)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setFingerprint(byte[] dataSetId, byte[] dataRootHash) {
        final Function function = new Function(
                FUNC_SETFINGERPRINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(dataSetId), 
                new org.web3j.abi.datatypes.generated.Bytes32(dataRootHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getOfferCreator(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERCREATOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> getOfferDataSetId(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERDATASETID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getOfferHoldingTimeInMinutes(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERHOLDINGTIMEINMINUTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getOfferTokenAmountPerHolder(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERTOKENAMOUNTPERHOLDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getOfferLitigationIntervalInMinutes(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERLITIGATIONINTERVALINMINUTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getOfferTask(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERTASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getOfferDifficulty(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERDIFFICULTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getOfferRedLitigationHash(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERREDLITIGATIONHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> getOfferGreenLitigationHash(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERGREENLITIGATIONHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> getOfferBlueLitigationHash(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERBLUELITIGATIONHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getOfferStartTime(byte[] offerId) {
        final Function function = new Function(FUNC_GETOFFERSTARTTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferCreator(byte[] offerId, String creator) {
        final Function function = new Function(
                FUNC_SETOFFERCREATOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(creator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferDataSetId(byte[] offerId, byte[] dataSetId) {
        final Function function = new Function(
                FUNC_SETOFFERDATASETID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Bytes32(dataSetId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferHoldingTimeInMinutes(byte[] offerId, BigInteger holdingTimeInMinutes) {
        final Function function = new Function(
                FUNC_SETOFFERHOLDINGTIMEINMINUTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Uint256(holdingTimeInMinutes)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferTokenAmountPerHolder(byte[] offerId, BigInteger tokenAmountPerHolder) {
        final Function function = new Function(
                FUNC_SETOFFERTOKENAMOUNTPERHOLDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenAmountPerHolder)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferLitigationIntervalInMinutes(byte[] offerId, BigInteger litigationIntervalInMinutes) {
        final Function function = new Function(
                FUNC_SETOFFERLITIGATIONINTERVALINMINUTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Uint256(litigationIntervalInMinutes)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferTask(byte[] offerId, byte[] task) {
        final Function function = new Function(
                FUNC_SETOFFERTASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Bytes32(task)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferDifficulty(byte[] offerId, BigInteger difficulty) {
        final Function function = new Function(
                FUNC_SETOFFERDIFFICULTY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Uint256(difficulty)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferRedLitigationHash(byte[] offerId, byte[] redLitigationHash) {
        final Function function = new Function(
                FUNC_SETOFFERREDLITIGATIONHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Bytes32(redLitigationHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferGreenLitigationHash(byte[] offerId, byte[] greenLitigationHash) {
        final Function function = new Function(
                FUNC_SETOFFERGREENLITIGATIONHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Bytes32(greenLitigationHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferBlueLitigationHash(byte[] offerId, byte[] blueLitigationHash) {
        final Function function = new Function(
                FUNC_SETOFFERBLUELITIGATIONHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Bytes32(blueLitigationHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferStartTime(byte[] offerId, BigInteger startTime) {
        final Function function = new Function(
                FUNC_SETOFFERSTARTTIME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Uint256(startTime)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferParameters(byte[] offerId, String creator, byte[] dataSetId, BigInteger holdingTimeInMinutes, BigInteger tokenAmountPerHolder, BigInteger litigationIntervalInMinutes, byte[] task, BigInteger difficulty) {
        final Function function = new Function(
                FUNC_SETOFFERPARAMETERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(creator), 
                new org.web3j.abi.datatypes.generated.Bytes32(dataSetId), 
                new org.web3j.abi.datatypes.generated.Uint256(holdingTimeInMinutes), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenAmountPerHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(litigationIntervalInMinutes), 
                new org.web3j.abi.datatypes.generated.Bytes32(task), 
                new org.web3j.abi.datatypes.generated.Uint256(difficulty)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setOfferLitigationHashes(byte[] offerId, byte[] redLitigationHash, byte[] greenLitigationHash, byte[] blueLitigationHash) {
        final Function function = new Function(
                FUNC_SETOFFERLITIGATIONHASHES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.generated.Bytes32(redLitigationHash), 
                new org.web3j.abi.datatypes.generated.Bytes32(greenLitigationHash), 
                new org.web3j.abi.datatypes.generated.Bytes32(blueLitigationHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setHolders(byte[] offerId, List<String> identities, List<BigInteger> litigationEncryptionTypes) {
        final Function function = new Function(
                FUNC_SETHOLDERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(identities, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint8>(
                        org.web3j.abi.datatypes.generated.Uint8.class,
                        org.web3j.abi.Utils.typeMap(litigationEncryptionTypes, org.web3j.abi.datatypes.generated.Uint8.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setHolderStakedAmount(byte[] offerId, String identity, BigInteger stakedAmount) {
        final Function function = new Function(
                FUNC_SETHOLDERSTAKEDAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(stakedAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setHolderPaidAmount(byte[] offerId, String identity, BigInteger paidAmount) {
        final Function function = new Function(
                FUNC_SETHOLDERPAIDAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(paidAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setHolderLitigationEncryptionType(byte[] offerId, String identity, BigInteger litigationEncryptionType) {
        final Function function = new Function(
                FUNC_SETHOLDERLITIGATIONENCRYPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(litigationEncryptionType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setHolderPaymentTimestamp(byte[] offerId, String identity, BigInteger paymentTimestamp) {
        final Function function = new Function(
                FUNC_SETHOLDERPAYMENTTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity), 
                new org.web3j.abi.datatypes.generated.Uint256(paymentTimestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getHolderStakedAmount(byte[] offerId, String identity) {
        final Function function = new Function(FUNC_GETHOLDERSTAKEDAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getHolderPaidAmount(byte[] offerId, String identity) {
        final Function function = new Function(FUNC_GETHOLDERPAIDAMOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getHolderLitigationEncryptionType(byte[] offerId, String identity) {
        final Function function = new Function(FUNC_GETHOLDERLITIGATIONENCRYPTIONTYPE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getHolderPaymentTimestamp(byte[] offerId, String identity) {
        final Function function = new Function(FUNC_GETHOLDERPAYMENTTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(offerId), 
                new org.web3j.abi.datatypes.Address(identity)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setHubAddress(String newHubAddress) {
        final Function function = new Function(
                FUNC_SETHUBADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newHubAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static HoldingStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HoldingStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static HoldingStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HoldingStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static HoldingStorage load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new HoldingStorage(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static HoldingStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new HoldingStorage(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<HoldingStorage> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(HoldingStorage.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<HoldingStorage> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(HoldingStorage.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<HoldingStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(HoldingStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<HoldingStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String hubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(hubAddress)));
        return deployRemoteCall(HoldingStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
