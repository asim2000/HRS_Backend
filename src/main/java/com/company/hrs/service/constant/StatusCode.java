package com.company.hrs.service.constant;

public class StatusCode {
    public static final Integer SUCCESS = 200;
    public static final Integer INTERNAL_EXCEPTION = 500;
    public static final Integer EMAIL_EXISTS = 600;
    public static final Integer EMAIL_IS_NOT_AVAILABLE = 601;
    public static final Integer PASSWORD_INCORRECT = 602;
    public static final Integer INVALID_FILE_NAME = 603;
    public static final Integer NOT_FOUND = 404;
    public static final Integer IO_EXCEPTION = 405;
    public static final Integer ValidationException = 406;
    public static final Integer HOTEL_NOT_FOUND_Exception = 407;
    public static final Integer ROLE_EXISTS = 408;
    public static final Integer SERVICE_NOT_FOUND = 409;
    public static final Integer PERSON_NOT_FOUND = 415;
    public static final Integer UN_AUTHORIZATION = 401;
    public static final Integer USERNAME_OR_PASSWORD_INVALID = 405;
    public static final Integer INVALID_AMOUNT_EXCEPTION = 708;
    public static final Integer USER_NOT_FOUND = 402;
    public static final Integer ACCESS_DENIED = 403;

    public static Integer ROOM_NOT_FOUND_Exception = 410;
    public static final Integer CHECK_IN_OR_CHECK_OUT_NULL_EXCEPTION = 411;
    public static final Integer CHECK_IN_IS_NOT_BECOME_BEFORE_FROM_NOW = 412;
}
