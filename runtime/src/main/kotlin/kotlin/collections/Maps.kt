/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlin.collections

// creates a singleton copy of map, if there is specialization available in target platform, otherwise returns itself
internal inline actual fun <K, V> Map<K, V>.toSingletonMapOrSelf(): Map<K, V> = toSingletonMap()

// creates a singleton copy of map
internal actual fun <K, V> Map<out K, V>.toSingletonMap(): Map<K, V>
        = this.toMutableMap() // TODO


internal actual object EmptyMap : Map<Any?, Nothing> {

    actual override fun equals(other: Any?): Boolean = other is Map<*, *> && other.isEmpty()
    actual override fun hashCode(): Int = 0
    actual override fun toString(): String = "{}"

    actual override val size: Int get() = 0
    actual override fun isEmpty(): Boolean = true

    actual override fun containsKey(key: Any?): Boolean = false
    actual override fun containsValue(value: Nothing): Boolean = false
    actual override fun get(key: Any?): Nothing? = null
    actual override val entries: Set<Map.Entry<Any?, Nothing>> get() = EmptySet
    actual override val keys: Set<Any?> get() = EmptySet
    actual override val values: Collection<Nothing> get() = EmptyList
}