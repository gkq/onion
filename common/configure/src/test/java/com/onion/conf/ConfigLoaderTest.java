package com.onion.conf;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
public class ConfigLoaderTest {
    @Test
    public void loadTest() throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/conf.properties");
        properties.load(input);
        System.out.println(properties.getProperty("name"));
    }

    @Test
    public void test() {
        Conf conf = new Conf();
        conf.loadConf(System.getProperty("user.dir") + "/conf.properties");
        System.out.print(conf.getKeys());
    }

}
