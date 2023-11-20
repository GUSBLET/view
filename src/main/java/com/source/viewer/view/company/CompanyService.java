package com.source.viewer.view.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company getCompanyOrCreate(String name){
        Optional<Company> company = companyRepository.findByName(name);
        if(company.isPresent())
            return company.get();

        companyRepository.save(Company.builder().name(name).build());

        return companyRepository.findByName(name).get();
    }
}
