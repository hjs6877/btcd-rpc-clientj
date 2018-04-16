package com.soom.examples;

import com.soom.client.RpcClient;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListUnspentTest {
    private RpcClient rpcClient;

    @Before
    public void before(){
        rpcClient = new RpcClient(RpcTestServerInfo.HOST,
                RpcTestServerInfo.PORT,
                RpcTestServerInfo.USER,
                RpcTestServerInfo.PASSWORD);
    }

    @Test
    public void getAllListUnspentsTest(){
        rpcClient.listUnspent()
                .subscribe(listUnspent ->
                    System.out.println("# number of listunspent : " + listUnspent.getResult().size()));
    }

    @Test
    public void getAllListUnspentsByConfirmTest(){
        rpcClient.listUnspent(0, 1000)
                .subscribe(listUnspent ->
                    System.out.println("# number of confirmed listunspent : " + listUnspent.getResult().size()));
    }

    @Test
    public void getListUnspentsByAddressTest(){
        List<String> addresses = new ArrayList<>();
        addresses.add("mqg3U1C1SrtkQQsDhituMPZvSWTZrmQSsX");

        rpcClient.listUnspent(0, 1000, addresses)
                .subscribe(listUnspent -> {
                   System.out.println("# number of confirmed listunspent : " + listUnspent.getResult().size());

                   Observable.fromIterable(listUnspent.getResult())
                           .subscribe(list -> {
                               System.out.println("==================================================");
                               System.out.println("# txid : " + list.getTxid());
                               System.out.println("# vout : " + list.getVout());
                               System.out.println("# address : " + list.getAddress());
                               System.out.println("# scriptPubKey : " + list.getScriptPubKey());
                               System.out.println("# amount : " + list.getAmount());
                               System.out.println("# confirmations : " + list.getConfirmations());
                               System.out.println("# spendable : " + list.isSpendable());
                               System.out.println("# solvable : " + list.isSolvable());
                               System.out.println("# safe : " + list.isSafe());
                               System.out.println("==================================================");
                           });

                });
    }
}
