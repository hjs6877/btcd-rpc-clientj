package com.soom.examples;

import com.soom.client.RpcClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ImportAddressTest {
    private RpcClient rpcClient;

    @Before
    public void before(){
        rpcClient = new RpcClient(RpcTestServerInfo.HOST,
                RpcTestServerInfo.PORT,
                RpcTestServerInfo.USER,
                RpcTestServerInfo.PASSWORD);
    }

    @Test
    public void importAddressTest(){
        String address = "mqg3U1C1SrtkQQsDhituMPZvSWTZrmQSsX"

        rpcClient.importAddress(address)
                .subscribe(() -> {
                    System.out.println("# complete to import address.");
                });
    }
}
