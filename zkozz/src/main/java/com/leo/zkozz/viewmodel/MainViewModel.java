package com.leo.zkozz.viewmodel;

import com.leo.zkozz.model.Company;
import com.leo.zkozz.service.CompanyService;
import com.leo.zkozz.service.TestService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VariableResolver(DelegatingVariableResolver.class)
public class MainViewModel {

    @WireVariable
    private TestService testService;

    @WireVariable
    private CompanyService companyService;

    Map<String, PageModel<String>> pages = new HashMap<>();
    private PageModel<String> currentPage;

    @Init
    public void init() {
        pages.put("page1", new PageModel<>("~./zul/mvvm-page1.zul", "some data for page 1 (could be a more complex object)"));
        pages.put("page2", new PageModel<>("~./zul/mvvm-page2.zul", "different data for page 2"));
    }

    @Command
    @NotifyChange("currentTime")
    public void updateTime() {
        int x=0;
    }

    public Date getCurrentTime() {
        return testService.getTime();
    }

    @NotifyChange("companyList")
    public List<Company> getCompanyList() {
        return companyService.findAll();
    }

    @Command
    @NotifyChange("currentPage")
    public void navigate(@BindingParam("page") String page) {
        this.currentPage = pages.get(page);
    }

    public PageModel getCurrentPage() {
        return currentPage;
    }
}
