package com.leo.zkozz.service;

import com.leo.zkozz.model.Address;
import com.leo.zkozz.model.Company;
import com.leo.zkozz.model.Filial;
import com.leo.zkozz.model.enumeration.Form;
import com.leo.zkozz.model.repository.AddressRepository;
import com.leo.zkozz.model.repository.CompanyRepository;
import com.leo.zkozz.model.repository.FilialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TestService {

    private final Logger logger = LoggerFactory.getLogger(TestService.class);

    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final FilialRepository filialRepository;

    public TestService(AddressRepository addressRepository, CompanyRepository companyRepository, FilialRepository filialRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.filialRepository = filialRepository;
    }

    public Date getTime() {
        return new Date();
    }

    @PostConstruct
    @Transactional
    public void firstFillingDatabase() {

        List<Address> addresses = addressRepository.findAll();
        if (addresses.isEmpty()) {

            Address address1 = new Address();
            address1.setIndex("100000");
            address1.setCity("Moscow");
            address1.setHouse("10");
            address1.setStreet("Dzerzhinsky");
            address1.setRoom("25");

            Address address2 = new Address();
            address2.setIndex("200000");
            address2.setCity("Moscow");
            address2.setHouse("25");
            address2.setStreet("Lenina");
            address2.setRoom("23");

            Address address3 = new Address();
            address3.setIndex("300000");
            address3.setCity("Kiev");
            address3.setHouse("10");
            address3.setStreet("Lenina");
            address3.setRoom("30");

            Address address4 = new Address();
            address4.setIndex("400000");
            address4.setCity("Ufa");
            address4.setHouse("20");
            address4.setStreet("Lenina");
            address4.setRoom("50");

            Address address5 = new Address();
            address5.setIndex("500000");
            address5.setCity("Kazan");
            address5.setHouse("10");
            address5.setStreet("Katanov");
            address5.setRoom("25");

            addressRepository.saveAll(Arrays.asList(address1, address2, address3, address4, address5));

            logger.info("created address");
        }

        List<Company> companies = companyRepository.findAll();
        if (companies.isEmpty()) {
            List<Address> addressesDb = addressRepository.findAll();

            Company company1 = new Company();
            company1.setName("Gazprom");
            company1.setForm(Form.JSC);

            Company company2 = new Company();
            company2.setName("Rosneft");
            company2.setForm(Form.JSC);

            Company company3 = new Company();
            company3.setName("Ivanov");
            company3.setForm(Form.LLC);

            List<Company> companyArrayList = new ArrayList<>();
            companyArrayList.add(company1);
            companyArrayList.add(company2);
            companyArrayList.add(company3);

            List<Company> companiesDb = companyRepository.saveAll(Arrays.asList(company1, company2, company3));

            Company companyDb1 = companiesDb.get(0);
            companyDb1.setAddress(addressesDb.get(0));

            Company companyDb2 = companiesDb.get(1);
            companyDb2.setAddress(addressesDb.get(1));

            Company companyDb3 = companiesDb.get(2);
            companyDb3.setAddress(addressesDb.get(2));

            companyRepository.saveAll(Arrays.asList(companyDb1, companyDb2, companyDb3));

            logger.info("created companies");

        }

        List<Filial> filialList = filialRepository.findAll();
        if (filialList.isEmpty()) {

            List<Company> companiesList = companyRepository.findAll();
            List<Address> addressesDb = addressRepository.findAll();

            Filial filial1 = new Filial();
            filial1.setName("Filial 1");
            filial1.setCompany(companiesList.get(0));

            Filial filial2 = new Filial();
            filial2.setName("Filial 2");
            filial2.setCompany(companiesList.get(1));

            List<Filial> filialListNew = new ArrayList<>();
            filialListNew.add(filial1);
            filialListNew.add(filial2);

            List<Filial> filials = filialRepository.saveAll(Arrays.asList(filial1, filial2));

            Filial filialDb1 = filials.get(0);
            filialDb1.setAddress(addressesDb.get(2));

            Filial filialDb2 = filials.get(1);
            filialDb2.setAddress(addressesDb.get(3));

            filialRepository.saveAll(Arrays.asList(filialDb1, filialDb2));

            logger.info("created filials");

        }

    }
}
