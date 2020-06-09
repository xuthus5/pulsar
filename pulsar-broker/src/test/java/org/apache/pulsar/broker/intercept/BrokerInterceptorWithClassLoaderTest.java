/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.broker.intercept;

import org.apache.pulsar.broker.ServiceConfiguration;
import org.apache.pulsar.common.nar.NarClassLoader;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit test {@link BrokerInterceptorWithClassLoader}.
 */
public class BrokerInterceptorWithClassLoaderTest {

    @Test
    public void testWrapper() throws Exception {
        BrokerInterceptor h = mock(BrokerInterceptor.class);
        NarClassLoader loader = mock(NarClassLoader.class);
        BrokerInterceptorWithClassLoader wrapper = new BrokerInterceptorWithClassLoader(h, loader);

        ServiceConfiguration conf = new ServiceConfiguration();
        wrapper.initialize(conf);
        verify(h, times(1)).initialize(same(conf));
    }

}
