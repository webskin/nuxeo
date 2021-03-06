/*
 * (C) Copyright 2017 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Florent Guillaume
 */
package org.nuxeo.ecm.core.storage.kv;

import java.util.HashMap;
import java.util.Map;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XNodeMap;
import org.nuxeo.common.xmap.annotation.XObject;

/**
 * Descriptor of Key/Value store contribution.
 *
 * @since 9.1
 */
@XObject("store")
public class KeyValueStoreDescriptor {

    @XNode("@name")
    public String name;

    @XNode("@remove")
    public boolean remove;

    @XNode("@class")
    protected Class<? extends KeyValueStoreProvider> klass;

    @XNodeMap(value = "property", key = "@name", type = HashMap.class, componentType = String.class)
    public Map<String, String> properties = new HashMap<String, String>();

    public Class<? extends KeyValueStoreProvider> getKlass() {
        return klass;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

}
