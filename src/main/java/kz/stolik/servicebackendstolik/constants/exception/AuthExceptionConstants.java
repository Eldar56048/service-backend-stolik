package kz.stolik.servicebackendstolik.constants.exception;

public class AuthExceptionConstants {
    public static final String TOKEN_EXPIRED_MESSAGE = "Срок действия токена истек";
    public static final String TOKEN_EXPIRED_CODE = "auth/token-expired";
    public static final String FETCH_USERNAME_FROM_TOKEN_ERROR_MESSAGE = "Произошла ошибка при получении имени пользователя из токена";
    public static final String FETCH_USERNAME_FROM_TOKEN_ERROR_CODE = "auth/fetch-username-from-token-error";
    public static final String INVALID_USERNAME_OR_PASSWORD_MESSAGE = "Ошибка аутентификации. Имя пользователя или пароль недействительны";
    public static final String INVALID_USERNAME_OR_PASSWORD_CODE = "auth/invalid-username-or-password";
    public static final String INVALID_TOKEN_MESSAGE = "Неверный формат пользовательского токена";
    public static final String INVALID_TOKEN_CODE = "auth/invalid-token";
    public static final String TOKEN_NOT_FOUND_MESSAGE = "Не удалось найти токен";
    public static final String TOKEN_NOT_FOUND_CODE = "auth/token-not-found";
    public static final String ACCOUNT_BLOCKED_MESSAGE = "Ваш аккаунт заблокирован";
    public static final String ACCOUNT_BLOCKED_CODE = "auth/account-blocked";
    public static final String SOMETHING_WENT_WRONG_MESSAGE = "Что-то пошло не так";
}
