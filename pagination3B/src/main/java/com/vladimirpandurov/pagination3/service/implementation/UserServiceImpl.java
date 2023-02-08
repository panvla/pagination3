package com.vladimirpandurov.pagination3.service.implementation;

import com.vladimirpandurov.pagination3.domain.User;
import com.vladimirpandurov.pagination3.repository.UserRepository;
import com.vladimirpandurov.pagination3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("Fetching users for page {} of size {}", page, size);
        return this.userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }

}
