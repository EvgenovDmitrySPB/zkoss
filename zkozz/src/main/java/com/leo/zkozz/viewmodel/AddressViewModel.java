package com.leo.zkozz.viewmodel;

import com.leo.zkozz.model.Address;
import com.leo.zkozz.service.AddressService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import java.util.List;

@VariableResolver(DelegatingVariableResolver.class)
public class AddressViewModel {

    @WireVariable
    private AddressService addressService;

    @Init
    public void init() {

    }

    @NotifyChange("addressList")
    public List<Address> getAddressList() {
        return addressService.findAll();
    }

}
