package com.soom.client;

import com.soom.model.request.JsonRpcRequest;
import com.soom.model.response.BlockChainInfo;
import com.soom.model.response.ListUnspent;
import com.soom.service.JsonRpcService;
import com.soom.service.ServiceGenerator;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.Arrays;
import java.util.List;

public class RpcClient {
    private JsonRpcService jsonRpcService;

    public RpcClient(String host, int port, String user, String password) {
        jsonRpcService = new ServiceGenerator().generateService(JsonRpcService.class,
                                                                host,
                                                                port,
                                                                user,
                                                                password);
    }

    public Flowable<BlockChainInfo> getBlockChainInfo() {
        return jsonRpcService.getBlockChainInfo(new JsonRpcRequest(
                "1.0",
                "blockchaininfoData",
                "getblockchaininfo",
                null));
    }

    public Flowable<ListUnspent> listUnspent(){
        return jsonRpcService.listUnspent(new JsonRpcRequest(
                "1.0",
                "listunspent",
                "listunspent",
                null));
    }

    public Flowable<ListUnspent> listUnspent(long min, long max){
        return jsonRpcService.listUnspent(new JsonRpcRequest(
                "1.0",
                "listunspent",
                "listunspent",
                Arrays.asList(min, max)));
    }

    public Flowable<ListUnspent> listUnspent(long min, long max, List<String> addresses){
        return jsonRpcService.listUnspent(new JsonRpcRequest(
                "1.0",
                "listunspent",
                "listunspent",
                Arrays.asList(min, max, addresses)));
    }

    public Completable importAddress(String address){
        return jsonRpcService.importAddress(new JsonRpcRequest(
                "1.0",
                "importaddress",
                "importaddress",
                Arrays.asList(address)));
    }
}
