package com.jdai;


import com.jdai.pojo.Customer;
import com.jdai.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@ContextConfiguration("/spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringdataJpaTest {

    @Autowired
    CustomerRepository repository;

    @Test
    public void testR(){
        Optional<Customer> byId = repository.findById(1L);

    }
}
