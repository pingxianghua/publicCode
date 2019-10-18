package com.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builderpublic class ResponseDTO<T> {

	/**
	 * 调用是否成功
	 */
    @Builder.Default
    private boolean result = true;

    /**
     * 状态码
     */
    @Builder.Default
    private String code = "200";

    /**
     * 结果消息
     */
    @Builder.Default
    private String msg = "";

    /**
     * 响应数据
     */
    private T data;

    /**    
     * <p> 返回成功结果，无返回结果集 </p >
     *  
     * @return ResponseDTO<T>
     */
    public static <T> ResponseDTO<T> success() {
        return success(null);
    }

    /**    
     * <p> 返回成功结果，有返回结果集 </p >
     *  
     * @return ResponseDTO<T>
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseDTO<T> success(T data) {
        return ((ResponseDTO<T>) ResponseDTO.builder().result(true).code("200").msg("").data(data).build());
    }
    
    /**    
     * <p> 返回失败结果，无返回结果集 </p >
     *  
     * @return ResponseDTO<T>
     */
    public static <T> ResponseDTO<T> error() {
        return error(null);
    }
    
    /**    
     * <p> 返回失败结果，有返回结果集 </p >
     *  
     * @return ResponseDTO<T>
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseDTO<T> error(T data) {
        return ((ResponseDTO<T>) ResponseDTO.builder().result(false).data(data).build());
    }
}
