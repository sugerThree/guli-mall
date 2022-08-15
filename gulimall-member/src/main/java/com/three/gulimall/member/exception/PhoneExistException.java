package com.three.gulimall.member.exception;

/**
 * @author three
 * @date 2022-08-15 0:38
 */
public class PhoneExistException extends RuntimeException {

    public PhoneExistException() {
        super("存在相同的手机号");
    }
}
