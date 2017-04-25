/*
 * Copyright 2016-2017 Red Hat, Inc. and/or its affiliates
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
package org.hawkular.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

import javax.ws.rs.core.Response;

import org.hawkular.rest.json.ApiError;

/**
 * @author Lukas Krejci
 * @author Heiko W. Rupp
 * @since 0.0.1
 */
final class ResponseUtil {

    public static Response internalError(String message) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ApiError(message)).type(APPLICATION_JSON_TYPE).build();
    }

    public static Response notFound(String message) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiError(message)).type(APPLICATION_JSON_TYPE).build();
    }

    public static Response ok(Object entity) {
        return Response.status(Response.Status.OK).entity(entity).type(APPLICATION_JSON_TYPE).build();
    }

    public static Response badRequest(String message) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiError(message)).type(APPLICATION_JSON_TYPE).build();
    }
}
