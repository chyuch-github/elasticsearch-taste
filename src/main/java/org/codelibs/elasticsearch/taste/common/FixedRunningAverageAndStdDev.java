/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelibs.elasticsearch.taste.common;

/**
 * <p>
 * A simple class that represents a fixed value of an average, count and standard deviation. This is useful
 * when an API needs to return {@link RunningAverageAndStdDev} but is not in a position to accept
 * updates to it.
 * </p>
 */
public final class FixedRunningAverageAndStdDev extends FixedRunningAverage
        implements RunningAverageAndStdDev {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final double stdDev;

    public FixedRunningAverageAndStdDev(final double average,
            final double stdDev, final int count) {
        super(average, count);
        this.stdDev = stdDev;
    }

    @Override
    public RunningAverageAndStdDev inverse() {
        return new InvertedRunningAverageAndStdDev(this);
    }

    @Override
    public synchronized String toString() {
        return super.toString() + ',' + stdDev;
    }

    @Override
    public double getStandardDeviation() {
        return stdDev;
    }

}