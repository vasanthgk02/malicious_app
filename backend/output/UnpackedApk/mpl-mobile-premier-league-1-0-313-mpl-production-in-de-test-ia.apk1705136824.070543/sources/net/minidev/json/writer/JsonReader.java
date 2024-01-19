package net.minidev.json.writer;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONAwareEx;
import net.minidev.json.JSONObject;

public class JsonReader {
    public JsonReaderI<JSONAwareEx> DEFAULT = new DefaultMapper(this);
    public JsonReaderI<JSONAwareEx> DEFAULT_ORDERED = new DefaultMapperOrdered(this);
    public final ConcurrentHashMap<Type, JsonReaderI<?>> cache;

    public JsonReader() {
        ConcurrentHashMap<Type, JsonReaderI<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
        this.cache = concurrentHashMap;
        concurrentHashMap.put(Date.class, BeansMapper.MAPPER_DATE);
        this.cache.put(int[].class, ArraysMapper.MAPPER_PRIM_INT);
        this.cache.put(Integer[].class, ArraysMapper.MAPPER_INT);
        this.cache.put(short[].class, ArraysMapper.MAPPER_PRIM_INT);
        this.cache.put(Short[].class, ArraysMapper.MAPPER_INT);
        this.cache.put(long[].class, ArraysMapper.MAPPER_PRIM_LONG);
        this.cache.put(Long[].class, ArraysMapper.MAPPER_LONG);
        this.cache.put(byte[].class, ArraysMapper.MAPPER_PRIM_BYTE);
        this.cache.put(Byte[].class, ArraysMapper.MAPPER_BYTE);
        this.cache.put(char[].class, ArraysMapper.MAPPER_PRIM_CHAR);
        this.cache.put(Character[].class, ArraysMapper.MAPPER_CHAR);
        this.cache.put(float[].class, ArraysMapper.MAPPER_PRIM_FLOAT);
        this.cache.put(Float[].class, ArraysMapper.MAPPER_FLOAT);
        this.cache.put(double[].class, ArraysMapper.MAPPER_PRIM_DOUBLE);
        this.cache.put(Double[].class, ArraysMapper.MAPPER_DOUBLE);
        this.cache.put(boolean[].class, ArraysMapper.MAPPER_PRIM_BOOL);
        this.cache.put(Boolean[].class, ArraysMapper.MAPPER_BOOL);
        this.cache.put(JSONAwareEx.class, this.DEFAULT);
        this.cache.put(JSONAware.class, this.DEFAULT);
        this.cache.put(JSONArray.class, this.DEFAULT);
        this.cache.put(JSONObject.class, this.DEFAULT);
    }
}
