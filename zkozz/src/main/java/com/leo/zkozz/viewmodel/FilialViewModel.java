package com.leo.zkozz.viewmodel;

import com.leo.zkozz.model.Filial;
import com.leo.zkozz.service.FilialService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import java.util.List;

@VariableResolver(DelegatingVariableResolver.class)
public class FilialViewModel {

    @WireVariable
    private FilialService filialService;

    @Init
    public void init() {

    }

    @NotifyChange("filialList")
    public List<Filial> getFilialList() {
        return filialService.findAll();
    }

}
