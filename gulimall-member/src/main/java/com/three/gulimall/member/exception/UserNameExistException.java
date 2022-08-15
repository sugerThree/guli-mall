package com.three.gulimall.member.exception;

/**
 * @author three
 * @date 2022-08-15 0:39
 */
public class UserNameExistException extends RuntimeException {

    public UserNameExistException() {
        super("存在相同的用户名");
    }
}
