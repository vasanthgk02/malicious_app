package com.google.i18n.phonenumbers.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class RegexCache {
    public LRUCache<String, Pattern> cache;

    public static class LRUCache<K, V> {
        public LinkedHashMap<K, V> map;
        public int size;

        public LRUCache(int i) {
            this.size = i;
            this.map = new LinkedHashMap<K, V>(GeneratedOutlineSupport.outline8(i, 4, 3, 1), 0.75f, true) {
                public boolean removeEldestEntry(Entry<K, V> entry) {
                    return size() > LRUCache.this.size;
                }
            };
        }
    }

    public RegexCache(int i) {
        this.cache = new LRUCache<>(i);
    }

    public Pattern getPatternForRegex(String str) {
        V v;
        LRUCache<String, Pattern> lRUCache = this.cache;
        synchronized (lRUCache) {
            try {
                v = lRUCache.map.get(str);
            }
        }
        Pattern pattern = (Pattern) v;
        if (pattern == null) {
            pattern = Pattern.compile(str);
            LRUCache<String, Pattern> lRUCache2 = this.cache;
            synchronized (lRUCache2) {
                try {
                    lRUCache2.map.put(str, pattern);
                }
            }
        }
        return pattern;
    }
}
