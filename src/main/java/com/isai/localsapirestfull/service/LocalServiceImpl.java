package com.isai.localsapirestfull.service;

import com.isai.localsapirestfull.entity.Local;
import com.isai.localsapirestfull.error.LocalNotFoundException;
import com.isai.localsapirestfull.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImpl
        implements LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long localID, Local local) {
        Local localBD = localRepository.findById(localID).get();
        if (Objects.nonNull(local.getCode())
                && !"".equalsIgnoreCase(local.getCode())) {
            localBD.setCode(local.getCode());
        }

        if (Objects.nonNull(local.getName())
                && !"".equalsIgnoreCase(local.getName())) {
            localBD.setName(local.getName());
        }

        if (Objects.nonNull(local.getFloor())
                && !"".equalsIgnoreCase(local.getFloor())) {
            localBD.setFloor(local.getFloor());
        }

        return localRepository.save(localBD);
    }

    @Override
    public void deleteLocal(Long localID) {
        localRepository.deleteById(localID);
    }

    @Override
    public Optional<Local> findLocalByNameJPQL(String name) {
        return localRepository.findLocalByNameJPQL(name);
    }

    public Optional<Local> findByName(String name) {
        return localRepository.findByName(name);
    }

    @Override
    public Optional<Local> findByNameIgnoreCase(String name) {
        return localRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Local findLocalById(Long localID) throws LocalNotFoundException {
        String valueInput = String.valueOf(localID);

        Optional<Local> local = localRepository.findById(localID);
        //si no esta presente este lanza la exception
        if (local.isEmpty()) {
            throw new LocalNotFoundException("Local not found");
        }
        return local.get();
    }


}
