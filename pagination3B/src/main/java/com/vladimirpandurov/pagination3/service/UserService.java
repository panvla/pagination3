package com.vladimirpandurov.pagination3.service;

import com.vladimirpandurov.pagination3.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> getUsers(String name, int page, int size);

}
