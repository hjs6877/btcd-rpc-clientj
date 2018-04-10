package com.soom.service;

import com.soom.model.request.JsonRpcRequest;
import com.soom.model.response.BlockChainInfo;
import com.soom.model.response.ListUnspent;
import com.soom.model.response.SendRawTransaction;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonRpcService {
    @POST("/")
    Single<BlockChainInfo> getBlockChainInfo(@Body JsonRpcRequest jsonRpcRequest);

    @POST("/")
    Single<ListUnspent> listUnspent(@Body JsonRpcRequest jsonRpcRequest);

    @POST("/")
    Completable importAddress(@Body JsonRpcRequest jsonRpcRequest);

    @POST("/")
    Single<SendRawTransaction> sendRawTransaction(@Body JsonRpcRequest jsonRpcRequest);
}
