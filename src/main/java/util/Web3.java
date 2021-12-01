package util;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.websocket.WebSocketService;

import java.net.ConnectException;

public class Web3 {

    public static Web3j createWeb3(String rpc) throws ConnectException {
        Web3j web3;
        if (rpc.startsWith("wss")) {
            WebSocketService ws = new WebSocketService(rpc, true);
            ws.connect();
            web3 = Web3j.build(ws);
        } else {
            web3 = Web3j.build(new HttpService(rpc));
        }
        return web3;
    }

}
