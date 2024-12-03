package com.ffzu.pojo;

import com.ffzu.response.Base;
import java.lang.String;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Base base;
    private T data;

    public static <E> Result<E> success(E data) {
        return new Result<>(new Base(0, "操作成功"),data);
    }


    public static Result success() {
        return new Result(new Base(0, "操作成功"),null);
    }

    public static Result error(String message) {
        return new Result(new Base(-1, message),null);
    }

}

