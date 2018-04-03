package com.soom.model.request;

import java.util.ArrayList;
import java.util.List;

public class JsonRpcRequest {
    String jsonrpc;
    String id;
    String method;
    public List<Object> params = new ArrayList<>();

    public JsonRpcRequest(String jsonrpc, String id, String method, List<Object> params) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.method = method;
        this.params = params;
    }
}
