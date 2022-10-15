package com.krauser.service;

import java.util.Collection;

public interface GenericService<T> {

    Collection<T> findAll();

}
