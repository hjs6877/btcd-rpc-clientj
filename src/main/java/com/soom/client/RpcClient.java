package com.soom.client;

import com.soom.service.JsonRpcService;
import com.soom.service.ServiceGenerator;

public class RpcClient {
    private JsonRpcService jsonRpcService;

    public RpcClient(String host, int port, String user, String password) {
        jsonRpcService = new ServiceGenerator().generateService(JsonRpcService.class,
                                                                host,
                                                                port,
                                                                user,
                                                                password);
    }
}
