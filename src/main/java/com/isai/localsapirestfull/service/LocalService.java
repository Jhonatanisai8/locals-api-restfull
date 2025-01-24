package com.isai.localsapirestfull.service;


import com.isai.localsapirestfull.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    List<Local> findAllLocals();

    Local saveLocal(Local local);

    Local updateLocal(Long localID, Local local);

    void deleteLocal(Long localID);

    Optional<Local> findLocalByNameJPQL(String name);

    Optional<Local> findLocalByName(String name);
}
