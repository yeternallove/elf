package com.yeternal.elf.common.api;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Optional;

/**
 * <p>
 * 统一API响应结果封装
 * </p>
 *
 * @author eternallove
 * @date Created in 2019/9/17 13:47
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = -7618165659758377287L;

    /**
     * 状态码
     */
    private int code;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 承载数据
     */
    private T data;

    private R(IResultCode resultCode) {
        this(resultCode, resultCode.getReasonPhrase(), null);
    }

    private R(IResultCode resultCode, String msg) {
        this(resultCode, msg, null);
    }

    private R(IResultCode resultCode, T data) {
        this(resultCode, resultCode.getReasonPhrase(), data);
    }

    private R(IResultCode resultCode, String msg, T data) {
        this.code = resultCode.getCode();
        this.msg = msg;
        this.data = data;
        this.success = CommonResultCode.SUCCESS == resultCode;
    }

    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = CommonResultCode.SUCCESS.getCode() == code;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(R<?> result) {
        return Optional.ofNullable(result).map(x -> ObjectUtil.equal(CommonResultCode.SUCCESS.getCode(), x.code)).orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(R<?> result) {
        return !R.isSuccess(result);
    }

    /**
     * 获取data
     *
     * @param result Result
     * @param <T>    泛型标记
     * @return 泛型对象
     */
    public static <T> T getData(R<T> result) {
        return Optional.ofNullable(result).filter(r -> r.success).map(x -> x.getData()).orElse(null);
    }

    /**
     * 返回成功
     *
     * @param <T> 泛型标记
     * @return Result
     */
    public static <T> R<T> success() {
        return new R<>(CommonResultCode.SUCCESS);
    }

    /**
     * 返回成功
     *
     * @param msg 成功消息
     * @return Result
     */
    public static <T> R<T> message(String msg) {
        return new R<>(CommonResultCode.SUCCESS.getCode(), null, msg);
    }

    /**
     * 成功-携带数据
     *
     * @param data 数据
     * @param <T>  泛型标记
     * @return Result
     */
    public static <T> R<T> success(T data) {
        return new R<>(CommonResultCode.SUCCESS, data);
    }

    /**
     * 根据状态返回成功或者失败
     *
     * @param status 状态
     * @param msg    异常msg
     * @param <T>    泛型标记
     * @return Result
     */
    public static <T> R<T> status(boolean status, String msg) {
        return status ? R.success() : R.fail(msg);
    }

    /**
     * 根据状态返回成功或者失败
     *
     * @param status 状态
     * @param sCode  异常code码
     * @param <T>    泛型标记
     * @return Result
     */
    public static <T> R<T> status(boolean status, IResultCode sCode) {
        return status ? R.success() : R.fail(sCode);
    }

    /**
     * 返回失败
     *
     * @param <T> 泛型标记
     * @return Result
     */
    public static <T> R<T> fail() {
        return new R<>(CommonResultCode.FAILURE);
    }

    /**
     * 返回失败信息，用于 web
     *
     * @param msg 失败信息
     * @param <T> 泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(String msg) {
        return new R<>(CommonResultCode.FAILURE, msg);
    }

    /**
     * 返回失败信息
     *
     * @param code 状态码
     * @param msg  失败信息
     * @param <T>  泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(int code, String msg) {
        return new R<>(code, null, msg);
    }

    /**
     * 返回失败信息
     *
     * @param rCode 异常枚举
     * @param <T>   泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(IResultCode rCode) {
        return new R<>(rCode);
    }

    /**
     * 返回失败信息
     *
     * @param rCode 异常枚举
     * @param msg   失败信息
     * @param <T>   泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(IResultCode rCode, String msg) {
        return new R<>(rCode, msg);
    }

    /**
     * 返回失败信息
     *
     * @param rCode 异常枚举
     * @param data  数据
     * @param <T>   泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(IResultCode rCode, T data) {
        return new R<>(rCode, data);
    }

    /**
     * 返回失败信息
     *
     * @param rCode 异常枚举
     * @param msg   失败信息
     * @param data  数据
     * @param <T>   泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(IResultCode rCode, String msg, T data) {
        return new R<>(rCode, msg, data);
    }
}
