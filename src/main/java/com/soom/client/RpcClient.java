package com.soom.client;

import com.soom.model.request.JsonRpcRequest;
import com.soom.model.response.BlockChainInfo;
import com.soom.service.JsonRpcService;
import com.soom.service.ServiceGenerator;
import io.reactivex.Flowable;
import io.reactivex.Single;

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
}
