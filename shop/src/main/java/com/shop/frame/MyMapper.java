package com.shop.frame;

import java.util.List;

public interface MyMapper<K,V> {
  // CRUD
  // custmapper.xml에 있는 id와 이름이 같아야 함
  public void insert(V v) throws Exception;
  public void update(V v) throws Exception;
  public void delete(K k) throws Exception;
  public V select(K k) throws Exception;
  public List<V> selectall() throws Exception;
}