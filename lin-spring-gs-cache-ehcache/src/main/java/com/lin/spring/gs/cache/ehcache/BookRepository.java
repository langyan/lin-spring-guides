package com.lin.spring.gs.cache.ehcache;

public interface BookRepository {

	Book getByIsbn(String isbn);

}
