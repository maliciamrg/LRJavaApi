package com.maliciamrg.lrjavaapi.dto;

public class AbstractDTO<E> {

    private E idLocal;

    public E getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(E idLocal) {
        this.idLocal = idLocal;
    }
}