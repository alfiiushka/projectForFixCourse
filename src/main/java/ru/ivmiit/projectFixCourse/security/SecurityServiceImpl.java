package ru.ivmiit.projectFixCourse.security;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityServiceImpl implements SecurityService {

    @Override
    public String hashPassword(String password_plaintext) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(password_plaintext, salt);
    }

    @Override
    public boolean checkPassword(String password_plaintext, String stored_hash) {
        if(null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        return BCrypt.checkpw(password_plaintext, stored_hash);
    }
}
