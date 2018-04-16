package com.soom.examples;

import com.soom.client.RpcClient;
import com.soom.model.response.BlockChainInfo;
import io.reactivex.Flowable;
import org.junit.Before;
import org.junit.Test;

public class BlockChainInfoTest {
    private RpcClient rpcClient;

    @Before
    public void before(){
        rpcClient = new RpcClient(RpcTestServerInfo.HOST,
                RpcTestServerInfo.PORT,
                RpcTestServerInfo.USER,
                RpcTestServerInfo.PASSWORD);
    }

    @Test
    public void getBlockChainInfoTest() {
        Flowable<BlockChainInfo> source = rpcClient.getBlockChainInfo();
        source.subscribe(blockChainInfo -> {
            System.out.println("# chain : " + blockChainInfo.getResult().getChain());
            System.out.println("# blocks : " + blockChainInfo.getResult().getBlocks());
            System.out.println("# headers : " + blockChainInfo.getResult().getHeaders());
            System.out.println("# bestblockhash : " + blockChainInfo.getResult().getBestBlockHash());
            System.out.println("# difficulty : " + blockChainInfo.getResult().getDifficulty());
            System.out.println("# mediantime : " + blockChainInfo.getResult().getMedianTime());
            System.out.println("# verificationprogress : " + blockChainInfo.getResult().getVerificationProgress());
            System.out.println("# initialblockdownload : " + blockChainInfo.getResult().isInitialBlockDownload());
            System.out.println("# chainwork : " + blockChainInfo.getResult().getChainwork());
            System.out.println("# size_on_disk : " + blockChainInfo.getResult().getSizeOnDisk());
            System.out.println("# pruned : " + blockChainInfo.getResult().isPruned());
            System.out.println("# warnings : " + blockChainInfo.getResult().getWarnings());
        });

        // uncomment this and then set your time not to finish the test case, if it takes long to connect to bitcoind
        //Thread.sleep(2000);
    }

    @Test
    public void getSoftForksTest(){
        System.out.println("## softforks ##");
        rpcClient.getBlockChainInfo()
                .flatMap(blockChainInfo -> Flowable.fromIterable(blockChainInfo.getResult().getSoftforks()))
                .subscribe(softForks -> {
                    System.out.println("==================================================");
                    System.out.println("# id : " + softForks.getId());
                    System.out.println("# version : " + softForks.getVersion());
                    System.out.println("# reject : " + softForks.getReject().isStatus());
                    System.out.println("==================================================");
                });
    }

    @Test
    public void getBig9SoftForksTest(){
        System.out.println("## big9_softforks ## ");

        rpcClient.getBlockChainInfo()
                .subscribe(blockChainInfo -> {
                    System.out.println("## csv ## ");
                    System.out.println("# status : " + blockChainInfo.getResult().getBip9Softforks().getCsv().getStatus());
                    System.out.println("# startTime : " + blockChainInfo.getResult().getBip9Softforks().getCsv().getStartTime());
                    System.out.println("# timeout : " + blockChainInfo.getResult().getBip9Softforks().getCsv().getTimeOut());
                    System.out.println("# since : " + blockChainInfo.getResult().getBip9Softforks().getCsv().getSince());

                    System.out.println("==================================================");

                    System.out.println("## segwit ## ");
                    System.out.println("# status : " + blockChainInfo.getResult().getBip9Softforks().getSegwit().getStatus());
                    System.out.println("# startTime : " + blockChainInfo.getResult().getBip9Softforks().getSegwit().getStartTime());
                    System.out.println("# timeout : " + blockChainInfo.getResult().getBip9Softforks().getSegwit().getTimeOut());
                    System.out.println("# since : " + blockChainInfo.getResult().getBip9Softforks().getSegwit().getSince());
                });
    }
}
