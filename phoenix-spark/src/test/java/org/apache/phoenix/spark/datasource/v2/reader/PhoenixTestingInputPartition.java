/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.phoenix.spark.datasource.v2.reader;

import org.apache.phoenix.mapreduce.PhoenixInputSplit;
import org.apache.spark.sql.catalyst.InternalRow;
import org.apache.spark.sql.sources.v2.reader.InputPartitionReader;
import org.apache.spark.sql.types.StructType;

public class PhoenixTestingInputPartition extends PhoenixInputPartition {

    PhoenixTestingInputPartition(PhoenixDataSourceReadOptions options, StructType schema,
            PhoenixInputSplit phoenixInputSplit) {
        super(options, schema, phoenixInputSplit);
    }

    // Override to return a test InputPartitionReader for testing on the executor-side
    @Override
    public InputPartitionReader<InternalRow> createPartitionReader() {
        return new PhoenixTestingInputPartitionReader(getOptions(), getSchema(),
                getPhoenixInputSplit());
    }
}
