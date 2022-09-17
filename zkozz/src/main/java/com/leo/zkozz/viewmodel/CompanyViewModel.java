package com.leo.zkozz.viewmodel;

import com.leo.zkozz.model.Company;
import com.leo.zkozz.service.CompanyService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import java.util.List;

@VariableResolver(DelegatingVariableResolver.class)
public class CompanyViewModel {

    @WireVariable
    private CompanyService companyService;

    @Init
    public void init() {

    }

    @NotifyChange("companyList")
    public List<Company> getCompanyList() {
        return companyService.findAll();
    }

}
