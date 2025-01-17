/*
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
package io.microsphere.classloading;

import io.microsphere.lang.Prioritized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static io.microsphere.net.URLUtils.resolveBasePath;
import static io.microsphere.reflect.FieldUtils.findField;
import static io.microsphere.reflect.FieldUtils.getFieldValue;
import static io.microsphere.reflect.MethodUtils.invokeMethod;
import static io.microsphere.util.ClassLoaderUtils.resolveClass;
import static java.lang.ClassLoader.getSystemClassLoader;

/**
 * Modern {@link URLClassPathHandle} for {@link jdk.internal.loader.URLClassPath} since JDK 9
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy<a/>
 * @see jdk.internal.loader.URLClassPath
 * @see ClassicURLClassPathHandle
 * @see URLClassPathHandle
 * @since 1.0.0
 */
public class ModernURLClassPathHandle extends AbstractURLClassPathHandle {

    public ModernURLClassPathHandle() {
        setPriority(MAX_PRIORITY + 99999);
    }

    @Override
    protected String getURLClassPathClassName() {
        return "jdk.internal.loader.URLClassPath";
    }

    @Override
    protected String getUrlsFieldName() {
        return "unopenedUrls";
    }
}
