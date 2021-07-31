package com.vertx.examples.dal;

import com.aerospike.client.*;
import com.aerospike.client.async.EventLoop;
import com.aerospike.client.async.EventLoops;
import com.aerospike.client.async.EventPolicy;
import com.aerospike.client.async.NioEventLoops;
import com.aerospike.client.listener.RecordListener;
import com.aerospike.client.listener.WriteListener;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.WritePolicy;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

import javax.inject.Inject;

public class AerospikeService implements  IAerospikeService {

//    @Inject
//    AerospikeService(){}
    private String NAMESPACE = "";
    private String SET = "example";

    private AerospikeClient client;
    private EventLoops eventLoops;

    public AerospikeService(){
        String host = "127.0.0.1";
        int port = 3000;
        ClientPolicy clientPolicy = new ClientPolicy();
        EventPolicy eventPolicy = new EventPolicy();
        eventLoops = new NioEventLoops(eventPolicy, 2);

        clientPolicy.eventLoops = eventLoops;
        clientPolicy.readPolicyDefault.setTimeout(1000);
        clientPolicy.writePolicyDefault.setTimeout(1000);
        Host[] hosts = Host.parseHosts(host, port);
        client = new AerospikeClient(clientPolicy, hosts);
    }

    public void get(Handler<AsyncResult<String>> resultHandler){
        EventLoop eventLoop = eventLoops.next();
        Key key = new Key(NAMESPACE, SET, 12);
        client.get(eventLoop, new RecordListener() {
            @Override
            public void onSuccess(Key key, Record record) {
                System.out.println(record.bins);
                resultHandler.handle(Future.succeededFuture(record.bins.get("value").toString()));
            }

            @Override
            public void onFailure(AerospikeException e) {
                resultHandler.handle(Future.failedFuture(e));
            }
        }, null, key);
    }

    public void set(Handler<AsyncResult<Boolean>> resultHandler){
        EventLoop eventLoop = eventLoops.next();
        Key key = new Key(NAMESPACE, SET, 12);
        WritePolicy writePolicy = client.getWritePolicyDefault();
        writePolicy.expiration = -1;
        Bin bin = new Bin("value", "Bob is happy");
        client.put(eventLoop, new WriteListener() {
            @Override
            public void onSuccess(Key key) {
                resultHandler.handle(Future.succeededFuture(true));
            }

            @Override
            public void onFailure(AerospikeException e) {
                resultHandler.handle(Future.failedFuture(e));
            }
        }, writePolicy, key, bin);

    }


}
