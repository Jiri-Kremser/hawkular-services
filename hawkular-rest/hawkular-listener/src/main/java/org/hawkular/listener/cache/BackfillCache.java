/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.listener.cache;

/**
 * Interface for backfill cache access and management.
 *
 * @author Jay Shaughnessy
 */
public interface BackfillCache extends ClusterCache {

    /**
     * Records that we have received UP availability for the given feedAvailabilityMetricId. Ignored
     * if the current server is not processing the relevant feed.
     *
     * @param tenantId The tenant for the feed
     * @param feedAvailabilityMetricId The feed avail metricId
     */
    void updateFeedAvailability(String tenantId, String feedAvailabilityMetricId);

    /**
     * Request an immediate backfill for the given feed [on all of its registered tenants]. Typically
     * called when we know a feed is down and don't want to wait for the ping detection to timeout.
     * Ignored if the current server is not processing the relevant feed.
     *
     * @param feedId The feed to force backfilling
     */
    void forceBackfill(String feedId);

}
