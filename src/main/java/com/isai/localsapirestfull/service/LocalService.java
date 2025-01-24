package com.isai.localsapirestfull.service;


import com.isai.localsapirestfull.entity.Local;

import java.util.List;

public interface LocalService {
    List<Local> findAllLocals();

    Local saveLocal(Local local);

    Local updateLocal(Long localID, Local local);

    void deleteLocal(Long localID);
}
