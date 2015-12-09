/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.onion.master;


import com.onion.worker.WorkerDataServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import tachyon.client.RemoteBlockWriter;
import tachyon.worker.WorkerContext;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

public class NettyRemoteBlockAPITest {
    private static WorkerDataServer workerDataServer;

    @BeforeClass
    public static void setup() {
        workerDataServer = new WorkerDataServer(new InetSocketAddress("127.0.0.1", 29999),
                WorkerContext.getConf());
    }

    @AfterClass
    public static void clear() throws IOException {
        workerDataServer.close();
    }

    private static void clearGeneratedFile() {

    }

    @Test
    public void remoteBlockWriteTest() throws IOException {
        RemoteBlockWriter writer = new NettyRemoteBlockWriter();
        writer.open(new InetSocketAddress("127.0.0.1", 29999), 100, 100);
        RandomAccessFile file = new RandomAccessFile(System.getProperty("user.dir") + "/pom.xml", "rw");
        byte[] sendData = new byte[(int) file.length()];
        file.read(sendData);
        writer.write(sendData, 0, sendData.length);
    }

}
