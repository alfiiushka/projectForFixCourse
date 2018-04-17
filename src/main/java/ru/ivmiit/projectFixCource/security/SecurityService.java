package ru.ivmiit.projectFixCource.security;

public interface SecurityService {

    String hashPassword(String password_plaintext);

    boolean checkPassword(String password_plaintext, String stored_hash);
}
